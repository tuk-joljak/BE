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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final GetJobPostingsBean getJobPostingsBean;
    private final GetJobPostingBean getJobPostingBean;
    private final JobPostingRepositoryJPA jobPostingRepositoryJPA;
    private final CompanyRepositoryJPA companyRepositoryJPA;
    private final CompanyService companyService;

    // ✅ 전체 공고 조회
    public List<ResponseJobPostingsGetDTO> getJobPostings() {
        return getJobPostingsBean.exec();
    }

    // ✅ 세부 공고 조회
    public ResponseJobPostingGetDTO getJobPosting(UUID jobPostingId) {
        return getJobPostingBean.exec(jobPostingId);
    }

    // ✅ 추천 공고 조회
    public List<JobPostingDAO> getRecommendedJobPostings(List<String> resumeSkills) {
        return jobPostingRepositoryJPA.findAll().stream()
                .filter(job -> resumeSkills.stream()
                        .anyMatch(skill -> List.of(job.getStack().split(",")).contains(skill)))
                .collect(Collectors.toList());
    }

    // ✅ 채용 공고 저장
    @Transactional
    public void saveJobPosting(RequestJobPostingSaveDTO requestJobPostingSaveDTO) {
//        String normalizedCompanyName = requestJobPostingSaveDTO.getCompanyName().trim().toLowerCase();
        // ✅ `companyName`을 기반으로 `CompanyDAO` 조회 (없으면 새로 생성)
        CompanyDAO company = companyRepositoryJPA.findByCompanyName(requestJobPostingSaveDTO.getCompanyName())
                .orElseGet(() -> {
                    CompanyDAO newCompany = new CompanyDAO();
                    newCompany.setCompanyId(UUID.randomUUID()); // ✅ 새로운 UUID 생성
                    newCompany.setCompanyName(requestJobPostingSaveDTO.getCompanyName());
                    return companyRepositoryJPA.save(newCompany);
                });

        // ✅ `JobPostingDAO` 생성 및 저장
        JobPostingDAO jobPosting = JobPostingDAO.builder()
                .jobPostingId(UUID.randomUUID()) // ✅ 고유한 ID 생성
                .title(requestJobPostingSaveDTO.getTitle())
                .description(requestJobPostingSaveDTO.getDescription())
                .location(requestJobPostingSaveDTO.getLocation())
                .career(requestJobPostingSaveDTO.getCareer())
                .task(requestJobPostingSaveDTO.getTask())
                .qualification(requestJobPostingSaveDTO.getQualification())
                .preference(requestJobPostingSaveDTO.getPreference())
                .stack(requestJobPostingSaveDTO.getStack())
                .hiringProcess(requestJobPostingSaveDTO.getHiringProcess())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .imageUrl(requestJobPostingSaveDTO.getImageUrl())
                .companyDAO(company) // ✅ `companyId` 대신 `companyDAO` 설정
                .build();

        jobPostingRepositoryJPA.save(jobPosting);
    }
}
