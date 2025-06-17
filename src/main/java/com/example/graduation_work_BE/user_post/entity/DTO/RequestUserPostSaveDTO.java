package com.example.graduation_work_BE.user_post.entity.DTO;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class RequestUserPostSaveDTO {
    UUID userId;

    String postTitle;
    String postContent;

}
