package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.DeleteStudyGroupDAOBean;
import com.example.graduation_work_BE.study_group.bean.small.GetStudyGroupDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyGroupDeleteDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteStudyGroupBean {

    GetStudyGroupDAOBean getStudyGroupDAOBean;
    DeleteStudyGroupDAOBean deleteStudyGroupDAOBean;

    @Autowired
    public DeleteStudyGroupBean(GetStudyGroupDAOBean getStudyGroupDAOBean, DeleteStudyGroupDAOBean deleteStudyGroupDAOBean){
        this.getStudyGroupDAOBean = getStudyGroupDAOBean;
        this.deleteStudyGroupDAOBean = deleteStudyGroupDAOBean;

    }
    public UUID exec(RequestStudyGroupDeleteDTO requestStudyGroupDeleteDTO){
        StudyGroupDAO studyGroupDAO = getStudyGroupDAOBean.exec(requestStudyGroupDeleteDTO.getStudyGroupId());
        if (studyGroupDAO == null) return null;

        deleteStudyGroupDAOBean.exec(studyGroupDAO);

        return studyGroupDAO.getStudyGroupId();
    }
}
