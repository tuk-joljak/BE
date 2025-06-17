package com.example.graduation_work_BE.user_post.bean;

import com.example.graduation_work_BE.user_post.bean.small.CreateUserPostDAOBean;
import com.example.graduation_work_BE.user_post.bean.small.SaveUserPostDAOBean;
import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostSaveDTO;
import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveUserPostBean {

    CreateUserPostDAOBean createUserPostDAOBean;
    SaveUserPostDAOBean saveUserPostDAOBean;

    @Autowired
    public SaveUserPostBean(CreateUserPostDAOBean createUserPostDAOBean, SaveUserPostDAOBean saveUserPostDAOBean){
        this.createUserPostDAOBean = createUserPostDAOBean;
        this.saveUserPostDAOBean = saveUserPostDAOBean;
    }

    public UUID exec(RequestUserPostSaveDTO requestUserPostSaveDTO){
        // DAO객체에다 정보를 넣어야겟죠
        UserPostDAO userPostDAO = createUserPostDAOBean.exec(requestUserPostSaveDTO);
        if (userPostDAO == null) return null;

        // DAO객체에 넣은 정보를 토대로 DB에 저장
        saveUserPostDAOBean.exec(userPostDAO);

        // 넣은 DAO값의 PK값을 반환
        return userPostDAO.getUserPostId();
    }
}
