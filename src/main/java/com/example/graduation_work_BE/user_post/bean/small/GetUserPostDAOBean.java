package com.example.graduation_work_BE.user_post.bean.small;

import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import com.example.graduation_work_BE.user_post.repository.UserPostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserPostDAOBean {

    UserPostRepositoryJPA userPostRepositoryJPA;

    @Autowired
    public GetUserPostDAOBean(UserPostRepositoryJPA userPostRepositoryJPA){
        this.userPostRepositoryJPA = userPostRepositoryJPA;
    }

    public UserPostDAO exec(UUID userPostId){
        return userPostRepositoryJPA.findById(userPostId).orElse(null);
    }
}
