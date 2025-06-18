package com.example.graduation_work_BE.user_target.bean.small;

import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import com.example.graduation_work_BE.user_target.repository.UserTargetRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserTargetDAOBean {

    UserTargetRepositoryJPA userTargetRepositoryJPA;

    @Autowired
    public GetUserTargetDAOBean(UserTargetRepositoryJPA userTargetRepositoryJPA){
        this.userTargetRepositoryJPA = userTargetRepositoryJPA;
    }

    public UserTargetDAO exec(UUID userTargetId){
        return userTargetRepositoryJPA.findById(userTargetId).orElse(null);
    }
}
