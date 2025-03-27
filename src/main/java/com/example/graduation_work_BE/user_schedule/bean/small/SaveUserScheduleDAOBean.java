package com.example.graduation_work_BE.user_schedule.bean.small;

import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import com.example.graduation_work_BE.user_schedule.repository.UserScheduleRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveUserScheduleDAOBean {

    UserScheduleRepositoryJPA userScheduleRepositoryJPA;

    @Autowired
    public SaveUserScheduleDAOBean(UserScheduleRepositoryJPA userScheduleRepositoryJPA){
        this.userScheduleRepositoryJPA = userScheduleRepositoryJPA;
    }

    public void exec(UserScheduleDAO userScheduleDAO){
        userScheduleRepositoryJPA.save(userScheduleDAO);
    }
}
