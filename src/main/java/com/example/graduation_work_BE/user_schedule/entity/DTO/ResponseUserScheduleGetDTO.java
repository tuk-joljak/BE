package com.example.graduation_work_BE.user_schedule.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserScheduleGetDTO {
    String scheduleContent;
    String startDate;
    String endDate;

    Boolean isFinish;
}
