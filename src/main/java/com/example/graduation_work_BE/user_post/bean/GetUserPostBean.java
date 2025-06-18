package com.example.graduation_work_BE.user_post.bean;

import com.example.graduation_work_BE.user_post.bean.small.CreateUserPostDTOBean;
import com.example.graduation_work_BE.user_post.bean.small.GetUserPostDAOBean;
import com.example.graduation_work_BE.user_post.entity.DTO.ResponseUserPostGetDTO;
import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserPostBean {

    GetUserPostDAOBean getUserPostDAOBean;
    CreateUserPostDTOBean createUserPostDTOBean;

    @Autowired
    public GetUserPostBean(GetUserPostDAOBean getUserPostDAOBean, CreateUserPostDTOBean createUserPostDTOBean){
        this.getUserPostDAOBean = getUserPostDAOBean;
        this.createUserPostDTOBean = createUserPostDTOBean;
    }

    public ResponseUserPostGetDTO exec(UUID userPostId){

        UserPostDAO userPostDAO = getUserPostDAOBean.exec(userPostId);
        if (userPostDAO == null) return null;

        return createUserPostDTOBean.exec(userPostDAO);
    }
}
