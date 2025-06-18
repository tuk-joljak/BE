package com.example.graduation_work_BE.comment.bean.small;

import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentSaveDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateCommentDAOBean {
    public CommentDAO exec(RequestCommentSaveDTO requestCommentSaveDTO){
        return CommentDAO.builder()
                .commentId(UUID.randomUUID())
                .targetId(requestCommentSaveDTO.getTargetId())
                .userId(requestCommentSaveDTO.getUserId())
                .content(requestCommentSaveDTO.getContent())
                .isDeleted(false)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .type(requestCommentSaveDTO.getType())
                .build();
    }
}
