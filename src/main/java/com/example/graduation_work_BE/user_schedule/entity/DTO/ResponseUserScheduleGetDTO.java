package com.example.graduation_work_BE.user_schedule.entity.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseUserScheduleGetDTO {
    UUID userScheduleId;

    String scheduleContent;
    String startDate;
    String endDate;

    Boolean isFinish;
}
