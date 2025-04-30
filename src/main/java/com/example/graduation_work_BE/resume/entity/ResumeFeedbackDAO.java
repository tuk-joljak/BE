package com.example.graduation_work_BE.resume.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResumeFeedbackDAO {
    @Id
    UUID resumeFeedbackId;

    UUID resumeId;

    @Lob
    String commonSkills;

    @Lob
    String missingSkills;

    @Lob
    String recommendations;

    LocalDateTime createAt;
    LocalDateTime uploadAt;
}
