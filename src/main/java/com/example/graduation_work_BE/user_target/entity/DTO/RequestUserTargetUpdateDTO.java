package com.example.graduation_work_BE.user_target.entity.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestUserTargetUpdateDTO {
    UUID userTargetId;

    String targetContent;
    String startTime;
    String endTime;
}
