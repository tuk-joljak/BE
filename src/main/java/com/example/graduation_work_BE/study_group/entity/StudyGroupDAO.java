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
public class StudyGroupDAO {
    @Id
    UUID studyGroupId;

    UUID userId;  // 만든사람

    String studyGroupName;
    String category; // 임시
    String content;  // 스터디 개요
    String startDate;
    String endDate;

    LocalDateTime createAt;
    LocalDateTime updateAt;

}
