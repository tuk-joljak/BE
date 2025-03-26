package com.example.graduation_work_BE.resume.entity;

import com.example.graduation_work_BE.resume.convert.StringListConvert;
import com.example.graduation_work_BE.resume.convert.StringListMapConvert;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResumeDAO {
    @Id
    UUID resumeId;

    UUID userId;

    @OneToMany(mappedBy = "resumeDAO", cascade = CascadeType.ALL, orphanRemoval = true)
    List<JobCategoryDAO> jobCategoryDAOS;

    @OneToMany(mappedBy = "resumeDAO", cascade = CascadeType.ALL, orphanRemoval = true)
    List<TechStackDAO> techStackDAOS;

    @OneToMany(mappedBy = "resumeDAO", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CareerDAO> careerDAOs;

    @OneToMany(mappedBy = "resumeDAO", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ProjectDAO> projectDAOS;
}
