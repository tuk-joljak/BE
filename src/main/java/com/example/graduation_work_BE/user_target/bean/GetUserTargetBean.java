package com.example.graduation_work_BE.user_target.bean;

import com.example.graduation_work_BE.user_target.bean.small.CreateUserTargetDTOBean;
import com.example.graduation_work_BE.user_target.bean.small.GetUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import com.example.graduation_work_BE.user_target.entity.DTO.ResponseUserTargetGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserTargetBean {

    GetUserTargetDAOBean getUserTargetDAOBean;
    CreateUserTargetDTOBean createUserTargetDTOBean;

    @Autowired
    public GetUserTargetBean(GetUserTargetDAOBean getUserTargetDAOBean, CreateUserTargetDTOBean createUserTargetDTOBean){
        this.getUserTargetDAOBean = getUserTargetDAOBean;
        this.createUserTargetDTOBean = createUserTargetDTOBean;
    }

    public ResponseUserTargetGetDTO exec(UUID userTargetId){

        UserTargetDAO userTargetDAO = getUserTargetDAOBean.exec(userTargetId);
        if (userTargetDAO == null) return null;

        return createUserTargetDTOBean.exec(userTargetDAO);
    }
}
