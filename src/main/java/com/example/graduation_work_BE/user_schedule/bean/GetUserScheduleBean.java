package com.example.graduation_work_BE.user_schedule.bean;

import com.example.graduation_work_BE.user_schedule.bean.small.CreateUserScheduleDTOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.GetUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.entity.DTO.ResponseUserScheduleGetDTO;
import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserScheduleBean {

    GetUserScheduleDAOBean getUserScheduleDAOBean;
    CreateUserScheduleDTOBean createUserScheduleDTOBean;

    @Autowired
    public GetUserScheduleBean(GetUserScheduleDAOBean getUserScheduleDAOBean, CreateUserScheduleDTOBean createUserScheduleDTOBean){
        this.getUserScheduleDAOBean = getUserScheduleDAOBean;
        this.createUserScheduleDTOBean = createUserScheduleDTOBean;
    }

    public ResponseUserScheduleGetDTO exec(UUID userScheduleId){

        UserScheduleDAO userScheduleDAO = getUserScheduleDAOBean.exec(userScheduleId);
        if (userScheduleId == null) return null;

        return createUserScheduleDTOBean.exec(userScheduleDAO);
    }
}
