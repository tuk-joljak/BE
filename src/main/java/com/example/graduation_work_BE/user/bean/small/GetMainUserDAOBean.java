package com.example.graduation_work_BE.user.bean.small;

import com.example.graduation_work_BE.user.entity.MainUserDAO;
import com.example.graduation_work_BE.user.repository.MainUserRepositoryJPA;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetMainUserDAOBean {

    MainUserRepositoryJPA mainUserRepositoryJPA;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public GetMainUserDAOBean(MainUserRepositoryJPA mainUserRepositoryJPA, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.mainUserRepositoryJPA = mainUserRepositoryJPA;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public MainUserDAO exec(UUID mainUserId) {

        MainUserDAO dao = mainUserRepositoryJPA.findByMainUserId(mainUserId);
        if (dao == null) return null;

        return dao;

    }

    // 사용자 정보 조회
    public MainUserDAO exec(String loginId, String password) {

        MainUserDAO dao = mainUserRepositoryJPA.findByLoginId(loginId);
        if (dao == null) return null;

        if (!bCryptPasswordEncoder.matches(password, dao.getPassword())) return null;

        return dao;
    }
}
