package com.example.graduation_work_BE.job_posting.controller;

import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingGetDTO;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import com.example.graduation_work_BE.job_posting.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/job/posting")
public class JobPostingController {

    JobPostingService jobPostingService;

    @Autowired
    public JobPostingController(JobPostingService jobPostingService){
        this.jobPostingService = jobPostingService;
    }

    // 공고 전체 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getJobPostings(){

        List<ResponseJobPostingsGetDTO> responseJobPostingsGetDTO = jobPostingService.getJobPostings();

        boolean success = (responseJobPostingsGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "공고 전체 조회 성공" : "공고 전체 조회 실패");
        requestMap.put("menuList", responseJobPostingsGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 공고 세부 조회
    @GetMapping("{jobPostingId}")
    public ResponseEntity<Map<String, Object>> getJobPosting(@PathVariable("jobPostingId") UUID jobPostingId){

        ResponseJobPostingGetDTO responseJobPostingGetDTO = jobPostingService.getJobPosting(jobPostingId);

        boolean success = (responseJobPostingGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "특정 공고 조회 성공" : "특정 공고 조회 실패");
        requestMap.put("menuList", responseJobPostingGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
