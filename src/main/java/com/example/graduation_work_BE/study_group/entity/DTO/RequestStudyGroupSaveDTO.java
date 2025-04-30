package com.example.graduation_work_BE.study_group.entity.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class RequestStudyGroupSaveDTO {
    UUID userId;

    String studyGroupName;
    List<String> techStacks;
    String description;
    String startDate;
    String endDate;
    Boolean isRecruiting;
}
