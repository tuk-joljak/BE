package com.example.graduation_work_BE.comment.bean.small;

import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.DTO.ResponseCommentsGetDTO;
import com.example.graduation_work_BE.job_posting.domain.DTO.ResponseJobPostingsGetDTO;
import com.example.graduation_work_BE.job_posting.domain.JobPostingDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateCommentsDTOBean {

    public ResponseCommentsGetDTO exec(CommentDAO commentDAO){
        return ResponseCommentsGetDTO.builder()
                .userId(commentDAO.getUserId())
                .content(commentDAO.getContent())
                .build();
    }

    public List<ResponseCommentsGetDTO> exec(List<CommentDAO> commentDAOS){
        // list로 된 빈 DTO 생성
        List<ResponseCommentsGetDTO> responseCommentsGetDTOS = new ArrayList<>();

        // 댓글 전체 리스트로 가져오기
        for (CommentDAO commentDAO : commentDAOS){
            ResponseCommentsGetDTO responseCommentsGetDTO = exec(commentDAO);

            responseCommentsGetDTOS.add(responseCommentsGetDTO);
        }

        // 반환
        return responseCommentsGetDTOS;
    }
}
