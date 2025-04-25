package com.example.graduation_work_BE.resume.service;

import com.example.graduation_work_BE.resume.bean.GetResumeBean;
import com.example.graduation_work_BE.resume.bean.SaveResumeBean;
import com.example.graduation_work_BE.resume.entity.DTO.RequestResumeSaveDTO;
import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResumeService {

    SaveResumeBean saveResumeBean;
    GetResumeBean getResumeBean;

    @Autowired
    public ResumeService(SaveResumeBean saveResumeBean, GetResumeBean getResumeBean){
        this.saveResumeBean = saveResumeBean;
        this.getResumeBean = getResumeBean;
    }

    public UUID createResume(RequestResumeSaveDTO requestResumeSaveDTO){
        return saveResumeBean.exec(requestResumeSaveDTO);
    }

    public ResumeDAO getResumeById(UUID resumeId) {
        return getResumeBean.exec(resumeId);
    }

}
