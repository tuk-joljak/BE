package com.example.graduation_work_BE.comment.bean;

import com.example.graduation_work_BE.comment.bean.small.CreateCommentsDTOBean;
import com.example.graduation_work_BE.comment.bean.small.GetCommentDAOBean;
import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.DTO.ResponseCommentsGetDTO;
import com.example.graduation_work_BE.comment.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetCommentsBean {

    GetCommentDAOBean getCommentDAOBean;
    CreateCommentsDTOBean createCommentsDTOBean;

    @Autowired
    public GetCommentsBean(GetCommentDAOBean getCommentDAOBean, CreateCommentsDTOBean createCommentsDTOBean) {
        this.getCommentDAOBean = getCommentDAOBean;
        this.createCommentsDTOBean = createCommentsDTOBean;
    }

    public List<ResponseCommentsGetDTO> exec(Type type, UUID targetId){
        // db에서 댓글에 대한 DAO 가져오기
        List<CommentDAO> commentDAOS = getCommentDAOBean.exec(type, targetId);
        if (commentDAOS == null) return null;

        // DTO 생성 후 넣기
        return createCommentsDTOBean.exec(commentDAOS);
    }


}
