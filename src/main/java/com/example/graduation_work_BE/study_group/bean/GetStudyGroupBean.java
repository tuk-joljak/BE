package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.CreateStudyGroupDTOBean;
import com.example.graduation_work_BE.study_group.bean.small.GetStudyGroupDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyGroupGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetStudyGroupBean {

    GetStudyGroupDAOBean getStudyGroupDAOBean;
    CreateStudyGroupDTOBean createStudyGroupDTOBean;

    @Autowired
    public GetStudyGroupBean(GetStudyGroupDAOBean getStudyGroupDAOBean, CreateStudyGroupDTOBean createStudyGroupDTOBean){
        this.getStudyGroupDAOBean = getStudyGroupDAOBean;
        this.createStudyGroupDTOBean = createStudyGroupDTOBean;
    }

    public ResponseStudyGroupGetDTO exec(UUID studyGroupId){

        StudyGroupDAO studyGroupDAO = getStudyGroupDAOBean.exec(studyGroupId);
        if (studyGroupDAO == null) return null;

        return createStudyGroupDTOBean.exec(studyGroupDAO);
    }
}
