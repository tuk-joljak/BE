package com.example.graduation_work_BE.user_target.bean.small;

import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import com.example.graduation_work_BE.user_target.repository.UserTargetRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserTargetDAOBean {

    UserTargetRepositoryJPA userTargetRepository;

    @Autowired
    public DeleteUserTargetDAOBean(UserTargetRepositoryJPA userTargetRepositoryJPA){
        this.userTargetRepository = userTargetRepositoryJPA;
    }
    public void exec(UserTargetDAO userTargetDAO){
        userTargetRepository.delete(userTargetDAO);
    }
}
