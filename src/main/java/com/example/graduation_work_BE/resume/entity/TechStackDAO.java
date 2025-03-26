package com.example.graduation_work_BE.resume.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TechStackDAO {
    @Id
    UUID techStackId;

    String stack;

    @ManyToOne
    @JoinColumn(name = "resumeId")
    ResumeDAO resumeDAO;

}
