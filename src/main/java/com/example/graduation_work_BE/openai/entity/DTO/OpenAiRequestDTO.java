package com.example.graduation_work_BE.openai.entity.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.bridge.Message;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class OpenAiRequestDTO {
    @NotEmpty(message = "messages 필드는 비워둘 수 없습니다.")
    private List<MessageDTO> messages;
}
