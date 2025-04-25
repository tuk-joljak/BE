package com.example.graduation_work_BE.openai.controller;

import com.example.graduation_work_BE.openai.entity.DTO.OpenAiRequestDTO;
import com.example.graduation_work_BE.openai.entity.DTO.OpenAiResponseDTO;
import com.example.graduation_work_BE.openai.service.OpenAiService;
import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import com.example.graduation_work_BE.job_posting.service.JobPostingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/openai")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class OpenAiController {

    private final OpenAiService openAiService;
    private final JobPostingService jobPostingService;

    @PostMapping("/chat")
    public Mono<ResponseEntity<OpenAiResponseDTO>> chatWithOpenAi(@RequestBody OpenAiRequestDTO openAiRequestDTO) {
        return openAiService.getCompletion(openAiRequestDTO.getMessages().stream()
                        .map(msg -> Map.of("role", msg.getRole(), "content", msg.getContent()))
                        .toList())
                .map(ResponseEntity::ok);
    }

    @PostMapping(value = "/analyze", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<ResponseEntity<Map<String, Object>>> analyzeResumeSkills(@RequestParam("resume") MultipartFile resumeFile) {
        log.info("📌 이력서 기술 분석 요청 시작");

        return Mono.fromCallable(() -> extractTextFromPdf(resumeFile))
                .flatMap(resumeText -> {
                    List<String> resumeSkills = extractSkillsFromResume(resumeText);
                    List<JobPostingDAO> jobPostings = jobPostingService.getRecommendedJobPostings(resumeSkills);
                    Map<String, List<String>> skillComparison = compareSkills(resumeSkills, jobPostings);

                    String prompt = buildPrompt(resumeSkills, skillComparison.get("missingSkills"));

                    return openAiService.sendChatCompletionWithPrompt(prompt)
                            .map(aiResponse -> {
                                Map<String, Object> response = new HashMap<>();
                                response.put("commonSkills", skillComparison.get("commonSkills"));
                                response.put("missingSkills", skillComparison.get("missingSkills"));
                                response.put("recommendations", aiResponse.getResponses());
                                response.put("recommendedJobs", jobPostings);
                                return ResponseEntity.ok(response);
                            });
                });
    }

    private String extractTextFromPdf(MultipartFile file) throws IOException {
        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }

    private List<String> extractSkillsFromResume(String resumeText) {
        List<String> TECH_KEYWORDS = List.of(
                "Java", "Python", "JavaScript", "Spring", "Spring Boot", "Node.js", "React", "Vue", "Angular",
                "Django", "Flask", "Express", "MySQL", "PostgreSQL", "MongoDB", "AWS", "Docker", "Kubernetes",
                "Redis", "GraphQL", "TypeScript", "Swift", "Kotlin", "C++", "C#", "Go", "Ruby", "Rust"
        );

        return TECH_KEYWORDS.stream()
                .filter(skill -> resumeText.toLowerCase().contains(skill.toLowerCase()))
                .collect(Collectors.toList());
    }

    private Map<String, List<String>> compareSkills(List<String> resumeSkills, List<JobPostingDAO> jobPostings) {
        Set<String> jobSkills = jobPostings.stream()
                .flatMap(job -> Arrays.stream(job.getStack().split(",")))
                .map(String::trim)
                .collect(Collectors.toSet());

        List<String> commonSkills = resumeSkills.stream()
                .filter(jobSkills::contains)
                .collect(Collectors.toList());

        List<String> missingSkills = jobSkills.stream()
                .filter(skill -> !resumeSkills.contains(skill))
                .collect(Collectors.toList());

        return Map.of(
                "commonSkills", commonSkills,
                "missingSkills", missingSkills
        );
    }

    private String buildPrompt(List<String> resumeSkills, List<String> missingSkills) {
        return """
            다음은 사용자의 이력서에서 추출한 기술입니다:
            %s

            다음은 채용공고에서 요구하는 기술 중 사용자가 갖추지 못한 기술입니다:
            %s

            이력서가 이 채용공고에 적합한지 평가해 주세요.
            부족한 기술을 보완하기 위한 학습 방법과 추천 자료도 제공해 주세요.
            """.formatted(String.join(", ", resumeSkills), String.join(", ", missingSkills));
    }
}