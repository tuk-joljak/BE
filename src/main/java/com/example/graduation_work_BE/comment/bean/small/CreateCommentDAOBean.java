package com.example.graduation_work_BE.comment.bean.small;

import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentSaveDTO;
import com.example.graduation_work_BE.comment.domain.Type;
import com.example.graduation_work_BE.job_posting.repository.JobPostingRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateCommentDAOBean {

    JobPostingRepositoryJPA jobPostingRepositoryJPA;

    @Autowired
    public CreateCommentDAOBean(JobPostingRepositoryJPA jobPostingRepositoryJPA){
        this.jobPostingRepositoryJPA = jobPostingRepositoryJPA;
    }

    public CommentDAO exec(RequestCommentSaveDTO requestCommentSaveDTO){

        Type type;

        // 먼저 Posting 게시글에서 찾기
//        if (communityRepository.existsById(targetId)) {
//            type = CommentType.COMMUNITY;
//        }
        // 다음으로 JOBPOSTING에서 찾기
        if (jobPostingRepositoryJPA.existsById(requestCommentSaveDTO.getTargetId())){
            type = Type.JOBPOSTING;
        } else {
            throw new IllegalArgumentException("Invalid targetId: no matching post found");
        }

        return CommentDAO.builder()
                .commentId(UUID.randomUUID())
                .targetId(requestCommentSaveDTO.getTargetId())
                .userId(requestCommentSaveDTO.getUserId())
                .content(requestCommentSaveDTO.getContent())
                .isDeleted(false)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .type(type)
                .build();
    }
}
