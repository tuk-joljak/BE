package com.example.graduation_work_BE.user_schedule.bean;

import com.example.graduation_work_BE.user_schedule.bean.small.CreateUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.SaveUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleSaveDTO;
import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserScheduleBean {

    CreateUserScheduleDAOBean createUserScheduleDAOBean;
    SaveUserScheduleDAOBean saveUserScheduleDAOBean;

    @Autowired
    public SaveUserScheduleBean(CreateUserScheduleDAOBean createUserScheduleDAOBean, SaveUserScheduleDAOBean saveUserScheduleDAOBean){
        this.createUserScheduleDAOBean = createUserScheduleDAOBean;
        this.saveUserScheduleDAOBean = saveUserScheduleDAOBean;
    }

    public UUID exec(RequestUserScheduleSaveDTO requestUserScheduleSaveDTO){
        // DAO객체에다 정보를 넣어야겟죠
        UserScheduleDAO userScheduleDAO = createUserScheduleDAOBean.exec(requestUserScheduleSaveDTO);
        if (userScheduleDAO == null) return null;

        // DAO객체에 넣은 정보를 토대로 DB에 저장
        saveUserScheduleDAOBean.exec(userScheduleDAO);

        // 넣은 DAO값의 PK값을 반환
        return userScheduleDAO.getUserScheduleId();
    }
}
