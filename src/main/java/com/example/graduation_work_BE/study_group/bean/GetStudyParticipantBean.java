package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.CreateStudyParticipantDTOBean;
import com.example.graduation_work_BE.study_group.bean.small.GetStudyParticipantDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyParticipantGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStudyParticipantBean {
    GetStudyParticipantDAOBean getStudyParticipantDAOBean;
    CreateStudyParticipantDTOBean createStudyParticipantDTOBean;

    @Autowired
    public GetStudyParticipantBean(GetStudyParticipantDAOBean getStudyParticipantDAOBean, CreateStudyParticipantDTOBean createStudyParticipantDTOBean){
        this.getStudyParticipantDAOBean = getStudyParticipantDAOBean;
        this.createStudyParticipantDTOBean = createStudyParticipantDTOBean;
    }

    public List<ResponseStudyParticipantGetDTO> exec(){
        List<StudyParticipantDAO> studyParticipantDAOS = getStudyParticipantDAOBean.exec();
        if (studyParticipantDAOS == null) return null;

        return createStudyParticipantDTOBean.exec(studyParticipantDAOS);
    }
}
