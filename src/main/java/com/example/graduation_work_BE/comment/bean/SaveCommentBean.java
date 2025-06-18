package com.example.graduation_work_BE.comment.bean;

import com.example.graduation_work_BE.comment.bean.small.CreateCommentDAOBean;
import com.example.graduation_work_BE.comment.bean.small.SaveCommentDAOBean;
import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SaveCommentBean {

    CreateCommentDAOBean createCommentDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public SaveCommentBean(CreateCommentDAOBean createCommentDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.createCommentDAOBean = createCommentDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    public UUID exec(RequestCommentSaveDTO requestCommentSaveDTO){
        CommentDAO commentDAO = createCommentDAOBean.exec(requestCommentSaveDTO);
        if (commentDAO == null) return null;

        saveCommentDAOBean.exec(commentDAO);

        return commentDAO.getCommentId();
    }
}
