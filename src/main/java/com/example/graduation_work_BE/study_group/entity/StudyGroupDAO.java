package com.example.graduation_work_BE.study_group.entity;

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
public class StudyGroupDAO {
    @Id
    UUID studyGroupId;

    UUID userId;  // 만든사람

    String studyGroupName;
    @ElementCollection
    @CollectionTable(name = "study_group_tech_stack", joinColumns = @JoinColumn(name = "study_group_id"))
    @Column(name = "tech_stack")
    List<String> techStacks; // 임시

    String description;  // 스터디 개요
    String startDate;
    String endDate;

    Boolean isRecruiting;

    LocalDateTime createAt;
    LocalDateTime updateAt;

}
