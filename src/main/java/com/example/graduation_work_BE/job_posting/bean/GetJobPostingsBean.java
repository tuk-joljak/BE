package com.example.graduation_work_BE.job_posting.bean;

import com.example.graduation_work_BE.job_posting.bean.small.CreateJobPostingsDTOBean;
import com.example.graduation_work_BE.job_posting.bean.small.GetJobPostingDAOBean;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetJobPostingsBean {

    GetJobPostingDAOBean getJobPostingDAOBean;
    CreateJobPostingsDTOBean createJobPostingsDTOBean;

    @Autowired
    public GetJobPostingsBean(GetJobPostingDAOBean getJobPostingDAOBean, CreateJobPostingsDTOBean createJobPostingsDTOBean){
        this.getJobPostingDAOBean = getJobPostingDAOBean;
        this.createJobPostingsDTOBean = createJobPostingsDTOBean;
    }

    public List<ResponseJobPostingsGetDTO> exec(){
        // db에서 공고, 회사에 대한 DAO 가져오기
        List<JobPostingDAO> jobPostingDAOS = getJobPostingDAOBean.exec();
        if (jobPostingDAOS.isEmpty()) return null;

        // dto 만들어서 넣기
        return createJobPostingsDTOBean.exec(jobPostingDAOS);
    }
}
