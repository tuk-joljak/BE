package com.example.graduation_work_BE.job_posting.bean.small;

import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateJobPostingsDTOBean {

    CreateAllJobPostingDTOBean createAllJobPostingDTOBean;

    @Autowired
    public CreateJobPostingsDTOBean(CreateAllJobPostingDTOBean createAllJobPostingDTOBean){
        this.createAllJobPostingDTOBean = createAllJobPostingDTOBean;
    }

    public List<ResponseJobPostingsGetDTO> exec(List<JobPostingDAO> jobPostingDAOS){
        // list로 된 빈 DTO 생성
        List<ResponseJobPostingsGetDTO> responseJobPostingsGetDTOS = new ArrayList<>();

        // 공고 전체 리스트로 가져오기
        for (JobPostingDAO jobPostingDAO : jobPostingDAOS){
            ResponseJobPostingsGetDTO responseJobPostingsGetDTO = createAllJobPostingDTOBean.exec(jobPostingDAO);

            responseJobPostingsGetDTOS.add(responseJobPostingsGetDTO);
        }

        // 반환
        return responseJobPostingsGetDTOS;
    }
}
