package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.DeleteStudyParticipantDAOBean;
import com.example.graduation_work_BE.study_group.bean.small.GetStudyParticipantDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyParticipantDeleteDTO;
import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteStudyParticipantBean {
    GetStudyParticipantDAOBean getStudyParticipantDAOBean;
    DeleteStudyParticipantDAOBean deleteStudyParticipantDAOBean;

    @Autowired
    public DeleteStudyParticipantBean(GetStudyParticipantDAOBean getStudyParticipantDAOBean, DeleteStudyParticipantDAOBean deleteStudyParticipantDAOBean){
        this.getStudyParticipantDAOBean = getStudyParticipantDAOBean;
        this.deleteStudyParticipantDAOBean = deleteStudyParticipantDAOBean;

    }
    public UUID exec(RequestStudyParticipantDeleteDTO requestStudyParticipantDeleteDTO){
        StudyParticipantDAO studyParticipantDAO = getStudyParticipantDAOBean.exec(requestStudyParticipantDeleteDTO.getStudyParticipantId());
        if (studyParticipantDAO == null) return null;

        deleteStudyParticipantDAOBean.exec(studyParticipantDAO);

        return studyParticipantDAO.getStudyGroupId();
    }
}
