package com.example.graduation_work_BE.user_schedule.repository;

import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserScheduleRepositoryJPA extends JpaRepository<UserScheduleDAO, UUID> {
}
