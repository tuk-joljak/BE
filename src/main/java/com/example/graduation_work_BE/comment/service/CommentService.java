package com.example.graduation_work_BE.comment.service;

import com.example.graduation_work_BE.comment.bean.DeleteCommentBean;
import com.example.graduation_work_BE.comment.bean.GetCommentsBean;
import com.example.graduation_work_BE.comment.bean.SaveCommentBean;
import com.example.graduation_work_BE.comment.bean.UpdateCommentBean;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentDeleteDTO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentSaveDTO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentUpdateDTO;
import com.example.graduation_work_BE.comment.domain.DTO.ResponseCommentsGetDTO;
import com.example.graduation_work_BE.comment.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    GetCommentsBean getCommentsBean;
    SaveCommentBean saveCommentBean;
    UpdateCommentBean updateCommentBean;
    DeleteCommentBean deleteCommentBean;

    @Autowired
    public CommentService(GetCommentsBean getCommentsBean, SaveCommentBean saveCommentBean, UpdateCommentBean updateCommentBean, DeleteCommentBean deleteCommentBean){
        this.getCommentsBean = getCommentsBean;
        this.saveCommentBean = saveCommentBean;
        this.updateCommentBean = updateCommentBean;
        this.deleteCommentBean = deleteCommentBean;
    }

    // 댓글 전체 조회
    public List<ResponseCommentsGetDTO> getComments(Type type, UUID targetId){
        return getCommentsBean.exec(type, targetId);
    }

    // 댓글 저장
    public UUID saveComment(RequestCommentSaveDTO requestCommentSaveDTO){
        return saveCommentBean.exec(requestCommentSaveDTO);
    }

    // 댓글 수정
    public UUID updateComment(RequestCommentUpdateDTO requestCommentUpdateDTO){
        return updateCommentBean.exec(requestCommentUpdateDTO);
    }

    // 댓글 삭제
    public UUID deleteComment(RequestCommentDeleteDTO requestCommentDeleteDTO){
        return deleteCommentBean.exec(requestCommentDeleteDTO);
    }
}
