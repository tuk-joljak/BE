package com.example.graduation_work_BE.resume.repository;

import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ResumeRepositoryJPA extends JpaRepository<ResumeDAO, UUID> {

    @Query("SELECT r FROM ResumeDAO r WHERE r.resumeId = :resumeId")
    Optional<ResumeDAO> findBasicById(@Param("resumeId") UUID resumeId);

    @Query("SELECT r FROM ResumeDAO r LEFT JOIN FETCH r.techStackDAOS WHERE r.resumeId = :resumeId")
    Optional<ResumeDAO> fetchTechStack(@Param("resumeId") UUID resumeId);

    @Query("SELECT r FROM ResumeDAO r LEFT JOIN FETCH r.projectDAOS WHERE r.resumeId = :resumeId")
    Optional<ResumeDAO> fetchProjects(@Param("resumeId") UUID resumeId);

    @Query("SELECT r FROM ResumeDAO r LEFT JOIN FETCH r.careerDAOS WHERE r.resumeId = :resumeId")
    Optional<ResumeDAO> fetchCareers(@Param("resumeId") UUID resumeId);

    @Query("SELECT r FROM ResumeDAO r LEFT JOIN FETCH r.jobCategoryDAOS WHERE r.resumeId = :resumeId")
    Optional<ResumeDAO> fetchJobCategories(@Param("resumeId") UUID resumeId);
}
