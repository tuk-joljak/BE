package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.GetStudyGroupDAOBean;
import com.example.graduation_work_BE.study_group.bean.small.SaveStudyGroupDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyGroupUpdateDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateStudyGroupBean {

    GetStudyGroupDAOBean getStudyGroupDAOBean;
    SaveStudyGroupDAOBean saveStudyGroupDAOBean;

    @Autowired
    public UpdateStudyGroupBean(GetStudyGroupDAOBean getStudyGroupDAOBean, SaveStudyGroupDAOBean saveStudyGroupDAOBean) {
        this.saveStudyGroupDAOBean = saveStudyGroupDAOBean;
        this.getStudyGroupDAOBean = getStudyGroupDAOBean;
    }

    public UUID exec(RequestStudyGroupUpdateDTO requestStudyGroupUpdateDTO){

        StudyGroupDAO studyGroupDAO = getStudyGroupDAOBean.exec(requestStudyGroupUpdateDTO.getStudyGroupId());
        if (studyGroupDAO==null) return null;

        studyGroupDAO.setContent(requestStudyGroupUpdateDTO.getContent());
        studyGroupDAO.setStartDate(requestStudyGroupUpdateDTO.getStartDate());
        studyGroupDAO.setEndDate(requestStudyGroupUpdateDTO.getEndDate());
        studyGroupDAO.setUpdateAt(LocalDateTime.now());

        saveStudyGroupDAOBean.exec(studyGroupDAO);

        return studyGroupDAO.getStudyGroupId();
    }
}
