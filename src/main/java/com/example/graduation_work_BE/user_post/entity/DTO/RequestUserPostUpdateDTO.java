package com.example.graduation_work_BE.user_post.entity.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestUserPostUpdateDTO {
    UUID userPostId;

    String postTitle;
    String postContent;
}
