package com.example.graduation_work_BE.user.bean.small;

import com.example.graduation_work_BE.user.entity.DTO.ResponseUserGetDTO;
import com.example.graduation_work_BE.user.entity.UserDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDTOBean {

    public ResponseUserGetDTO exec(UserDAO userDAO){
        return ResponseUserGetDTO.builder()
                .userId(userDAO.getUserId())
                .userName(userDAO.getUserName())
                .build();
    }
}
