package com.example.graduation_work_BE.resume.bean;

import com.example.graduation_work_BE.resume.bean.small.CreateResumeDAOBean;
import com.example.graduation_work_BE.resume.bean.small.SaveResumeDAOBean;
import com.example.graduation_work_BE.resume.entity.DTO.RequestResumeSaveDTO;
import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveResumeBean {

    CreateResumeDAOBean createResumeDAOBean;
    SaveResumeDAOBean saveResumeDAOBean;

    @Autowired
    public SaveResumeBean(CreateResumeDAOBean createResumeDAOBean, SaveResumeDAOBean saveResumeDAOBean){
        this.createResumeDAOBean = createResumeDAOBean;
        this.saveResumeDAOBean = saveResumeDAOBean;
    }

    public UUID exec(RequestResumeSaveDTO requestResumeSaveDTO){

        ResumeDAO resumeDAO = createResumeDAOBean.exec(requestResumeSaveDTO);
        if (resumeDAO == null) return null;

        saveResumeDAOBean.exec(resumeDAO);

        return resumeDAO.getResumeId();
    }
}
