package com.example.graduation_work_BE.user_schedule.service;

import com.example.graduation_work_BE.job_posting.bean.GetJobPostingBean;
import com.example.graduation_work_BE.user_schedule.bean.*;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleDeleteDTO;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleSaveDTO;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleUpdateDTO;
import com.example.graduation_work_BE.user_schedule.entity.DTO.ResponseUserScheduleGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserScheduleService {

    GetUserScheduleBean getUserScheduleBean;
    GetUserSchedulesBean getUserSchedulesBean;
    SaveUserScheduleBean saveUserScheduleBean;
    UpdateUserScheduleBean updateUserScheduleBean;
    DeleteUserScheduleBean deleteUserScheduleBean;

    @Autowired
    public UserScheduleService(GetUserScheduleBean getUserScheduleBean, GetUserSchedulesBean getUserSchedulesBean, SaveUserScheduleBean saveUserScheduleBean, UpdateUserScheduleBean updateUserScheduleBean, DeleteUserScheduleBean deleteUserScheduleBean){
        this.getUserScheduleBean = getUserScheduleBean;
        this.getUserSchedulesBean = getUserSchedulesBean;
        this.saveUserScheduleBean = saveUserScheduleBean;
        this.updateUserScheduleBean = updateUserScheduleBean;
        this.deleteUserScheduleBean = deleteUserScheduleBean;
    }

    // 특정 일정 조회
    public ResponseUserScheduleGetDTO getUserSchedule(UUID userScheduleId){
        return getUserScheduleBean.exec(userScheduleId);
    }

    // 일정 전체 조회
    public List<ResponseUserScheduleGetDTO> getUserSchedules(UUID userId){
        return getUserSchedulesBean.exec(userId);
    }

    // 일정 저장
    public UUID saveUserSchedule(RequestUserScheduleSaveDTO requestUserScheduleSaveDTO){
        return saveUserScheduleBean.exec(requestUserScheduleSaveDTO);
    }


    // 일정 수정
    public UUID updateUserSchedule(RequestUserScheduleUpdateDTO requestUserScheduleUpdateDTO){
        return updateUserScheduleBean.exec(requestUserScheduleUpdateDTO);
    }



    // 일정 삭제
    public UUID deleteUserSchedule(RequestUserScheduleDeleteDTO requestUserScheduleDeleteDTO){
        return deleteUserScheduleBean.exec(requestUserScheduleDeleteDTO);
    }
}
