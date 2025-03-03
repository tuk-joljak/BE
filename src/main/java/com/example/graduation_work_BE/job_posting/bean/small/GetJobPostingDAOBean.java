package com.example.graduation_work_BE.job_posting.bean.small;

import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import com.example.graduation_work_BE.job_posting.repository.JobPostingRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetJobPostingDAOBean {

    JobPostingRepositoryJPA jobPostingRepositoryJPA;

    @Autowired
    public GetJobPostingDAOBean(JobPostingRepositoryJPA jobPostingRepositoryJPA){
        this.jobPostingRepositoryJPA = jobPostingRepositoryJPA;
    }

    public List<JobPostingDAO> exec(){
        return jobPostingRepositoryJPA.findAll();
    }

    public JobPostingDAO exec(UUID jobPostingId){
        return jobPostingRepositoryJPA.findByJobPostingId(jobPostingId);
    }
}
