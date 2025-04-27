package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyParticipantSaveDTO;
import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateStudyParticipantDAOBean {
    public StudyParticipantDAO exec(RequestStudyParticipantSaveDTO requestStudyParticipantSaveDTO){
        return StudyParticipantDAO.builder()
                .studyParticipantId(UUID.randomUUID())
                .userId(requestStudyParticipantSaveDTO.getUserId())
                .studyGroupId(requestStudyParticipantSaveDTO.getStudyGroupId())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
    }
}
