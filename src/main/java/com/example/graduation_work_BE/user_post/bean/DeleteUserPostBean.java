package com.example.graduation_work_BE.user_post.bean;

import com.example.graduation_work_BE.user_post.bean.small.DeleteUserPostDAOBean;
import com.example.graduation_work_BE.user_post.bean.small.GetUserPostDAOBean;
import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostDeleteDTO;
import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteUserPostBean {
    GetUserPostDAOBean getUserPostDAOBean;
    DeleteUserPostDAOBean deleteUserPostDAOBean;

    @Autowired
    public DeleteUserPostBean(GetUserPostDAOBean getUserPostDAOBean, DeleteUserPostDAOBean deleteUserPostDAOBean){
        this.getUserPostDAOBean = getUserPostDAOBean;
        this.deleteUserPostDAOBean = deleteUserPostDAOBean;

    }
    public UUID exec(RequestUserPostDeleteDTO requestUserPostDeleteDTO){
        UserPostDAO userPostDAO = getUserPostDAOBean.exec(requestUserPostDeleteDTO.getUserPostId());
        if (userPostDAO == null) return null;

        deleteUserPostDAOBean.exec(userPostDAO);

        return userPostDAO.getUserPostId();
    }
}