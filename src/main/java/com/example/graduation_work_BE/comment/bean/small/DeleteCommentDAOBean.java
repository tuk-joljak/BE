package com.example.graduation_work_BE.comment.bean.small;

import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.repository.CommentRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentDAOBean {

    CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    public DeleteCommentDAOBean(CommentRepositoryJPA commentRepositoryJPA){
        this.commentRepositoryJPA = commentRepositoryJPA;
    }

    public void exec(CommentDAO commentDAO){
        commentRepositoryJPA.delete(commentDAO);
    }
}
