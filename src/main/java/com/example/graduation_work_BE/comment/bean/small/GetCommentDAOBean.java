package com.example.graduation_work_BE.comment.bean.small;

import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.Type;
import com.example.graduation_work_BE.comment.repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetCommentDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public GetCommentDAOBean(CommentRepositoryJPA commentRepositoryJPA) {
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    public List<CommentDAO> exec(Type type, UUID targetId){
        return commentRepositoryJPA.findAllByTypeAndTargetIdAndIsDeletedFalseOrderByCreateAtDesc(type, targetId);
    }

    public CommentDAO exec(UUID commentId){
        return commentRepositoryJPA.findByCommentId(commentId);
    }
}
