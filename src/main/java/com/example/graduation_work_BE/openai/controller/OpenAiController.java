package com.example.graduation_work_BE.openai.controller;

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
public class OpenAiController {

    private final OpenAiService openAiService;
    private final JobPostingService jobPostingService;

    /**
     * 🟢 기본 채팅 API (사용자 입력을 OpenAI에 전달)
     */
    @PostMapping("/chat")
    public Mono<ResponseEntity<OpenAiResponseDTO>> chatWithOpenAi(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");
        log.info("📩 사용자 채팅 요청: {}", userMessage);
        return openAiService.chatWithOpenAi(userMessage)
                .map(ResponseEntity::ok);
    }

    /**
     * 🔵 이력서 스킬 분석 API (PDF 업로드)
     * - `multipart/form-data` 요청을 받아 PDF 파일을 처리
     * - PDF에서 텍스트 추출 후 기술 분석 수행
     */
    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<ResponseEntity<Map<String, Object>>> analyzeResumeSkills(
            @RequestParam("resume") MultipartFile resumeFile) {
        log.info("📌 이력서 기술 분석 요청 시작");

        return Mono.fromCallable(() -> extractTextFromPdf(resumeFile))
                .flatMap(resumeText -> {
                    List<String> resumeSkills = extractSkillsFromResume(resumeText);
                    List<JobPostingDAO> jobPostings = jobPostingService.getRecommendedJobPostings(resumeSkills);
                    Map<String, List<String>> skillComparison = compareSkills(resumeSkills, jobPostings);

                    return openAiService.suggestSkillsImprovement(skillComparison.get("missingSkills"))
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

    /**
     * ✅ PDF 파일에서 텍스트 추출하는 메서드
     */
    private String extractTextFromPdf(MultipartFile file) throws IOException {
        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }

    /**
     * ✅ 이력서에서 기술 스택을 추출하는 메서드
     */
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

    /**
     * ✅ 이력서 기술과 채용 공고 기술 비교
     */
    private Map<String, List<String>> compareSkills(List<String> resumeSkills, List<JobPostingDAO> jobPostings) {
        Set<String> jobSkills = jobPostings.stream()
                .flatMap(job -> List.of(job.getStack().split(",")).stream())
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
}
