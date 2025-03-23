package com.example.graduation_work_BE.job_posting.repository;

import com.example.graduation_work_BE.job_posting.domain.CompanyDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepositoryJPA extends JpaRepository<CompanyDAO, UUID> {
    Optional<CompanyDAO> findByCompanyNameIgnoreCase(String companyName);
}
