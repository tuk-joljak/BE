package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.CreateRecommendStudyGroupsDTOBean;
import com.example.graduation_work_BE.study_group.bean.small.GetStudyGroupsDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.ResponseRecommendStudyGroupGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetRecommendStudyGroupBean {

    GetStudyGroupsDAOBean getStudyGroupsDAOBean;
    CreateRecommendStudyGroupsDTOBean createRecommendStudyGroupsDTOBean;

    public GetRecommendStudyGroupBean(GetStudyGroupsDAOBean getStudyGroupsDAOBean, CreateRecommendStudyGroupsDTOBean createRecommendStudyGroupsDTOBean) {
        this.getStudyGroupsDAOBean = getStudyGroupsDAOBean;
        this.createRecommendStudyGroupsDTOBean = createRecommendStudyGroupsDTOBean;
    }

    public List<ResponseRecommendStudyGroupGetDTO> exec(List<String> techStack){
        List<StudyGroupDAO> studyGroupDAOS = getStudyGroupsDAOBean.exec(techStack);
        if (studyGroupDAOS.isEmpty()) return null;
        
        return createRecommendStudyGroupsDTOBean.exec(studyGroupDAOS);
    }
}
