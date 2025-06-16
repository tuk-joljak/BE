package com.example.graduation_work_BE.user_target.repository;

import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserTargetRepositoryJPA extends JpaRepository<UserTargetDAO, UUID> {
}
