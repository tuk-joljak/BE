package com.example.graduation_work_BE.user_schedule.bean;

import com.example.graduation_work_BE.user_schedule.bean.small.CreateUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.CreateUserSchedulesDTOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.GetUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.bean.small.SaveUserScheduleDAOBean;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleUpdateDTO;
import com.example.graduation_work_BE.user_schedule.entity.UserScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateUserScheduleBean {

    GetUserScheduleDAOBean getUserScheduleDAOBean;
    SaveUserScheduleDAOBean saveUserScheduleDAOBean;

    @Autowired
    public UpdateUserScheduleBean( GetUserScheduleDAOBean getUserScheduleDAOBean, SaveUserScheduleDAOBean saveUserScheduleDAOBean) {
        this.saveUserScheduleDAOBean = saveUserScheduleDAOBean;
        this.getUserScheduleDAOBean = getUserScheduleDAOBean;
    }

    public UUID exec(RequestUserScheduleUpdateDTO requestUserScheduleUpdateDTO){
        // 1. userScheduleId로 db에서 찾아와서 DAO 객체에다가 넣는다
        UserScheduleDAO userScheduleDAO = getUserScheduleDAOBean.exec(requestUserScheduleUpdateDTO.getUserScheduleId());

        // 2. DAO 값을 수정한다
        userScheduleDAO.setScheduleContent(requestUserScheduleUpdateDTO.getScheduleContent());
        userScheduleDAO.setStartDate(requestUserScheduleUpdateDTO.getStartDate());
        userScheduleDAO.setEndDate(requestUserScheduleUpdateDTO.getEndDate());
        userScheduleDAO.setUploadAt(LocalDateTime.now());

        // 3. DAO를 db에 저장한다
        saveUserScheduleDAOBean.exec(userScheduleDAO);

        // 4. UUID 서비스, 컨트롤러로 반환
        return userScheduleDAO.getUserScheduleId();
    }
}
