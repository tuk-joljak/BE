package com.example.graduation_work_BE.openai.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OpenAiResponseDTO {
    private List<String> responses;
}
