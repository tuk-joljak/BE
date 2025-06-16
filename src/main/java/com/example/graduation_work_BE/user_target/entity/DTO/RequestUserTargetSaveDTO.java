package com.example.graduation_work_BE.user_target.entity.DTO;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RequestUserTargetSaveDTO {
    UUID userId;

    String targetContent;

}
