package com.example.graduation_work_BE.user_schedule.bean.small;

import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import com.example.graduation_work_BE.user_schedule.repository.UserScheduleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetUserSchedulesDAOBean {

    UserScheduleRepositoryJPA userScheduleRepositoryJPA;

    @Autowired
    public GetUserSchedulesDAOBean(UserScheduleRepositoryJPA userScheduleRepositoryJPA){
        this.userScheduleRepositoryJPA = userScheduleRepositoryJPA;
    }

    public List<UserScheduleDAO> exec(UUID userId){
        return userScheduleRepositoryJPA.findAll();
    }
}
