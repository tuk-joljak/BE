package com.example.graduation_work_BE.resume.entity;

import com.example.graduation_work_BE.resume.convert.StringListConvert;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JobCategoryDAO {
    @Id
    UUID jobCategoryId;

    String hopeJobGroup;

    @Convert(converter = StringListConvert.class)
    List<String> hopeJobRole;

    @OneToOne
    @JoinColumn(name = "resumeId")
    ResumeDAO resumeDAO;
}
