package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import com.example.graduation_work_BE.study_group.repository.StudyGroupRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetStudyGroupDAOBean {

    StudyGroupRepositoryJPA studyGroupRepositoryJPA;

    @Autowired
    public GetStudyGroupDAOBean(StudyGroupRepositoryJPA studyGroupRepositoryJPA){
        this.studyGroupRepositoryJPA = studyGroupRepositoryJPA;
    }

    public StudyGroupDAO exec(UUID studyGroupId){
        return studyGroupRepositoryJPA.findById(studyGroupId).orElse(null);
    }
}
