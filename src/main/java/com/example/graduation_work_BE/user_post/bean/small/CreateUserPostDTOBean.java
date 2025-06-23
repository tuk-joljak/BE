package com.example.graduation_work_BE.user_post.bean.small;

import com.example.graduation_work_BE.user_post.entity.DTO.ResponseUserPostGetDTO;
import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.stereotype.Component;

@Component
public class CreateUserPostDTOBean {

    public ResponseUserPostGetDTO exec(UserPostDAO userPostDAO){
        return ResponseUserPostGetDTO.builder()
                .userPostId(userPostDAO.getUserPostId())
                .postTitle(userPostDAO.getPostTitle())
                .postContent(userPostDAO.getPostContent())
                .isFinish(userPostDAO.getIsFinish())
                .build();
    }
}
