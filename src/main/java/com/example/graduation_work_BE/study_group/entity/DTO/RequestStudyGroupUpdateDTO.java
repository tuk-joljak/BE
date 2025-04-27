package com.example.graduation_work_BE.study_group.entity.DTO;

import lombok.Data;
import java.util.UUID;

@Data
public class RequestStudyGroupUpdateDTO {
    UUID studyGroupId;

    String content;
    String startDate;
    String endDate;
}
