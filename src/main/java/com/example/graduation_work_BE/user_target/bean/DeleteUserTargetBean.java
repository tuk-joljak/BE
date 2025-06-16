package com.example.graduation_work_BE.user_target.bean;

import com.example.graduation_work_BE.user_target.bean.small.DeleteUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.bean.small.GetUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.entity.DTO.RequestUserTargetDeleteDTO;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteUserTargetBean {
    GetUserTargetDAOBean getUserTargetDAOBean;
    DeleteUserTargetDAOBean deleteUserTargetDAOBean;

    @Autowired
    public DeleteUserTargetBean(GetUserTargetDAOBean getUserTargetDAOBean, DeleteUserTargetDAOBean deleteUserTargetDAOBean){
        this.getUserTargetDAOBean = getUserTargetDAOBean;
        this.deleteUserTargetDAOBean = deleteUserTargetDAOBean;

    }
    public UUID exec(RequestUserTargetDeleteDTO requestUserTargetDeleteDTO){
        UserTargetDAO userTargetDAO = getUserTargetDAOBean.exec(requestUserTargetDeleteDTO.getUserTargetId());
        if (userTargetDAO == null) return null;

        deleteUserTargetDAOBean.exec(userTargetDAO);

        return userTargetDAO.getUserTargetId();
    }
}