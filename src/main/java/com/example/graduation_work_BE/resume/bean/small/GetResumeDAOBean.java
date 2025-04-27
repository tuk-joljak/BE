package com.example.graduation_work_BE.resume.bean.small;

import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import com.example.graduation_work_BE.resume.repository.ResumeRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
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

        resume.setTechStackDAOS(
                resumeRepositoryJPA.fetchTechStack(resumeId)
                        .map(ResumeDAO::getTechStackDAOS)
                        .orElse(Collections.emptyList()));

        resume.setProjectDAOS(
                resumeRepositoryJPA.fetchProjects(resumeId)
                        .map(ResumeDAO::getProjectDAOS)
                        .orElse(Collections.emptyList()));

        resume.setCareerDAOS(
                resumeRepositoryJPA.fetchCareers(resumeId)
                        .map(ResumeDAO::getCareerDAOS)
                        .orElse(Collections.emptyList()));

        resume.setJobCategoryDAOS(
                resumeRepositoryJPA.fetchJobCategories(resumeId)
                        .map(ResumeDAO::getJobCategoryDAOS)
                        .orElse(Collections.emptyList()));

        return resume;
    }

}
