package com.example.graduation_work_BE.comment.domain.DTO;

import com.example.graduation_work_BE.comment.domain.Type;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestCommentSaveDTO {
    UUID targetId;
    UUID userId;
    String content;
    Type type;
}
