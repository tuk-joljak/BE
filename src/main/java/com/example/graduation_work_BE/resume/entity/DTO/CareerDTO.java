package com.example.graduation_work_BE.resume.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CareerDTO {
    String companyName; // 회사명
    String position; // 직책
    String department; // 부서명
    String workingPeriod; // 재직 기간
    String employmentType; // 근무 유형
    Boolean isCurrentlyEmployed; // 재직 중
    String responsibility; // 담당 엄무
}
