package com.example.graduation_work_BE.user_schedule.bean.small;

import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import com.example.graduation_work_BE.user_schedule.repository.UserScheduleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserScheduleDAOBean {

    UserScheduleRepositoryJPA userScheduleRepository;

    @Autowired
    public DeleteUserScheduleDAOBean(UserScheduleRepositoryJPA userScheduleRepositoryJPA){
        this.userScheduleRepository = userScheduleRepositoryJPA;
    }
    public void exec(UserScheduleDAO userScheduleDAO){
        userScheduleRepository.delete(userScheduleDAO);
    }
}
