package com.example.graduation_work_BE.user_schedule.bean.small;

import com.example.graduation_work_BE.user_schedule.entity.DTO.ResponseUserScheduleGetDTO;
import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserScheduleDTOBean {

    public ResponseUserScheduleGetDTO exec(UserScheduleDAO userScheduleDAO){
        return ResponseUserScheduleGetDTO.builder()
                .scheduleContent(userScheduleDAO.getScheduleContent())
                .startDate(userScheduleDAO.getStartDate())
                .endDate(userScheduleDAO.getEndDate())
                .isFinish(userScheduleDAO.getIsFinish())
                .build();
    }
}
