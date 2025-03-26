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
public class CareerDAO {
    @Id
    UUID careerId;

    String companyName; // 회사명
    String position; // 직책
    String department; // 부서명
    String workingPeriod; // 재직 기간
    String employmentType; // 근무 유형
    Boolean isCurrentlyEmployed; // 재직 중
    String responsibility; // 담당 엄무

    @ManyToOne
    @JoinColumn(name = "resumeId")
    ResumeDAO resumeDAO;
}
