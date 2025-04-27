package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import com.example.graduation_work_BE.study_group.repository.StudyGroupRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteStudyGroupDAOBean {

    StudyGroupRepositoryJPA studyGroupRepository;

    @Autowired
    public DeleteStudyGroupDAOBean(StudyGroupRepositoryJPA studyGroupRepositoryJPA){
        this.studyGroupRepository = studyGroupRepositoryJPA;
    }
    public void exec(StudyGroupDAO studyGroupDAO){
        studyGroupRepository.delete(studyGroupDAO);
    }
}
