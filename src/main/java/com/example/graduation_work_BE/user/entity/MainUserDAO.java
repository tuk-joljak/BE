package com.example.graduation_work_BE.user.entity;

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
public class MainUserDAO {
    @Id
    private UUID mainUserId;

    private String mainUserName;
    private String loginId;
    private String password;

    LocalDateTime createAt;
}