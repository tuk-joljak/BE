package com.example.graduation_work_BE.job_posting.service;

import com.example.graduation_work_BE.job_posting.bean.GetJobPostingBean;
import com.example.graduation_work_BE.job_posting.bean.GetJobPostingsBean;
import com.example.graduation_work_BE.job_posting.domain.CompanyDAO;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingGetDTO;
import com.example.graduation_work_BE.job_posting.domain.DTO.RequestJobPostingSaveDTO;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import com.example.graduation_work_BE.job_posting.repository.CompanyRepositoryJPA;
import com.example.graduation_work_BE.job_posting.repository.JobPostingRepositoryJPA;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    GetJobPostingsBean getJobPostingsBean;
    GetJobPostingBean getJobPostingBean;
    JobPostingRepositoryJPA jobPostingRepositoryJPA;
    CompanyRepositoryJPA companyRepositoryJPA;
    CompanyService companyService;

    @Autowired
    public JobPostingService(GetJobPostingsBean getJobPostingsBean, GetJobPostingBean getJobPostingBean, JobPostingRepositoryJPA jobPostingRepositoryJPA, CompanyRepositoryJPA companyRepositoryJPA, CompanyService companyService){
        this.getJobPostingsBean = getJobPostingsBean;
        this.getJobPostingBean = getJobPostingBean;
        this.jobPostingRepositoryJPA = jobPostingRepositoryJPA;
        this.companyRepositoryJPA = companyRepositoryJPA;
        this.companyService = companyService;
    }

    // 전체 공고 조회
    public List<ResponseJobPostingsGetDTO> getJobPostings(){
        return getJobPostingsBean.exec();
    }


    // 세부 공고 조회
    public ResponseJobPostingGetDTO getJobPosting(UUID jobPostingId){
        return getJobPostingBean.exec(jobPostingId);
    }

    public List<JobPostingDAO> getRecommendedJobPostings(List<String> resumeSkills) {
        return jobPostingRepositoryJPA.findAll().stream()
                .filter(job -> resumeSkills.stream()
                        .anyMatch(skill -> List.of(job.getStack().split(",")).contains(skill)))
                .collect(Collectors.toList());
    }

    // ✅ 채용 공고 저장
    @Transactional
    public UUID saveJobPosting(RequestJobPostingSaveDTO request) {
        // ✅ 회사 ID를 기반으로 CompanyDAO 조회
        CompanyDAO company = companyRepositoryJPA.findById(request.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회사 ID입니다: " + request.getCompanyId()));

        // ✅ JobPostingDAO 생성 및 저장
        JobPostingDAO jobPosting = JobPostingDAO.builder()
                .jobPostingId(UUID.randomUUID()) // ✅ 고유한 ID 생성
                .title(request.getTitle())
                .description(request.getDescription())
                .location(request.getLocation())
                .career(request.getCareer())
                .task(request.getTask())
                .qualification(request.getQualification())
                .preference(request.getPreference())
                .stack(request.getStack())
                .hiringProcess(request.getHiringProcess())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .companyDAO(company) // ✅ company 매핑
                .build();

        jobPostingRepositoryJPA.save(jobPosting);
        return jobPosting.getJobPostingId();
    }

}