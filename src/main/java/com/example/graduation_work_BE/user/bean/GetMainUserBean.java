package com.example.graduation_work_BE.user.bean;

import com.example.graduation_work_BE.user.bean.small.GetMainUserDAOBean;
import com.example.graduation_work_BE.user.entity.MainUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetMainUserBean {

    GetMainUserDAOBean getMainUserDAOBean;

    @Autowired
    public GetMainUserBean(GetMainUserDAOBean getMainUserDAOBean) {
        this.getMainUserDAOBean = getMainUserDAOBean;
    }

    // 유저 로그인
    public UUID exec(String loginId, String password) {

        // 유저 조회
        MainUserDAO mainUserDAO = getMainUserDAOBean.exec(loginId, password);

        return mainUserDAO.getMainUserId();
    }
}
