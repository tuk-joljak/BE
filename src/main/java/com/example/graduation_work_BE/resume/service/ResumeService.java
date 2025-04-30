package com.example.graduation_work_BE.resume.service;

import com.example.graduation_work_BE.resume.bean.GetResumeBean;
import com.example.graduation_work_BE.resume.bean.SaveResumeBean;
import com.example.graduation_work_BE.resume.entity.DTO.RequestResumeSaveDTO;
import com.example.graduation_work_BE.resume.entity.ResumeDAO;
import com.example.graduation_work_BE.resume.entity.ResumeFeedbackDAO;
import com.example.graduation_work_BE.resume.entity.ResumePdfDAO;
import com.example.graduation_work_BE.resume.repository.ResumeFeedbackRepositoryJPA;
import com.example.graduation_work_BE.resume.repository.ResumePdfRepositoryJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ResumeService {

    SaveResumeBean saveResumeBean;
    GetResumeBean getResumeBean;
    ResumeFeedbackRepositoryJPA resumeFeedbackRepositoryJPA;
    ResumePdfRepositoryJPA resumePdfRepositoryJPA;

    @Autowired
    public ResumeService(SaveResumeBean saveResumeBean, GetResumeBean getResumeBean, ResumeFeedbackRepositoryJPA resumeFeedbackRepositoryJPA, ResumePdfRepositoryJPA resumePdfRepositoryJPA){
        this.saveResumeBean = saveResumeBean;
        this.getResumeBean = getResumeBean;
        this.resumeFeedbackRepositoryJPA = resumeFeedbackRepositoryJPA;
        this.resumePdfRepositoryJPA = resumePdfRepositoryJPA;
    }

    public UUID createResume(RequestResumeSaveDTO requestResumeSaveDTO){
        return saveResumeBean.exec(requestResumeSaveDTO);
    }

    public ResumeDAO getResumeById(UUID resumeId) {
        return getResumeBean.exec(resumeId);
    }

    public void saveResumeFeedback(ResumeDAO resumeDAO, List<String> commonSkills, List<String> missingSkills, List<String> recommendations){
        ResumeFeedbackDAO resumeFeedbackDAO = new ResumeFeedbackDAO();
        resumeFeedbackDAO.setResumeFeedbackId(UUID.randomUUID());
        resumeFeedbackDAO.setResumeId(resumeDAO.getResumeId());
        resumeFeedbackDAO.setCommonSkills(String.join(",", commonSkills));
        resumeFeedbackDAO.setMissingSkills(String.join(",", missingSkills));
        resumeFeedbackDAO.setRecommendations(String.join("\n", recommendations));
        resumeFeedbackRepositoryJPA.save(resumeFeedbackDAO);
    }

    public void saveResumeFeedbackByPdf(ResumePdfDAO resumePdfDAO, List<String> commonSkills, List<String> missingSkills, List<String> recommendations){
        ResumeFeedbackDAO resumeFeedbackDAO = new ResumeFeedbackDAO();
        resumeFeedbackDAO.setResumeFeedbackId(UUID.randomUUID());
        resumeFeedbackDAO.setResumeId(resumePdfDAO.getResumeId());
        resumeFeedbackDAO.setCommonSkills(String.join(",", commonSkills));
        resumeFeedbackDAO.setMissingSkills(String.join(",", missingSkills));
        resumeFeedbackDAO.setRecommendations(String.join("\n", recommendations));
        resumeFeedbackRepositoryJPA.save(resumeFeedbackDAO);
    }

    public ResumePdfDAO saveResumePdf(String FileName, String textContent, List<String> skills, UUID userId) {
        ResumePdfDAO resumePdfDAO = new ResumePdfDAO();
        resumePdfDAO.setResumeId(UUID.randomUUID());
        resumePdfDAO.setFileName(FileName);
        resumePdfDAO.setTextContent(textContent);
        resumePdfDAO.setExtractedSkills(skills);
        resumePdfDAO.setCreateAt(LocalDateTime.now());
        resumePdfDAO.setUpdateAt(LocalDateTime.now());
        resumePdfDAO.setUserId(userId); // Optional

        return resumePdfRepositoryJPA.save(resumePdfDAO);
    }
}
