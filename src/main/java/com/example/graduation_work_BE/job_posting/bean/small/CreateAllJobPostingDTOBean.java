package com.example.graduation_work_BE.job_posting.bean.small;

import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateAllJobPostingDTOBean {
    public ResponseJobPostingsGetDTO exec(JobPostingDAO jobPostingDAO){
        return ResponseJobPostingsGetDTO.builder()
                .jobPostingId(jobPostingDAO.getJobPostingId())
                .title(jobPostingDAO.getTitle())
                .career(jobPostingDAO.getCareer())
                .deadline(jobPostingDAO.getDeadline())
                .location(jobPostingDAO.getLocation())
                .companyName(jobPostingDAO.getCompanyDAO().getCompanyName())
                .build();
    }
}
