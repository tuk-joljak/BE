package com.example.graduation_work_BE.study_group.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudyParticipantDAO {
    @Id
    UUID studyParticipantId;
    UUID userId;
    UUID studyGroupId;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
