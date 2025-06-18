package com.example.graduation_work_BE.comment.repository;

import com.example.graduation_work_BE.comment.domain.CommentDAO;
import com.example.graduation_work_BE.comment.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepositoryJPA extends JpaRepository<CommentDAO, UUID> {

    // 타입(공고, 커뮤니티)와 해당 타입의 UUID와 삭제되지 않은 댓글 전체 최신순으로 조회
    List<CommentDAO> findAllByTypeAndTargetIdAndIsDeletedFalseOrderByCreateAtDesc(Type type, UUID targetId);

    // UUID로 해당 댓글 가져오기
    CommentDAO findByCommentId(UUID commentId);
}
