package com.example.graduation_work_BE.comment.bean;

import com.example.graduation_work_BE.comment.bean.small.GetCommentDAOBean;
import com.example.graduation_work_BE.comment.bean.small.SaveCommentDAOBean;
import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class UpdateCommentBean {

    GetCommentDAOBean getCommentDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public UpdateCommentBean(GetCommentDAOBean getCommentDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.getCommentDAOBean = getCommentDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    public UUID exec(RequestCommentUpdateDTO requestCommentUpdateDTO){

        CommentDAO commentDAO = getCommentDAOBean.exec(requestCommentUpdateDTO.getCommentId());
        if (commentDAO == null) return null;

        commentDAO.setContent(requestCommentUpdateDTO.getContent());
        commentDAO.setUpdateAt(LocalDateTime.now());

        saveCommentDAOBean.exec(commentDAO);

        return commentDAO.getCommentId();
    }
}
