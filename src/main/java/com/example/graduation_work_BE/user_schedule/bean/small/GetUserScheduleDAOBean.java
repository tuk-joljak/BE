package com.example.graduation_work_BE.user_schedule.bean.small;

import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import com.example.graduation_work_BE.user_schedule.repository.UserScheduleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserScheduleDAOBean {

    UserScheduleRepositoryJPA userScheduleRepositoryJPA;

    @Autowired
    public GetUserScheduleDAOBean(UserScheduleRepositoryJPA userScheduleRepositoryJPA){
        this.userScheduleRepositoryJPA = userScheduleRepositoryJPA;
    }

    public UserScheduleDAO exec(UUID userScheduleId){
        return userScheduleRepositoryJPA.findById(userScheduleId).orElse(null);
    }
}
