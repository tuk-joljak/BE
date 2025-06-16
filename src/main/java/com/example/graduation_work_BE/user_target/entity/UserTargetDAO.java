package com.example.graduation_work_BE.user_target.entity;

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
public class UserTargetDAO {
    @Id
    UUID userTargetId;

    UUID userId;

    String targetContent;

    Boolean isFinish;

    LocalDateTime createAt;
    LocalDateTime uploadAt;
}
