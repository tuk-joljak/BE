package com.example.graduation_work_BE.openai.repository;

import com.example.graduation_work_BE.openai.entity.OpenAiDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OpenAiRepositoryJPA extends JpaRepository<OpenAiDAO, UUID> {
}
