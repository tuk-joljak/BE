package com.example.graduation_work_BE.comment.controller;

import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentDeleteDTO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentSaveDTO;
import com.example.graduation_work_BE.comment.domain.DTO.RequestCommentUpdateDTO;
import com.example.graduation_work_BE.comment.domain.DTO.ResponseCommentsGetDTO;
import com.example.graduation_work_BE.comment.domain.Type;
import com.example.graduation_work_BE.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {

    CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    // 댓글 전체 조회
    @GetMapping("/all/{type}/{targetId}")
    public ResponseEntity<Map<String, Object>> getAllComment(@PathVariable("type") Type type, @PathVariable("targetId") UUID targetId){

        List<ResponseCommentsGetDTO> responseCommentsGetDTOS = commentService.getComments(type, targetId);

        boolean success = (responseCommentsGetDTOS == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "댓글 전체 조회 성공" : "댓글 전체 조회 실패");
        requestMap.put("responseCommentsGetDTOS", responseCommentsGetDTOS);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 댓글 저장
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveComment(@RequestBody RequestCommentSaveDTO requestCommentSaveDTO){

        UUID commentId = commentService.saveComment(requestCommentSaveDTO);

        boolean success = (commentId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "댓글 저장 성공" : "댓글 저장 실패");
        requestMap.put("commentId", commentId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateComment(@RequestBody RequestCommentUpdateDTO requestCommentUpdateDTO){

        UUID commentId = commentService.updateComment(requestCommentUpdateDTO);

        boolean success = (commentId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "댓글 수정 성공" : "댓글 수정 실패");
        requestMap.put("commentId", commentId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 댓글 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteComment(@RequestBody RequestCommentDeleteDTO requestCommentDeleteDTO){

        UUID commentId = commentService.deleteComment(requestCommentDeleteDTO);

        boolean success = (commentId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "댓글 삭제 성공" : "댓글 삭제 실패");
        requestMap.put("commentId", commentId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}
