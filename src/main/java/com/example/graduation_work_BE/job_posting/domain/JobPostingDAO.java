package com.example.graduation_work_BE.job_posting.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JobPostingDAO {
    @Id
    UUID jobPostingId;

    String title; // 공고 제목
    String description; // 공고 안쪽 내용
    String deadline; // 마감일
    String location; // 위치
    String career; // 경력
    String task; // 주요업무
    String qualification; // 자격요건
    String preference; // 우대사항
    String stack; // 기술스택
    String hiringProcess; // 고용과정

    LocalDateTime createAt;
    LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    CompanyDAO companyDAO;

    @PrePersist
    public void prePersist() {
        if (this.jobPostingId == null) {
            this.jobPostingId = UUID.randomUUID();
        }
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}
