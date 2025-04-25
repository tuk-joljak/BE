package com.example.graduation_work_BE.resume.bean.small;

import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import com.example.graduation_work_BE.resume.repository.ResumeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetResumeDAOBean {

    ResumeRepositoryJPA resumeRepositoryJPA;

    @Autowired
    public GetResumeDAOBean(ResumeRepositoryJPA resumeRepositoryJPA){
        this.resumeRepositoryJPA = resumeRepositoryJPA;
    }

    public ResumeDAO exec(UUID resumeId) {
        ResumeDAO resume = resumeRepositoryJPA.findBasicById(resumeId)
                .orElseThrow(() -> new IllegalArgumentException("이력서를 찾을 수 없습니다: " + resumeId));

        // 순차적으로 필요한 연관 데이터를 로딩
        resumeRepositoryJPA.fetchTechStack(resumeId);
        resumeRepositoryJPA.fetchProjects(resumeId);
        resumeRepositoryJPA.fetchCareers(resumeId);
        resumeRepositoryJPA.fetchJobCategories(resumeId);

        return resume;
    }
}
