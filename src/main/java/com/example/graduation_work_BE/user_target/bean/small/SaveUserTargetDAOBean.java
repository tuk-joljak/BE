package com.example.graduation_work_BE.user_target.bean.small;

import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import com.example.graduation_work_BE.user_target.repository.UserTargetRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserTargetDAOBean {

    UserTargetRepositoryJPA userTargetRepositoryJPA;

    @Autowired
    public SaveUserTargetDAOBean(UserTargetRepositoryJPA userTargetRepositoryJPA){
        this.userTargetRepositoryJPA = userTargetRepositoryJPA;
    }

    public void exec(UserTargetDAO userTargetDAO){
        userTargetRepositoryJPA.save(userTargetDAO);
    }
}
