package com.example.graduation_work_BE.resume.bean.small;

import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import com.example.graduation_work_BE.resume.repository.ResumeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveResumeDAOBean {

    ResumeRepositoryJPA resumeRepositoryJPA;

    @Autowired
    public SaveResumeDAOBean(ResumeRepositoryJPA resumeRepositoryJPA){
        this.resumeRepositoryJPA = resumeRepositoryJPA;
    }

    public void exec(ResumeDAO resumeDAO){
        resumeRepositoryJPA.save(resumeDAO);
    }
}
