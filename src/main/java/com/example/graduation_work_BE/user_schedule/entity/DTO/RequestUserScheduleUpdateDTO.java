package com.example.graduation_work_BE.user_schedule.entity.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestUserScheduleUpdateDTO {
    UUID userScheduleId;

    String scheduleContent;
    String startDate;
    String endDate;
}
