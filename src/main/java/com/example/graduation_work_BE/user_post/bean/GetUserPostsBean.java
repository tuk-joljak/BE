package com.example.graduation_work_BE.user_post.bean;

import com.example.graduation_work_BE.user_post.bean.small.CreateUserPostsDTOBean;
import com.example.graduation_work_BE.user_post.bean.small.GetUserPostsDAOBean;
import com.example.graduation_work_BE.user_post.entity.DTO.ResponseUserPostGetDTO;
import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserPostsBean {

    GetUserPostsDAOBean getUserPostsDAOBean;
    CreateUserPostsDTOBean createUserPostsDTOBean;

    @Autowired
    public GetUserPostsBean(GetUserPostsDAOBean getUserPostsDAOBean, CreateUserPostsDTOBean createUserPostsDTOBean){
        this.getUserPostsDAOBean = getUserPostsDAOBean;
        this.createUserPostsDTOBean = createUserPostsDTOBean;
    }

    public List<ResponseUserPostGetDTO> exec(UUID userId){
        List<UserPostDAO> userPostDAOS = getUserPostsDAOBean.exec(userId);
        if (userPostDAOS == null) return null;

        return createUserPostsDTOBean.exec(userPostDAOS);
    }
}
