package com.example.graduation_work_BE.resume.service;

import com.example.graduation_work_BE.resume.bean.SaveResumeBean;
import com.example.graduation_work_BE.resume.entity.DTO.RequestResumeSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResumeService {

    SaveResumeBean saveResumeBean;

    @Autowired
    public ResumeService(SaveResumeBean saveResumeBean){
        this.saveResumeBean = saveResumeBean;
    }

    public UUID createResume(RequestResumeSaveDTO requestResumeSaveDTO){
        return saveResumeBean.exec(requestResumeSaveDTO);
    }
}
