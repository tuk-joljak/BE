package com.example.graduation_work_BE.study_group.bean;

import com.example.graduation_work_BE.study_group.bean.small.CreateStudyGroupsDTOBean;
import com.example.graduation_work_BE.study_group.bean.small.GetStudyGroupsDAOBean;
import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyGroupGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetStudyGroupsBean {

    GetStudyGroupsDAOBean getStudyGroupsDAOBean;
    CreateStudyGroupsDTOBean createStudyGroupsDTOBean;

    @Autowired
    public GetStudyGroupsBean(GetStudyGroupsDAOBean getStudyGroupsDAOBean, CreateStudyGroupsDTOBean createStudyGroupsDTOBean){
        this.getStudyGroupsDAOBean = getStudyGroupsDAOBean;
        this.createStudyGroupsDTOBean = createStudyGroupsDTOBean;
    }

    public List<ResponseStudyGroupGetDTO> exec(UUID studyGroupId){
        List<StudyGroupDAO> studyGroupDAOS = getStudyGroupsDAOBean.exec(studyGroupId);
        if (studyGroupDAOS == null) return null;

        return createStudyGroupsDTOBean.exec(studyGroupDAOS);
    }
}
