package com.example.graduation_work_BE.user.repository;

import com.example.graduation_work_BE.user.entity.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserDAO, UUID> {

    UserDAO findByOauthId(String oauthId);

    UserDAO findByUserId(UUID userId);
}
