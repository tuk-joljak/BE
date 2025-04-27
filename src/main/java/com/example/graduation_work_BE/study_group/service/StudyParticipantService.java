package com.example.graduation_work_BE.study_group.service;

import com.example.graduation_work_BE.study_group.bean.DeleteStudyParticipantBean;
import com.example.graduation_work_BE.study_group.bean.GetStudyParticipantBean;
import com.example.graduation_work_BE.study_group.bean.SaveStudyParticipantBean;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyParticipantDeleteDTO;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyParticipantSaveDTO;
import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyParticipantGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudyParticipantService {

    GetStudyParticipantBean getStudyParticipantBean; // 스터디그룹 참여자 조회
    SaveStudyParticipantBean saveStudyParticipantBean; // 스터디그룹 참여자 생성
    DeleteStudyParticipantBean deleteStudyParticipantBean; // 스터디그룹 참여자 삭제

    @Autowired
    public StudyParticipantService(GetStudyParticipantBean getStudyParticipantBean, SaveStudyParticipantBean saveStudyParticipantBean, DeleteStudyParticipantBean deleteStudyParticipantBean) {
        this.getStudyParticipantBean = getStudyParticipantBean;
        this.saveStudyParticipantBean = saveStudyParticipantBean;
        this.deleteStudyParticipantBean = deleteStudyParticipantBean;
    }

    // 스터디그룹 참여자 조회
    public List<ResponseStudyParticipantGetDTO> getStudyParticipant(){
        return getStudyParticipantBean.exec();
    }

    // 스터디그룹 참여자 생성
    public UUID saveStudyParticipant(RequestStudyParticipantSaveDTO requestStudyParticipantSaveDTO){
        return saveStudyParticipantBean.exec(requestStudyParticipantSaveDTO);
    }

    // 스터디그룹 참여자 삭제
    public UUID deleteStudyParticipant(RequestStudyParticipantDeleteDTO requestStudyParticipantDeleteDTO){
        return deleteStudyParticipantBean.exec(requestStudyParticipantDeleteDTO);
    }
}
