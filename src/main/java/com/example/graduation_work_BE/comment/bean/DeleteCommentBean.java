package com.example.graduation_work_BE.comment.bean;

import com.example.graduation_work_BE.comment.bean.small.DeleteCommentDAOBean;
import com.example.graduation_work_BE.comment.bean.small.GetCommentDAOBean;
import com.example.graduation_work_BE.comment.bean.small.SaveCommentDAOBean;
import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteCommentBean {

    GetCommentDAOBean getCommentDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public DeleteCommentBean(GetCommentDAOBean getCommentDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.getCommentDAOBean = getCommentDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    public UUID exec(RequestCommentDeleteDTO requestCommentDeleteDTO){
        CommentDAO commentDAO = getCommentDAOBean.exec(requestCommentDeleteDTO.getCommentId());
        if (commentDAO == null) return null;

        commentDAO.setIsDeleted(true);

        saveCommentDAOBean.exec(commentDAO);

        return commentDAO.getCommentId();
    }
}
