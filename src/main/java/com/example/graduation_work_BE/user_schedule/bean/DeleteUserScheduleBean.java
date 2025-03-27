package com.example.graduation_work_BE.user_schedule.bean;

import com.example.graduation_work_BE.user_schedule.bean.small.DeleteUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.GetUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleDeleteDTO;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleUpdateDTO;
import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteUserScheduleBean {
    GetUserScheduleDAOBean getUserScheduleDAOBean;
    DeleteUserScheduleDAOBean deleteUserScheduleDAOBean;

    @Autowired
    public DeleteUserScheduleBean(GetUserScheduleDAOBean getUserScheduleDAOBean, DeleteUserScheduleDAOBean deleteUserScheduleDAOBean){
        this.getUserScheduleDAOBean = getUserScheduleDAOBean;
        this.deleteUserScheduleDAOBean = deleteUserScheduleDAOBean;

    }
    public UUID exec(RequestUserScheduleDeleteDTO requestUserScheduleDeleteDTO){
        UserScheduleDAO userScheduleDAO = getUserScheduleDAOBean.exec(requestUserScheduleDeleteDTO.getUserScheduleId());

        deleteUserScheduleDAOBean.exec(userScheduleDAO);

        return userScheduleDAO.getUserScheduleId();
    }
}