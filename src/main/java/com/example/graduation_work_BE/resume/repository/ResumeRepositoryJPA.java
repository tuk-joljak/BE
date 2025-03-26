package com.example.graduation_work_BE.resume.repository;

import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResumeRepositoryJPA extends JpaRepository<ResumeDAO, UUID> {
}
