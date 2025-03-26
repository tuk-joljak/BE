package com.example.graduation_work_BE.resume.bean.small;

import com.example.graduation_work_BE.resume.entity.DTO.RequestResumeSaveDTO;
import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateResumeDAOBean {

    public ResumeDAO exec(RequestResumeSaveDTO requestResumeSaveDTO){
        return ResumeDAO.builder()
                .resumeId(UUID.randomUUID())
                .userId(requestResumeSaveDTO.getUserId())
                .preferredJobFieldList(requestResumeSaveDTO.getPreferredJobFieldList())
                .stackList(requestResumeSaveDTO.getStackList())
                .careerList(requestResumeSaveDTO.getCareerList())
                .projectList(requestResumeSaveDTO.getProjectList())
                .build();
    }
}
