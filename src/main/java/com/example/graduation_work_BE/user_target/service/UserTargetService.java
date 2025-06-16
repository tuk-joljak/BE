package com.example.graduation_work_BE.user_target.service;

import com.example.graduation_work_BE.user_target.bean.*;
import com.example.graduation_work_BE.user_target.entity.DTO.RequestUserTargetDeleteDTO;
import com.example.graduation_work_BE.user_target.entity.DTO.RequestUserTargetSaveDTO;
import com.example.graduation_work_BE.user_target.entity.DTO.RequestUserTargetUpdateDTO;
import com.example.graduation_work_BE.user_target.entity.DTO.ResponseUserTargetGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserTargetService {

    GetUserTargetBean getUserTargetBean;
    GetUserTargetsBean getUserTargetsBean;
    SaveUserTargetBean saveUserTargetBean;
    UpdateUserTargetBean updateUserTargetBean;
    DeleteUserTargetBean deleteUserTargetBean;

    @Autowired
    public UserTargetService(GetUserTargetBean getUserTargetBean, GetUserTargetsBean getUserTargetsBean, SaveUserTargetBean saveUserTargetBean, UpdateUserTargetBean updateUserTargetBean, DeleteUserTargetBean deleteUserTargetBean){
        this.getUserTargetBean = getUserTargetBean;
        this.getUserTargetsBean = getUserTargetsBean;
        this.saveUserTargetBean = saveUserTargetBean;
        this.updateUserTargetBean = updateUserTargetBean;
        this.deleteUserTargetBean = deleteUserTargetBean;
    }

    // 특정 목표 조회
    public ResponseUserTargetGetDTO getUserTarget(UUID userTargetId){
        return getUserTargetBean.exec(userTargetId);
    }
    // 전체 목표 조회
    public List<ResponseUserTargetGetDTO> getUserTargets(UUID userId){
        return getUserTargetsBean.exec(userId);
    }

    // 목표 저장
    public UUID saveUserTarget(RequestUserTargetSaveDTO requestUserTargetSaveDTO){
        return saveUserTargetBean.exec(requestUserTargetSaveDTO);
    }

    // 목표 수정
    public UUID updateUserTarget(RequestUserTargetUpdateDTO requestUserTargetUpdateDTO){
        return updateUserTargetBean.exec(requestUserTargetUpdateDTO);
    }


    // 목표 삭제
    public UUID deleteUserTarget(RequestUserTargetDeleteDTO requestUserTargetDeleteDTO){
        return deleteUserTargetBean.exec(requestUserTargetDeleteDTO);
    }

}
