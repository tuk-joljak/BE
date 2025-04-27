package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import com.example.graduation_work_BE.study_group.repository.StudyParticipantRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStudyParticipantDAOBean {
    StudyParticipantRepositoryJPA studyParticipantRepositoryJPA;

    @Autowired
    public GetStudyParticipantDAOBean(StudyParticipantRepositoryJPA studyParticipantRepositoryJPA){
        this.studyParticipantRepositoryJPA = studyParticipantRepositoryJPA;
    }

    public List<StudyParticipantDAO> exec(){
        return studyParticipantRepositoryJPA.findAll();
    }
}
