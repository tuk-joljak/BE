package com.example.graduation_work_BE.openai.service;

import com.example.graduation_work_BE.openai.config.OpenAiConfig;
import com.example.graduation_work_BE.openai.entity.DTO.OpenAiResponseDTO;
import com.example.graduation_work_BE.resume.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenAiService {

    private final WebClient webClient;
    private final OpenAiConfig openAiConfig;

    /**
     * OpenAI Chat Completion 공통 호출 메서드
     */
    /**
     * ✅ OpenAI Chat Completion 요청
     */
    public Mono<OpenAiResponseDTO> getCompletion(List<Map<String, String>> messages) {
        log.info("📌 OpenAiService - OpenAI API 호출 시작!");

        return webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer " + openAiConfig.getApiKey())
                .header("Content-Type", "application/json")
                .bodyValue(Map.of(
                        "model", openAiConfig.getModel(),
                        "messages", messages,
                        "temperature", openAiConfig.getTemperature(),
                        "max_tokens", openAiConfig.getMaxTokens()
                ))
                .retrieve()
                .onStatus(HttpStatusCode::isError, response ->
                        response.bodyToMono(String.class)
                                .flatMap(errorBody -> {
                                    log.error("🚨 OpenAI API 오류 응답: {}", errorBody);
                                    return Mono.error(new RuntimeException("OpenAI API 오류: " + errorBody));
                                })
                )
                .bodyToMono(Map.class)
                .doOnSuccess(response -> log.info("📥 OpenAI 응답: {}", response))
                .map(this::extractResponse);
    }


    /**
     * 사용자 메시지 기반 Chat 요청
     */
    public Mono<OpenAiResponseDTO> chatWithOpenAi(String userMessage) {
        List<Map<String, String>> messages = List.of(Map.of(
                "role", "user",
                "content", userMessage
        ));
        return sendChatCompletion(messages);
    }

    /**
     * 프롬프트 기반 Chat 요청
     */
    public Mono<OpenAiResponseDTO> sendChatCompletionWithPrompt(String prompt) {
        List<Map<String, String>> messages = List.of(Map.of(
                "role", "user",
                "content", prompt
        ));
        return sendChatCompletion(messages);
    }

    private Mono<OpenAiResponseDTO> sendChatCompletion(List<Map<String, String>> messages) {
        return webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer " + openAiConfig.getApiKey())
                .header("Content-Type", "application/json")
                .bodyValue(Map.of(
                        "model", openAiConfig.getModel(),
                        "messages", messages,
                        "temperature", openAiConfig.getTemperature(),
                        "max_tokens", openAiConfig.getMaxTokens()
                ))
                .retrieve()
                .onStatus(HttpStatusCode::isError, response ->
                        response.bodyToMono(String.class)
                                .flatMap(error -> Mono.error(new RuntimeException("OpenAI 오류: " + error)))
                )
                .bodyToMono(Map.class)
                .map(this::extractResponse);
    }


    /**
     * 응답 파싱
     */
    private OpenAiResponseDTO extractResponse(Map<String, Object> response) {
        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
        if (choices == null || choices.isEmpty()) {
            return new OpenAiResponseDTO(List.of("응답을 받을 수 없습니다."));
        }

        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
        if (message == null || !message.containsKey("content")) {
            return new OpenAiResponseDTO(List.of("OpenAI 응답 오류: 메시지가 없습니다."));
        }

        String content = (String) message.get("content");
        return new OpenAiResponseDTO(List.of(content));
    }

    public String buildResumeText(ResumeDAO resume) {
        StringBuilder sb = new StringBuilder();

        sb.append("기술 스택: ").append(
                resume.getTechStackDAOS().stream()
                        .map(TechStackDAO::getStack)
                        .collect(Collectors.joining(", "))
        ).append("\n\n");

        sb.append("경력:\n");
        for (CareerDAO c : resume.getCareerDAOs()) {
            sb.append("- ").append(c.getCompanyName())
                    .append(" / ").append(c.getPosition())
                    .append(" / ").append(c.getDepartment())
                    .append(" / ").append(c.getWorkingPeriod())
                    .append(" / ").append(c.getResponsibility())
                    .append("\n");
        }

        sb.append("\n프로젝트 경험:\n");
        for (ProjectDAO p : resume.getProjectDAOS()) {
            sb.append("- ").append(p.getProjectName())
                    .append(" @ ").append(p.getOrganization())
                    .append(" (").append(p.getStartDate()).append(" ~ ").append(p.getEndDate()).append(")\n")
                    .append(p.getDescription()).append("\n");
        }

        sb.append("\n희망 직무: ");
        for (JobCategoryDAO j : resume.getJobCategoryDAOS()) {
            sb.append(j.getHopeJobGroup()).append(" - ").append(String.join(", ", j.getHopeJobRole())).append("\n");
        }

        return sb.toString();
    }

}