package com.example.graduation_work_BE.openai.entity.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    @NotBlank(message = "role은 비워둘 수 없습니다.")
    private String role;

    @NotBlank(message = "content는 비워둘 수 없습니다.")
    private String content;
}
