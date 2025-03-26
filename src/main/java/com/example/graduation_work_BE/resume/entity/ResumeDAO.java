package com.example.graduation_work_BE.resume.entity;

import com.example.graduation_work_BE.resume.convert.StringListConvert;
import com.example.graduation_work_BE.resume.convert.StringListMapConvert;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Convert(converter = StringListMapConvert.class)
    List<Map<String, Object>> preferredJobFieldList;

    @Convert(converter = StringListConvert.class)
    List<String> stackList;

    @Convert(converter = StringListMapConvert.class)
    List<Map<String, Object>> careerList;

    @Convert(converter = StringListMapConvert.class)
    List<Map<String, Object>> projectList;
}
