package com.example.graduation_work_BE.user_target.bean.small;

import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import com.example.graduation_work_BE.user_target.entity.DTO.ResponseUserTargetGetDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserTargetDTOBean {

    public ResponseUserTargetGetDTO exec(UserTargetDAO userTargetDAO){
        return ResponseUserTargetGetDTO.builder()
                .targetContent(userTargetDAO.getTargetContent())
                .isFinish(userTargetDAO.getIsFinish())
                .build();
    }
}
