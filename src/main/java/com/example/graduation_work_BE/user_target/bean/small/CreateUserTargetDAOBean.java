package com.example.graduation_work_BE.user_target.bean.small;

import com.example.graduation_work_BE.user_target.entity.DTO.RequestUserTargetSaveDTO;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateUserTargetDAOBean {

    public UserTargetDAO exec(RequestUserTargetSaveDTO requestUserTargetSaveDTO){
        return UserTargetDAO.builder()
                .userTargetId(UUID.randomUUID())
                .userId(requestUserTargetSaveDTO.getUserId())
                .targetContent(requestUserTargetSaveDTO.getTargetContent())
                .startTime(requestUserTargetSaveDTO.getStartTime())
                .endTime(requestUserTargetSaveDTO.getEndTime())
                .isFinish(false)
                .createAt(LocalDateTime.now())
                .uploadAt(LocalDateTime.now())
                .build();
    }
}
