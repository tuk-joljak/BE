package com.example.graduation_work_BE.study_group.service;

import com.example.graduation_work_BE.study_group.bean.SaveStudyGroupBean;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyGroupSaveDTO;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class StudyGroupService {

    // 스터디그룹 전체 조회
    // 스터디그룹 상세 조회
    SaveStudyGroupBean saveStudyGroupBean; // 스터디그룹 생성
    // 스터디그룹 수정
    // 스터디그룹 삭제

    @Autowired
    public StudyGroupService(SaveStudyGroupBean saveStudyGroupBean){
        this.saveStudyGroupBean = saveStudyGroupBean;



    }



    // 스터디그룹 전체조회




    // 스터디그룹 상세조회



    // 스터디그룹 저장
    public UUID saveStudyGroup(RequestStudyGroupSaveDTO requestStudyGroupSaveDTO){
        return saveStudyGroupBean.exec(requestStudyGroupSaveDTO);
    }



    // 스터디그룹 수정




    // 스터디그룹 삭제


}


