package com.example.graduation_work_BE.user_post.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserPostGetDTO {
    String postTitle;
    String postContent;

    Boolean isFinish;

}
