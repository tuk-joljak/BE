package com.example.graduation_work_BE.resume.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectDAO {
    @Id
    UUID projectId;

    String projectName; // 프로젝트 명
    String organization; // 소속/기관
    String startDate;
    String endDate;
    String description; // 프로젝트 설명

    Boolean isFinish; // 진행 중

    @ManyToOne
    @JoinColumn(name = "resumeId")
    ResumeDAO resumeDAO;
}
