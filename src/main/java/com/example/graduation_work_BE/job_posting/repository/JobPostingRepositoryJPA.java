package com.example.graduation_work_BE.job_posting.repository;

import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobPostingRepositoryJPA extends JpaRepository<JobPostingDAO, UUID> {

    JobPostingDAO findByJobPostingId(UUID jobPostingId);
}
