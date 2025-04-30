package com.example.graduation_work_BE.study_group.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStudyGroupGetDTO {
    String studyGroupName;
    String description;
    String startDate;
    String endDate;
    Boolean isRecruiting;
}
