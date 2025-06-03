package com.example.graduation_work_BE.user.bean.small;

import com.example.graduation_work_BE.user.entity.UserDAO;
import com.example.graduation_work_BE.user.repository.UserRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUserDAOBean {

    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public GetUserDAOBean(UserRepositoryJPA userRepositoryJPA){
        this.userRepositoryJPA = userRepositoryJPA;
    }

    // oauthId로 유저 검색
    public UserDAO exec(String oauthId){
        return userRepositoryJPA.findByOauthId(oauthId);
    }

    // userId로 유저 검색
    public UserDAO exec(UUID userId) {
        return userRepositoryJPA.findByUserId(userId);
    }
}
