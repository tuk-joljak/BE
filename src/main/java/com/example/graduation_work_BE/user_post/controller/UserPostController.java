package com.example.graduation_work_BE.user_post.controller;

import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostDeleteDTO;
import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostSaveDTO;
import com.example.graduation_work_BE.user_post.entity.DTO.RequestUserPostUpdateDTO;
import com.example.graduation_work_BE.user_post.entity.DTO.ResponseUserPostGetDTO;
import com.example.graduation_work_BE.user_post.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("user/post")
@CrossOrigin("*")
public class UserPostController {

    UserPostService userPostService;

    @Autowired
    public UserPostController(UserPostService userPostService) {
        this.userPostService = userPostService;
    }
    // 특정 게시물 조회
    @GetMapping("/{userPostId}")
    public ResponseEntity<Map<String, Object>> getUserPost(@PathVariable("userPostId") UUID userPostId) {

        ResponseUserPostGetDTO responseUserPostGetDTO = userPostService.getUserPost(userPostId);

        boolean success = (responseUserPostGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "특정 게시물 조회 성공" : "특정 게시물 조회 실패");
        requestMap.put("userPostInfo", responseUserPostGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 전체 게시물 조회
    @GetMapping("/all/{userId}")
    public ResponseEntity<Map<String, Object>> getUserPosts(@PathVariable("userId") UUID userId) {

        List<ResponseUserPostGetDTO> responseUserPostsGetDTO = userPostService.getUserPosts(userId);

        boolean success = (responseUserPostsGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "전체 게시물 조회 성공" : "전체 게시물 조회 실패");
        requestMap.put("userPostList", responseUserPostsGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 게시물 저장
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveUserPost(@RequestBody RequestUserPostSaveDTO requestUserPostSaveDTO) {

        UUID userPostId = userPostService.saveUserPost(requestUserPostSaveDTO);

        boolean success = (userPostId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "게시물 저장 성공" : "게시물 저장 실패");
        requestMap.put("userPostId", userPostId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 게시물 수정
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateUserPost(@RequestBody RequestUserPostUpdateDTO requestUserPostUpdateDTO) {

        UUID userPostId = userPostService.updateUserPost(requestUserPostUpdateDTO);

        boolean success = (userPostId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "게시물 수정 성공" : "게시물 수정 실패");
        requestMap.put("userPostId", userPostId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 게시물 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteUserPost(@RequestBody RequestUserPostDeleteDTO requestUserPostDeleteDTO){

        UUID userPostId = userPostService.deleteUserPost(requestUserPostDeleteDTO);

        boolean success = (userPostId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "게시물 삭제 성공" : "게시물 삭제 실패");
        requestMap.put("userPostId", userPostId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



}
