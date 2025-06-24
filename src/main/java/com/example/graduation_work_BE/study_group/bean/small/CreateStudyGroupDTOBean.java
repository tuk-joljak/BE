package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyGroupGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateStudyGroupDTOBean {

    public ResponseStudyGroupGetDTO exec(StudyGroupDAO studyGroupDAO){
        return ResponseStudyGroupGetDTO.builder()
                .studyGroupId(studyGroupDAO.getStudyGroupId())
                .studyGroupName(studyGroupDAO.getStudyGroupName())
                .description(studyGroupDAO.getDescription())
                .startDate(studyGroupDAO.getStartDate())
                .endDate(studyGroupDAO.getEndDate())
                .isRecruiting(studyGroupDAO.getIsRecruiting())
                .build();
    }
}
