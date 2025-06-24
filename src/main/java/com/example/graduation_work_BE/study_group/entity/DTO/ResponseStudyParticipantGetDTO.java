package com.example.graduation_work_BE.study_group.entity.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseStudyParticipantGetDTO {
    UUID studyParticipantId;
    UUID userId;

}
