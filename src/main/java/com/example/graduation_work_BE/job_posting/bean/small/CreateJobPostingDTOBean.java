package com.example.graduation_work_BE.job_posting.bean.small;

import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingGetDTO;
import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateJobPostingDTOBean {

    public ResponseJobPostingGetDTO exec(JobPostingDAO jobPostingDAO){
        return ResponseJobPostingGetDTO.builder()
                .title(jobPostingDAO.getTitle())
                .companyName(jobPostingDAO.getCompanyDAO().getCompanyName())
                .location(jobPostingDAO.getLocation())
                .career(jobPostingDAO.getCareer())
                .task(jobPostingDAO.getTask())
                .qualification(jobPostingDAO.getQualification())
                .preference(jobPostingDAO.getPreference())
                .deadline(jobPostingDAO.getDeadline())
                .stack(jobPostingDAO.getStack())
                .hiringProcess(jobPostingDAO.getHiringProcess())
                .build();
    }
}
