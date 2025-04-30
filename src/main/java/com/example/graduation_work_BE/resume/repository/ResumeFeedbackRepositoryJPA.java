package com.example.graduation_work_BE.resume.repository;

import com.example.graduation_work_BE.resume.entity.ResumeFeedbackDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResumeFeedbackRepositoryJPA extends JpaRepository<ResumeFeedbackDAO, UUID> {
}
