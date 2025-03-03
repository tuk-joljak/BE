package com.example.graduation_work_BE.openai.controller;

import com.example.graduation_work_BE.openai.DTO.OpenAiRequestDTO;
import com.example.graduation_work_BE.openai.DTO.OpenAiResponseDTO;
import com.example.graduation_work_BE.openai.service.OpenAiService;
import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/openai")
@Slf4j
public class OpenAiController {

    private final OpenAiService openAiService;

    @Autowired
    public OpenAiController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping("/chat")
    public Mono<OpenAiResponseDTO> chat(@RequestBody @Valid OpenAiRequestDTO requestDTO) {
        log.info("openAiController - chat() 메서드 실행됨");
        log.debug("📌 OpenAI 요청 데이터: {}", requestDTO.getMessages());

        // OpenAiService에 messages 리스트를 전달
        return openAiService.getCompletion(requestDTO.getMessages());
    }
}