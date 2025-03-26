package com.example.graduation_work_BE.user_schedule.service;

import com.example.graduation_work_BE.user_schedule.bean.GetUserScheduleBean;
import com.example.graduation_work_BE.user_schedule.bean.GetUserSchedulesBean;
import com.example.graduation_work_BE.user_schedule.entity.DTO.ResponseUserScheduleGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserScheduleService {

    GetUserScheduleBean getUserScheduleBean;
    GetUserSchedulesBean getUserSchedulesBean;

    @Autowired
    public UserScheduleService(GetUserScheduleBean getUserScheduleBean, GetUserSchedulesBean getUserSchedulesBean){
        this.getUserScheduleBean = getUserScheduleBean;
        this.getUserSchedulesBean = getUserSchedulesBean;
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



    // 일정 수정



    // 일정 삭제
}
