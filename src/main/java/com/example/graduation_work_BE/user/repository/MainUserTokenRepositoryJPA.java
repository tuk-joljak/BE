package com.example.graduation_work_BE.user.repository;

import com.example.graduation_work_BE.user.entity.MainUserTokenDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MainUserTokenRepositoryJPA extends JpaRepository<MainUserTokenDAO, UUID> {
}