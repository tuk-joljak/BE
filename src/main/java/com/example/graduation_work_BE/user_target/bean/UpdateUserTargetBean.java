package com.example.graduation_work_BE.user_target.bean;

import com.example.graduation_work_BE.user_target.bean.small.GetUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.bean.small.SaveUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.entity.DTO.RequestUserTargetUpdateDTO;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateUserTargetBean {

    GetUserTargetDAOBean getUserTargetDAOBean;
    SaveUserTargetDAOBean saveUserTargetDAOBean;

    @Autowired
    public UpdateUserTargetBean( GetUserTargetDAOBean getUserTargetDAOBean, SaveUserTargetDAOBean saveUserTargetDAOBean) {
        this.saveUserTargetDAOBean = saveUserTargetDAOBean;
        this.getUserTargetDAOBean = getUserTargetDAOBean;
    }

    public UUID exec(RequestUserTargetUpdateDTO requestUserTargetUpdateDTO){
        // 1. userTargetId로 db에서 찾아와서 DAO 객체에다가 넣는다
        UserTargetDAO userTargetDAO = getUserTargetDAOBean.exec(requestUserTargetUpdateDTO.getUserTargetId());
        if (userTargetDAO==null) return null;

        // 2. DAO 값을 수정한다
        userTargetDAO.setTargetContent(requestUserTargetUpdateDTO.getTargetContent());
        userTargetDAO.setUploadAt(LocalDateTime.now());

        // 3. DAO를 db에 저장한다
        saveUserTargetDAOBean.exec(userTargetDAO);

        // 4. UUID 서비스, 컨트롤러로 반환
        return userTargetDAO.getUserTargetId();
    }
}
