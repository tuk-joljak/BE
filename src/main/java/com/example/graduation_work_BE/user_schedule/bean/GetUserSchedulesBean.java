package com.example.graduation_work_BE.user_schedule.bean;

import com.example.graduation_work_BE.user_schedule.bean.small.CreateUserScheduleDTOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.CreateUserSchedulesDTOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.GetUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.GetUserSchedulesDAOBean;
import com.example.graduation_work_BE.user_schedule.entity.DTO.ResponseUserScheduleGetDTO;
import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserSchedulesBean {

    GetUserSchedulesDAOBean getUserSchedulesDAOBean;
    CreateUserSchedulesDTOBean createUserSchedulesDTOBean;

    @Autowired
    public GetUserSchedulesBean(GetUserSchedulesDAOBean getUserSchedulesDAOBean, CreateUserSchedulesDTOBean createUserSchedulesDTOBean){
        this.getUserSchedulesDAOBean = getUserSchedulesDAOBean;
        this.createUserSchedulesDTOBean = createUserSchedulesDTOBean;
    }

    public List<ResponseUserScheduleGetDTO> exec(UUID userId){
        List<UserScheduleDAO> userScheduleDAOS = getUserSchedulesDAOBean.exec(userId);
        if (userScheduleDAOS == null) return null;

        return createUserSchedulesDTOBean.exec(userScheduleDAOS);
    }
}
