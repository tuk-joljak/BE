package com.example.graduation_work_BE.user_post.repository;

import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPostRepositoryJPA extends JpaRepository<UserPostDAO, UUID> {
}
