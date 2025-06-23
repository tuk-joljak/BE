package com.example.graduation_work_BE.user.repository;

import com.example.graduation_work_BE.user.entity.MainUserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MainUserRepositoryJPA extends JpaRepository<MainUserDAO, UUID> {

    MainUserDAO findByMainUserId(UUID mainUserId);
    MainUserDAO findByLoginId(String loginId);
    MainUserDAO findByLoginIdAndPassword(String loginId, String password);
}
