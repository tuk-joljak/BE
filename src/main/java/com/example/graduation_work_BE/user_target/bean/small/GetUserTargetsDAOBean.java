package com.example.graduation_work_BE.user_target.bean.small;

import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import com.example.graduation_work_BE.user_target.repository.UserTargetRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserTargetsDAOBean {

    UserTargetRepositoryJPA userTargetRepositoryJPA;

    @Autowired
    public GetUserTargetsDAOBean(UserTargetRepositoryJPA userTargetRepositoryJPA){
        this.userTargetRepositoryJPA = userTargetRepositoryJPA;
    }

    public List<UserTargetDAO> exec(UUID userId){
        return userTargetRepositoryJPA.findAll();
    }
}
