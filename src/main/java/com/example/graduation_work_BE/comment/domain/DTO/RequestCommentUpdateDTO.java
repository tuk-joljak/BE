package com.example.graduation_work_BE.comment.domain.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class RequestCommentUpdateDTO {
    UUID commentId;
    String content;
}
