package com.example.graduation_work_BE.user_target.bean;

import com.example.graduation_work_BE.user_target.bean.small.CreateUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.bean.small.SaveUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.entity.DTO.RequestUserTargetSaveDTO;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserTargetBean {

    CreateUserTargetDAOBean createUserTargetDAOBean;
    SaveUserTargetDAOBean saveUserTargetDAOBean;

    @Autowired
    public SaveUserTargetBean(CreateUserTargetDAOBean createUserTargetDAOBean, SaveUserTargetDAOBean saveUserTargetDAOBean){
        this.createUserTargetDAOBean = createUserTargetDAOBean;
        this.saveUserTargetDAOBean = saveUserTargetDAOBean;
    }

    public UUID exec(RequestUserTargetSaveDTO requestUserTargetSaveDTO){
        // DAO객체에다 정보를 넣어야겟죠
        UserTargetDAO userTargetDAO = createUserTargetDAOBean.exec(requestUserTargetSaveDTO);
        if (userTargetDAO == null) return null;

        // DAO객체에 넣은 정보를 토대로 DB에 저장
        saveUserTargetDAOBean.exec(userTargetDAO);

        // 넣은 DAO값의 PK값을 반환
        return userTargetDAO.getUserTargetId();
    }
}
