package com.example.graduation_work_BE.resume.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDTO {
    String projectName;
    String organization;
    String startDate;
    String endDate;
    String description;

    Boolean isFinish;
}
