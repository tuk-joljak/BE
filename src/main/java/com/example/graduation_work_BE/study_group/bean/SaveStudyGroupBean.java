package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.CreateStudyGroupDAOBean;
import com.example.graduation_work_BE.study_group.bean.small.SaveStudyGroupDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyGroupSaveDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveStudyGroupBean {

    CreateStudyGroupDAOBean createStudyGroupDAOBean;
    SaveStudyGroupDAOBean saveStudyGroupDAOBean;

    @Autowired
    public SaveStudyGroupBean(CreateStudyGroupDAOBean createStudygroupDAOBean, SaveStudyGroupDAOBean saveStudygroupDAOBean){
        this.createStudyGroupDAOBean = createStudygroupDAOBean;
        this.saveStudyGroupDAOBean = saveStudygroupDAOBean;
    }

    public UUID exec(RequestStudyGroupSaveDTO requestStudyGroupSaveDTO){
        // DAO객체에다 정보를 넣어야겟지
        StudyGroupDAO studyGroupDAO = createStudyGroupDAOBean.exec(requestStudyGroupSaveDTO);
        if (studyGroupDAO == null) return null;

        // DAO객체에 넣은 정보를 토대로 DB에 저장
        saveStudyGroupDAOBean.exec(studyGroupDAO);

        // 넣은 DAO값의 PK값을 반환
        return studyGroupDAO.getStudyGroupId();
    }
}
