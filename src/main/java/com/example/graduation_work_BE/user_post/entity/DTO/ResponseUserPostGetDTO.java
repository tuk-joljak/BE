package com.example.graduation_work_BE.user_post.entity.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseUserPostGetDTO {
    UUID userPostId;
    String postTitle;
    String postContent;

    Boolean isFinish;

}
