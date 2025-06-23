package com.example.graduation_work_BE.comment.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseCommentsGetDTO {
    UUID commentId;
    UUID userId;
    String content;
}
