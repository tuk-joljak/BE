package com.example.graduation_work_BE.resume.entity.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class RequestResumeSaveDTO {
    UUID userId;

    String hopeJobGroup;
    List<String> hopeJobRole;

    List<String> stackList;
    List<CareerDTO> careerDTOS;
    List<ProjectDTO> projectDTOS;
}
