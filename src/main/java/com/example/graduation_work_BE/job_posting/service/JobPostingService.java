package com.example.graduation_work_BE.job_posting.service;

import com.example.graduation_work_BE.job_posting.bean.GetJobPostingBean;
import com.example.graduation_work_BE.job_posting.bean.GetJobPostingsBean;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingGetDTO;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobPostingService {

    GetJobPostingsBean getJobPostingsBean;
    GetJobPostingBean getJobPostingBean;

    @Autowired
    public JobPostingService(GetJobPostingsBean getJobPostingsBean, GetJobPostingBean getJobPostingBean){
        this.getJobPostingsBean = getJobPostingsBean;
        this.getJobPostingBean = getJobPostingBean;
    }

    // 전체 공고 조회
    public List<ResponseJobPostingsGetDTO> getJobPostings(){
        return getJobPostingsBean.exec();
    }


    // 세부 공고 조회
    public ResponseJobPostingGetDTO getJobPosting(UUID jobPostingId){
        return getJobPostingBean.exec(jobPostingId);
    }

}
