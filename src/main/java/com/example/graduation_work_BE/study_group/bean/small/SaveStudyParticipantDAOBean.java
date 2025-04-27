package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import com.example.graduation_work_BE.study_group.repository.StudyParticipantRepositoryJPA;
import org.springframework.stereotype.Component;

@Component
public class SaveStudyParticipantDAOBean {
    StudyParticipantRepositoryJPA studyParticipantRepositoryJPA;

    public SaveStudyParticipantDAOBean(StudyParticipantRepositoryJPA studyParticipantRepositoryJPA) {
        this.studyParticipantRepositoryJPA = studyParticipantRepositoryJPA;
    }

    public void exec(StudyParticipantDAO studyParticipantDAO){
        studyParticipantRepositoryJPA.save(studyParticipantDAO);
    }
}
