package com.example.graduation_work_BE.user_schedule.bean.small;

import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleSaveDTO;
import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateUserScheduleDAOBean {

    public UserScheduleDAO exec(RequestUserScheduleSaveDTO requestUserScheduleSaveDTO){
        return UserScheduleDAO.builder()
                .userScheduleId(UUID.randomUUID())
                .userId(requestUserScheduleSaveDTO.getUserId())
                .scheduleContent(requestUserScheduleSaveDTO.getScheduleContent())
                .startDate(requestUserScheduleSaveDTO.getStartDate())
                .endDate(requestUserScheduleSaveDTO.getEndDate())
                .isFinish(false)
                .createAt(LocalDateTime.now())
                .uploadAt(LocalDateTime.now())
                .build();
    }
}
