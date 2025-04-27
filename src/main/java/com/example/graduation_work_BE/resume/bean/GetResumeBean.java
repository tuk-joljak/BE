package com.example.graduation_work_BE.resume.bean;

import com.example.graduation_work_BE.resume.bean.small.GetResumeDAOBean;
import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class GetResumeBean {

    GetResumeDAOBean getResumeDAOBean;

    public GetResumeBean(GetResumeDAOBean getResumeDAOBean) {
        this.getResumeDAOBean = getResumeDAOBean;
    }

    public ResumeDAO exec(UUID resumeId){
        log.debug("🧾 resumeId로 이력서 조회 중: {}", resumeId);
        ResumeDAO resume = getResumeDAOBean.exec(resumeId);
        log.debug("📄 조회된 resume: {}", resume);
        return resume;
    }
}
