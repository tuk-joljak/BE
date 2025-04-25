package com.example.graduation_work_BE.resume.bean;

import com.example.graduation_work_BE.resume.bean.small.GetResumeDAOBean;
import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetResumeBean {

    GetResumeDAOBean getResumeDAOBean;

    public GetResumeBean(GetResumeDAOBean getResumeDAOBean) {
        this.getResumeDAOBean = getResumeDAOBean;
    }

    public ResumeDAO exec(UUID resumeId){
        return getResumeDAOBean.exec(resumeId);
    }
}
