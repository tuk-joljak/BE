package com.example.graduation_work_BE.user.bean.small;

import com.example.graduation_work_BE.user.entity.UserDAO;
import com.example.graduation_work_BE.user.repository.UserRepositoryJPA;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


@Component
public class SaveUserDAOBean {

    UserRepositoryJPA userRepositoryJPA;

    @Autowired
    public SaveUserDAOBean(UserRepositoryJPA userRepositoryJPA){
        this.userRepositoryJPA = userRepositoryJPA;
    }

    public void exec(UserDAO userDAO){
        userRepositoryJPA.save(userDAO);
    }
}