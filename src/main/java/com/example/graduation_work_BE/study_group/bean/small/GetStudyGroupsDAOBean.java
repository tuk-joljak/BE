package com.example.graduation_work_BE.study_group.bean.small;

import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import com.example.graduation_work_BE.study_group.repository.StudyGroupRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetStudyGroupsDAOBean {

    StudyGroupRepositoryJPA studyGroupRepositoryJPA;

    @Autowired
    public GetStudyGroupsDAOBean(StudyGroupRepositoryJPA studyGroupRepositoryJPA){
        this.studyGroupRepositoryJPA = studyGroupRepositoryJPA;
    }

    public List<StudyGroupDAO> exec(){
        return studyGroupRepositoryJPA.findAll();
    }

    public List<StudyGroupDAO> exec(List<String> techStacks){
        return studyGroupRepositoryJPA.findByTechStacksInAndIsRecruitingTrue(techStacks);
    }
}
