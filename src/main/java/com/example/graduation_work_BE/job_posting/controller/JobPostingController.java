package com.example.graduation_work_BE.job_posting.controller;

import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingGetDTO;
import com.example.graduation_work_BE.job_posting.domain.DTO.RequestJobPostingSaveDTO;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import com.example.graduation_work_BE.job_posting.service.CompanyService;
import com.example.graduation_work_BE.job_posting.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/job/posting")
public class JobPostingController {

    JobPostingService jobPostingService;
    CompanyService companyService;

    @Autowired
    public JobPostingController(JobPostingService jobPostingService, CompanyService companyService){
        this.jobPostingService = jobPostingService;
        this.companyService = companyService;
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

    // 크롤링한 공고 저장
    // ✅ 채용 공고 저장
    @PostMapping
    public ResponseEntity<?> saveJobPosting(@RequestBody RequestJobPostingSaveDTO requestJobPostingSaveDTO) {
        // ✅ companyId 조회 및 자동 생성
        UUID companyId = companyService.getOrCreateCompanyId(requestJobPostingSaveDTO.getCompanyName());

        // ✅ DTO에 companyId 추가
        requestJobPostingSaveDTO.setCompanyId(companyId);

        jobPostingService.saveJobPosting(requestJobPostingSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
