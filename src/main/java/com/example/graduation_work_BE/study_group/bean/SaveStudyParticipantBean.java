package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.CreateStudyParticipantDAOBean;
import com.example.graduation_work_BE.study_group.bean.small.SaveStudyParticipantDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyParticipantSaveDTO;
import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveStudyParticipantBean {
    CreateStudyParticipantDAOBean createStudyParticipantDAOBean;
    SaveStudyParticipantDAOBean saveStudyParticipantDAOBean;

    @Autowired
    public SaveStudyParticipantBean(CreateStudyParticipantDAOBean createStudyParticipantDAOBean, SaveStudyParticipantDAOBean saveStudyParticipantDAOBean){
        this.createStudyParticipantDAOBean = createStudyParticipantDAOBean;
        this.saveStudyParticipantDAOBean = saveStudyParticipantDAOBean;
    }

    public UUID exec(RequestStudyParticipantSaveDTO requestStudyParticipantSaveDTO){
        // DAO객체에다 정보를 넣어야겟지
        StudyParticipantDAO studyParticipantDAO = createStudyParticipantDAOBean.exec(requestStudyParticipantSaveDTO);
        if (studyParticipantDAO == null) return null;

        // DAO객체에 넣은 정보를 토대로 DB에 저장
        saveStudyParticipantDAOBean.exec(studyParticipantDAO);

        // 넣은 DAO값의 PK값을 반환
        return studyParticipantDAO.getStudyGroupId();
    }
}
