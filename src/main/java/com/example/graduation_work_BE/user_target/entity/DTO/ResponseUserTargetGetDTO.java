package com.example.graduation_work_BE.user_target.entity.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseUserTargetGetDTO {
    UUID userTargetId;

    String targetContent;
    String startTime;
    String endTime;

    Boolean isFinish;
}
