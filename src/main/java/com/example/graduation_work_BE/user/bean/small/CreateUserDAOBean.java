package com.example.graduation_work_BE.user.bean.small;

import com.example.graduation_work_BE.user.entity.DTO.RequestMainUserSaveDTO;
import com.example.graduation_work_BE.user.entity.MainUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserDAOBean {

    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CreateUserDAOBean(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public MainUserDAO exec(RequestMainUserSaveDTO requestMainUserSaveDTO){
        return MainUserDAO.builder()
                .mainUserId(UUID.randomUUID())
                .mainUserName(requestMainUserSaveDTO.getMainUserName())
                .loginId(requestMainUserSaveDTO.getLoginId())
                .password(passwordEncoder.encode(requestMainUserSaveDTO.getPassword()))
                .build();
    }
}
