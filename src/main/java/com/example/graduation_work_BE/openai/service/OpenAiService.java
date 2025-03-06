package com.example.graduation_work_BE.openai.service;

import com.example.graduation_work_BE.openai.entity.DTO.OpenAiResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OpenAiService {

    private final WebClient webClient;
    private final String apiKey = "your-openai-api-key";
    private final String model = "gpt-4";

    public Mono<OpenAiResponseDTO> suggestSkillsImprovement(List<String> missingSkills) {
        String prompt = """
            아래는 사용자가 부족한 기술 목록입니다.
            해당 기술들을 학습하고 보완하는 방법을 설명해 주세요.
            
            📌 부족한 기술:
            %s

            ✅ 학습 방법과 추천 자료를 제공해 주세요.
            """.formatted(String.join(", ", missingSkills));

        return webClient.post()
                .uri("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(Map.of(
                        "model", model,
                        "messages", List.of(Map.of("role", "user", "content", prompt)),
                        "temperature", 0.7,
                        "max_tokens", 300
                ))
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> new OpenAiResponseDTO((List<String>) response.get("choices")));
    }
}
