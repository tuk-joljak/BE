package com.example.graduation_work_BE.user_post.bean;

import com.example.graduation_work_BE.user_post.bean.small.GetUserPostDAOBean;
import com.example.graduation_work_BE.user_post.bean.small.SaveUserPostDAOBean;
import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostUpdateDTO;
import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateUserPostBean {

    GetUserPostDAOBean getUserPostDAOBean;
    SaveUserPostDAOBean saveUserPostDAOBean;

    @Autowired
    public UpdateUserPostBean( GetUserPostDAOBean getUserPostDAOBean, SaveUserPostDAOBean saveUserPostDAOBean) {
        this.saveUserPostDAOBean = saveUserPostDAOBean;
        this.getUserPostDAOBean = getUserPostDAOBean;
    }

    public UUID exec(RequestUserPostUpdateDTO requestUserPostUpdateDTO){
        // 1. userPostId로 db에서 찾아와서 DAO 객체에다가 넣는다
        UserPostDAO userPostDAO = getUserPostDAOBean.exec(requestUserPostUpdateDTO.getUserPostId());
        if (userPostDAO==null) return null;

        // 2. DAO 값을 수정한다
        userPostDAO.setPostTitle(requestUserPostUpdateDTO.getPostTitle());
        userPostDAO.setPostContent(requestUserPostUpdateDTO.getPostContent());
        userPostDAO.setUploadAt(LocalDateTime.now());

        // 3. DAO를 db에 저장한다
        saveUserPostDAOBean.exec(userPostDAO);

        // 4. UUID 서비스, 컨트롤러로 반환
        return userPostDAO.getUserPostId();
    }
}
