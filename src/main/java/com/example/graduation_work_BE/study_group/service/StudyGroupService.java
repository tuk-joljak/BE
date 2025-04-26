package com.example.graduation_work_BE.study_group.service;

import com.example.graduation_work_BE.study_group.bean.GetStudyGroupBean;
import com.example.graduation_work_BE.study_group.bean.GetStudyGroupsBean;
import com.example.graduation_work_BE.study_group.bean.SaveStudyGroupBean;
import com.example.graduation_work_BE.study_group.bean.UpdateStudyGroupBean;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyGroupSaveDTO;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyGroupUpdateDTO;
import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyGroupGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class StudyGroupService {

    GetStudyGroupBean getStudyGroupBean;  // 특정 스터디그룹 조회
    GetStudyGroupsBean getStudyGroupsBean; // 전체 스터디그룹 조회
    SaveStudyGroupBean saveStudyGroupBean; // 스터디그룹 생성
    UpdateStudyGroupBean updateStudyGroupBean; // 스터디그룹 수정
    // 스터디그룹 삭제

    @Autowired
    public StudyGroupService(GetStudyGroupBean getStudyGroupBean,GetStudyGroupsBean getStudyGroupsBean,SaveStudyGroupBean saveStudyGroupBean,UpdateStudyGroupBean updateStudyGroupBean){
        this.getStudyGroupBean = getStudyGroupBean;
        this.getStudyGroupsBean = getStudyGroupsBean;
        this.saveStudyGroupBean = saveStudyGroupBean;
        this.updateStudyGroupBean = updateStudyGroupBean;




    }

    // 특정 스터디그룹 조회
    public ResponseStudyGroupGetDTO getStudyGroup(UUID studyGroupId){
        return getStudyGroupBean.exec(studyGroupId);
    }




    // 전체 스터디그룹 조회
    public List<ResponseStudyGroupGetDTO> getStudyGroups(UUID studyGroupId){
        return getStudyGroupsBean.exec(studyGroupId);
    }




    // 스터디그룹 저장
    public UUID saveStudyGroup(RequestStudyGroupSaveDTO requestStudyGroupSaveDTO){
        return saveStudyGroupBean.exec(requestStudyGroupSaveDTO);
    }



    // 스터디그룹 수정
    public UUID updateStudyGroup(RequestStudyGroupUpdateDTO requestStudyGroupUpdateDTO){
        return updateStudyGroupBean.exec(requestStudyGroupUpdateDTO);
    }



    // 스터디그룹 삭제


}


