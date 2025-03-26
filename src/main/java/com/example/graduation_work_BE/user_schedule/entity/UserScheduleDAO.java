package com.example.graduation_work_BE.user_schedule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserScheduleDAO {
    @Id
    UUID userScheduleId;

    UUID userId;

    String scheduleContent;
    String startDate;
    String endDate;

    Boolean isFinish;

    LocalDateTime createAt;
    LocalDateTime uploadAt;
}
