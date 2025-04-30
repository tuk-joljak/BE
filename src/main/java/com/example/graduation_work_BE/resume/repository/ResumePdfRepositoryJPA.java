package com.example.graduation_work_BE.resume.repository;

import com.example.graduation_work_BE.resume.entity.ResumePdfDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResumePdfRepositoryJPA extends JpaRepository<ResumePdfDAO, UUID> {
}
