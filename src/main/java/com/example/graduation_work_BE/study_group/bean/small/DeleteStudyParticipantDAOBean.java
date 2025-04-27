package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import com.example.graduation_work_BE.study_group.repository.StudyParticipantRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteStudyParticipantDAOBean {
    StudyParticipantRepositoryJPA studyParticipantRepository;

    @Autowired
    public DeleteStudyParticipantDAOBean(StudyParticipantRepositoryJPA studyParticipantRepositoryJPA){
        this.studyParticipantRepository = studyParticipantRepositoryJPA;
    }
    public void exec(StudyParticipantDAO studyParticipantDAO){
        studyParticipantRepository.delete(studyParticipantDAO);
    }
}
