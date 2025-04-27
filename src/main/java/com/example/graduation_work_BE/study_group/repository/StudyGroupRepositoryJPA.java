package com.example.graduation_work_BE.study_group.repository;

import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudyGroupRepositoryJPA extends JpaRepository<StudyGroupDAO, UUID> {
}
