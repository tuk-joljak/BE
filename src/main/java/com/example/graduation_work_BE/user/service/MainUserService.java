package com.example.graduation_work_BE.user.service;

import com.example.graduation_work_BE.user.bean.GetMainUserBean;
import com.example.graduation_work_BE.user.bean.SaveMainUserBean;
import com.example.graduation_work_BE.user.entity.DTO.RequestMainUserSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MainUserService {

    GetMainUserBean getMainUserBean;
    SaveMainUserBean saveMainUserBean;

    @Autowired
    public MainUserService(GetMainUserBean getMainUserBean, SaveMainUserBean saveMainUserBean) {
        this.getMainUserBean = getMainUserBean;
        this.saveMainUserBean = saveMainUserBean;
    }

    // 유저 로그인
    public UUID getMainUser(String loginId, String password) {
        return getMainUserBean.exec(loginId, password);
    }

    // 사용자 정보 저장
    public UUID saveMainUser(RequestMainUserSaveDTO requestMainUserSaveDTO) {
        return saveMainUserBean.exec(requestMainUserSaveDTO);
    }
}
