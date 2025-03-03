package com.example.graduation_work_BE.job_posting.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    String deadline;
    String location;
    String career; // 경력
    String task; // 주요업무
    String qualification; // 자격요건
    String preference; // 우대사항
    String stack;
    String hiringProcess;

    LocalDateTime createAt;
    LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    CompanyDAO companyDAO;
}
