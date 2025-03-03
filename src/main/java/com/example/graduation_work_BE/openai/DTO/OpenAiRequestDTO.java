package com.example.graduation_work_BE.openai.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OpenAiRequestDTO {
    @NotEmpty(message = "messages 필드는 비워둘 수 없습니다.")
    private List<Map<String, String>> messages;  // messages 필드 검증
}