package com.example.graduation_work_BE.openai.service;

import com.example.graduation_work_BE.openai.DTO.OpenAiResponseDTO;
import com.example.graduation_work_BE.openai.config.OpenAiConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OpenAiService {

    private final WebClient webClient;
    private final OpenAiConfig openAiConfig;

    public OpenAiService(WebClient.Builder webClientBuilder, OpenAiConfig openAiConfig) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
        this.openAiConfig = openAiConfig;
    }

    // ✅ getCompletion() 메서드를 messages 기반으로 수정
    public Mono<OpenAiResponseDTO> getCompletion(List<Map<String, String>> messages) {
        log.info("📌 OpenAiService - OpenAI API 호출 시작!");
        log.info("📌 사용 API 키: {}", openAiConfig.getApiKey());

        return webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + openAiConfig.getApiKey())  // API 키 추가
                .header("Content-Type", "application/json")
                .bodyValue(Map.of(
                        "model", openAiConfig.getModel(),
                        "messages", messages,  // ✅ prompt 대신 messages 전체 전달
                        "temperature", openAiConfig.getTemperature(),
                        "max_tokens", openAiConfig.getMaxTokens()
                ))
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    log.info("📌 OpenAiService - OpenAI API 응답: {}", response);

                    List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices == null || choices.isEmpty()) {
                        throw new RuntimeException("No choices found in OpenAI response");
                    }

                    Map<String, Object> firstChoice = choices.get(0);
                    Map<String, Object> message = (Map<String, Object>) firstChoice.get("message");
                    if (message == null) {
                        throw new RuntimeException("No message found in OpenAI response");
                    }

                    String content = (String) message.get("content");
                    if (content == null) {
                        throw new RuntimeException("No content found in OpenAI response");
                    }

                    return new OpenAiResponseDTO(content);
                });
    }
}