package com.example.graduation_work_BE.user_target.bean;

import com.example.graduation_work_BE.user_target.bean.small.CreateUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.bean.small.SaveUserTargetDAOBean;
import com.example.graduation_work_BE.user_target.entity.UserTargetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class SaveUserTargetByAiBean {

    CreateUserTargetDAOBean createUserTargetDAOBean;
    SaveUserTargetDAOBean saveUserTargetDAOBean;

    @Autowired
    public SaveUserTargetByAiBean(CreateUserTargetDAOBean createUserTargetDAOBean, SaveUserTargetDAOBean saveUserTargetDAOBean) {
        this.createUserTargetDAOBean = createUserTargetDAOBean;
        this.saveUserTargetDAOBean = saveUserTargetDAOBean;
    }

    // ai 목표 저장
    public void exec(UUID userId, String aiResponseText){
        List<UserTargetDAO> userTargetDAOS = createUserTargetDAOBean.exec(userId, aiResponseText);

        saveUserTargetDAOBean.exec(userTargetDAOS);
    }
}
