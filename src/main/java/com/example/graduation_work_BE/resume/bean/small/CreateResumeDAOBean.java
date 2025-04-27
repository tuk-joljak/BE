package com.example.graduation_work_BE.resume.bean.small;

import com.example.graduation_work_BE.resume.entity.*;
import com.example.graduation_work_BE.resume.entity.DTO.RequestResumeSaveDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CreateResumeDAOBean {

    public ResumeDAO exec(RequestResumeSaveDTO requestResumeSaveDTO) {
        ResumeDAO resumeDAO = ResumeDAO.builder()
                .resumeId(UUID.randomUUID())
                .userId(requestResumeSaveDTO.getUserId())
                .build();

        JobCategoryDAO jobCategoryDAO = JobCategoryDAO.builder()
                .jobCategoryId(UUID.randomUUID())
                .hopeJobGroup(requestResumeSaveDTO.getHopeJobGroup())
                .hopeJobRole(requestResumeSaveDTO.getHopeJobRole())
                .resumeDAO(resumeDAO)
                .build();
        resumeDAO.setJobCategoryDAOS(List.of(jobCategoryDAO));

        List<TechStackDAO> stacks = requestResumeSaveDTO.getStackList().stream()
                .map(stack -> TechStackDAO.builder()
                        .techStackId(UUID.randomUUID())
                        .stack(stack)
                        .resumeDAO(resumeDAO)
                        .build())
                .toList();
        resumeDAO.setTechStackDAOS(stacks);

        List<CareerDAO> careers = requestResumeSaveDTO.getCareerDTOS().stream()
                .map(c -> CareerDAO.builder()
                        .careerId(UUID.randomUUID())
                        .companyName(c.getCompanyName())
                        .position(c.getPosition())
                        .department(c.getDepartment())
                        .workingPeriod(c.getWorkingPeriod())
                        .employmentType(c.getEmploymentType())
                        .isCurrentlyEmployed(c.getIsCurrentlyEmployed())
                        .responsibility(c.getResponsibility())
                        .resumeDAO(resumeDAO)
                        .build())
                .toList();
        resumeDAO.setCareerDAOS(careers);

        List<ProjectDAO> projects = requestResumeSaveDTO.getProjectDTOS().stream()
                .map(p -> ProjectDAO.builder()
                        .projectId(UUID.randomUUID())
                        .projectName(p.getProjectName())
                        .organization(p.getOrganization())
                        .startDate(p.getStartDate())
                        .endDate(p.getEndDate())
                        .description(p.getDescription())
                        .resumeDAO(resumeDAO)
                        .build())
                .toList();
        resumeDAO.setProjectDAOS(projects);

        return resumeDAO;
    }

}
