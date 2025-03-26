package com.example.graduation_work_BE.resume.entity.DTO;

import com.example.graduation_work_BE.resume.convert.StringListConvert;
import com.example.graduation_work_BE.resume.convert.StringListMapConvert;
import jakarta.persistence.Convert;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class RequestResumeSaveDTO {
    UUID userId;

    List<Map<String, Object>> preferredJobFieldList;
    List<String> stackList;
    List<Map<String, Object>> careerList;
    List<Map<String, Object>> projectList;
}
