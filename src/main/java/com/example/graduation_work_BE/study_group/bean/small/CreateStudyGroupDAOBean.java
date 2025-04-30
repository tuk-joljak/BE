package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyGroupSaveDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateStudyGroupDAOBean {

    public StudyGroupDAO exec(RequestStudyGroupSaveDTO requestStudyGroupSaveDTO){
        return StudyGroupDAO.builder()
                .studyGroupId(UUID.randomUUID())
                .userId(requestStudyGroupSaveDTO.getUserId())
                .studyGroupName(requestStudyGroupSaveDTO.getStudyGroupName())
                .techStacks(requestStudyGroupSaveDTO.getTechStacks())
                .description(requestStudyGroupSaveDTO.getDescription())
                .startDate(requestStudyGroupSaveDTO.getStartDate())
                .endDate(requestStudyGroupSaveDTO.getEndDate())
                .isRecruiting(true)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
    }
}
