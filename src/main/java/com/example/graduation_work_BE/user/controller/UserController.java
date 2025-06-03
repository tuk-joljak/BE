package com.example.graduation_work_BE.user.controller;

import com.example.graduation_work_BE.user.entity.DTO.ResponseUserGetDTO;
import com.example.graduation_work_BE.user.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // 로그인
    @GetMapping("/login/oauth2/code/{registrationId}")
    public ResponseEntity<Map<String, Object>> googleLogin(@RequestParam String code, @PathVariable String registrationId) {

        try {
            UUID userId = userService.socialLogin(code, registrationId);

            // HTTP 상태 반환
            HttpStatus httpStatus = (userId != null) ? HttpStatus.PERMANENT_REDIRECT : HttpStatus.INTERNAL_SERVER_ERROR;

            String redirectUrl = "http://localhost:8080/user" + userId;

            // 헤더 추가 및 Redirect:
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(redirectUrl));

            return ResponseEntity.status(httpStatus).headers(headers).body(new HashMap<>());

        } catch (Exception e) {
            // 예외가 발생한 경우 로깅
            e.printStackTrace(); // 에러 내용 로깅

            // 에러 응답 반환
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("message", "Internal Server Error");
            errorMap.put("detail", e.getMessage()); // 예외 메시지를 추가로 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
        }
    }

    // 유저 조회
    @GetMapping("user/{userId}")
    public ResponseUserGetDTO getUser(@PathVariable UUID userId){
        return userService.getUser(userId);
    }

}
