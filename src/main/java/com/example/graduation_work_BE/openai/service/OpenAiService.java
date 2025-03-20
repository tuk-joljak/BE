package com.example.graduation_work_BE.openai.service;

import com.example.graduation_work_BE.openai.config.OpenAiConfig;
import com.example.graduation_work_BE.openai.entity.DTO.OpenAiResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenAiService {

    private final WebClient webClient;
    private final OpenAiConfig openAiConfig; // ✅ OpenAI 환경설정 객체 주입

    /**
     * 🟢 기본 OpenAI 채팅 기능
     */
    public Mono<OpenAiResponseDTO> chatWithOpenAi(String userMessage) {
        log.info("📤 OpenAI 채팅 요청: {}", userMessage);

        return webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer " + openAiConfig.getApiKey()) // ✅ API 키 설정
                .header("Content-Type", "application/json")
                .bodyValue(Map.of(
                        "model", openAiConfig.getModel(),
                        "messages", List.of(Map.of("role", "user", "content", userMessage)),
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
     * ✅ OpenAI Chat Completion 요청
     */
    public Mono<OpenAiResponseDTO> getCompletion(List<Map<String, String>> messages) {
        log.info("📌 OpenAiService - OpenAI API 호출 시작!");

        return webClient.post()
                .uri("https://api.openai.com/v1/chat/completions") // ✅ 전체 URL 사용
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
     * 🔵 OpenAI를 활용한 이력서 스킬 분석 및 추천 기능
     */
    public Mono<OpenAiResponseDTO> suggestSkillsImprovement(List<String> missingSkills) {
        if (openAiConfig.getApiKey() == null || openAiConfig.getApiKey().isBlank()) {
            log.error("❌ OpenAI API 키가 설정되지 않았습니다.");
            return Mono.error(new RuntimeException("OpenAI API 키가 설정되지 않았습니다."));
        }

        String prompt = """
            아래는 사용자가 부족한 기술 목록입니다.
            해당 기술들을 학습하고 보완하는 방법을 설명해 주세요.

            📌 부족한 기술:
            %s

            ✅ 학습 방법과 추천 자료를 제공해 주세요.
            """.formatted(String.join(", ", missingSkills));

        log.info("📤 OpenAI 스킬 추천 요청: {}", prompt);

        return webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer " + openAiConfig.getApiKey())
                .header("Content-Type", "application/json")
                .bodyValue(Map.of(
                        "model", openAiConfig.getModel(),
                        "messages", List.of(Map.of("role", "user", "content", prompt)),
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
     * 🟡 OpenAI 응답에서 텍스트 추출하는 메서드
     */
    private OpenAiResponseDTO extractResponse(Map<String, Object> response) {
        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
        if (choices == null || choices.isEmpty()) {
            return new OpenAiResponseDTO(List.of("응답을 받을 수 없습니다."));
        }

        Map<String, Object> firstChoice = choices.get(0);
        Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");
        if (message == null || !message.containsKey("content")) {
            return new OpenAiResponseDTO(List.of("OpenAI 응답 오류: 메시지가 없습니다."));
        }

        String aiResponse = (String) message.get("content");
        return new OpenAiResponseDTO(List.of(aiResponse));
    }
}
