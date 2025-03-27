package com.example.graduation_work_BE.user_schedule.entity.DTO;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RequestUserScheduleSaveDTO {
    UUID userId;

    String scheduleContent;
    String startDate;
    String endDate;
}
