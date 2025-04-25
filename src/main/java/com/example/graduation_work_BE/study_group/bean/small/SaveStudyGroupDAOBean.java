package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import com.example.graduation_work_BE.study_group.repository.StudyGroupRepositoryJPA;
import org.springframework.stereotype.Component;

@Component
public class SaveStudyGroupDAOBean  {

    StudyGroupRepositoryJPA studyGroupRepositoryJPA;

    public SaveStudyGroupDAOBean(StudyGroupRepositoryJPA studyGroupRepositoryJPA) {
        this.studyGroupRepositoryJPA = studyGroupRepositoryJPA;
    }

    public void exec(StudyGroupDAO studyGroupDAO){
        studyGroupRepositoryJPA.save(studyGroupDAO);
    }
}
