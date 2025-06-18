package com.example.graduation_work_BE.user_post.bean.small;

import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostSaveDTO;
import com.example.graduation_work_BE.user_post.entity.UserPostDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateUserPostDAOBean {

    public UserPostDAO exec(RequestUserPostSaveDTO requestUserPostSaveDTO){
        return UserPostDAO.builder()
                .userPostId(UUID.randomUUID())
                .userId(requestUserPostSaveDTO.getUserId())
                .postTitle(requestUserPostSaveDTO.getPostTitle())
                .postContent(requestUserPostSaveDTO.getPostContent())
                .isFinish(false)
                .createAt(LocalDateTime.now())
                .uploadAt(LocalDateTime.now())
                .build();
    }
}
