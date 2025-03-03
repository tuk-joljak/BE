package com.example.graduation_work_BE.job_posting.domain.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseJobPostingGetDTO {

    String title;
    String companyName;
    String location;
    String career; // 경력
    String task; // 주요업무
    String qualification; // 자격요건
    String preference; // 우대사항
    String deadline;
    String stack; // 기술 스택
    String hiringProcess;
}
