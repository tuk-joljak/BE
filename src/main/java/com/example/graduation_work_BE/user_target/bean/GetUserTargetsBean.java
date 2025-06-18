package com.example.graduation_work_BE.user_target.bean;

import com.example.graduation_work_BE.user_target.bean.small.CreateUserTargetsDTOBean;
import com.example.graduation_work_BE.user_target.bean.small.GetUserTargetsDAOBean;
import com.example.graduation_work_BE.user_target.entity.DTO.ResponseUserTargetGetDTO;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserTargetsBean {

    GetUserTargetsDAOBean getUserTargetsDAOBean;
    CreateUserTargetsDTOBean createUserTargetsDTOBean;

    @Autowired
    public GetUserTargetsBean(GetUserTargetsDAOBean getUserTargetsDAOBean, CreateUserTargetsDTOBean createUserTargetsDTOBean){
        this.getUserTargetsDAOBean = getUserTargetsDAOBean;
        this.createUserTargetsDTOBean = createUserTargetsDTOBean;
    }

    public List<ResponseUserTargetGetDTO> exec(UUID userId){
        List<UserTargetDAO> userTargetDAOS = getUserTargetsDAOBean.exec(userId);
        if (userTargetDAOS == null) return null;

        return createUserTargetsDTOBean.exec(userTargetDAOS);
    }
}
