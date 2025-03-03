package com.example.graduation_work_BE.job_posting.bean;

import com.example.graduation_work_BE.job_posting.bean.small.CreateAllJobPostingDTOBean;
import com.example.graduation_work_BE.job_posting.bean.small.CreateJobPostingDTOBean;
import com.example.graduation_work_BE.job_posting.bean.small.GetJobPostingDAOBean;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingGetDTO;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetJobPostingBean {

    GetJobPostingDAOBean getJobPostingDAOBean;
    CreateJobPostingDTOBean createJobPostingDTOBean;

    @Autowired
    public GetJobPostingBean(GetJobPostingDAOBean getJobPostingDAOBean, CreateJobPostingDTOBean createJobPostingDTOBean){
        this.getJobPostingDAOBean = getJobPostingDAOBean;
        this.createJobPostingDTOBean = createJobPostingDTOBean;
    }

    public ResponseJobPostingGetDTO exec(UUID jobPostingId){
        // db에서 공고에 대한 DAO 가져오기
        JobPostingDAO jobPostingDAO = getJobPostingDAOBean.exec(jobPostingId);
        if (jobPostingDAO == null) return null;

        // dto 만들어서 넣고 반환
        return createJobPostingDTOBean.exec(jobPostingDAO);
    }
}
