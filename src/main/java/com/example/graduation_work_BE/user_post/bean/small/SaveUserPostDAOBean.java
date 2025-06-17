package com.example.graduation_work_BE.user_post.bean.small;

import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import com.example.graduation_work_BE.user_post.repository.UserPostRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserPostDAOBean {

    UserPostRepositoryJPA userPostRepositoryJPA;

    @Autowired
    public SaveUserPostDAOBean(UserPostRepositoryJPA userPostRepositoryJPA){
        this.userPostRepositoryJPA = userPostRepositoryJPA;
    }

    public void exec(UserPostDAO userPostDAO){
        userPostRepositoryJPA.save(userPostDAO);
    }
}
