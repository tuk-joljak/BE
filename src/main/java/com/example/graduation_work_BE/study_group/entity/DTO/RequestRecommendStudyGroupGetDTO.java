package com.example.graduation_work_BE.study_group.entity.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RequestRecommendStudyGroupGetDTO {
    List<String> missingSkills;
}
