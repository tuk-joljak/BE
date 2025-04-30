package com.example.graduation_work_BE.resume.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResumePdfDAO {
    @Id
    UUID resumeId;
    UUID userId;

    String fileName;

    @Lob
    String textContent;

    @ElementCollection
    @CollectionTable(name = "resume_skills", joinColumns = @JoinColumn(name = "resume_id"))
    @Column(name = "skill")
    private List<String> extractedSkills;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
