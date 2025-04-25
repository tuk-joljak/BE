package com.example.graduation_work_BE.openai.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenAiDAO {

    @Id
    UUID openAiId;

    @Column(columnDefinition = "TEXT", nullable = false) // 긴 텍스트 저장
    private String prompt;

    @Column(columnDefinition = "TEXT")
    private String response;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
