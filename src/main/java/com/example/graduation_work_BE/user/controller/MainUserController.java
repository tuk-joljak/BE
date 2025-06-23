package com.example.graduation_work_BE.user.controller;

import com.example.graduation_work_BE.auth.AuthService;
import com.example.graduation_work_BE.user.entity.DTO.RequestMainUserSaveDTO;
import com.example.graduation_work_BE.user.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/main/user")
public class MainUserController {

    MainUserService mainUserService;
    AuthService authService;

    @Autowired
    public MainUserController(MainUserService mainUserService, AuthService authService) {
        this.mainUserService = mainUserService;
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getMainUser(
            @RequestParam("login-id") String loginId,
            @RequestParam("password") String password) {

        UUID mainUserId = mainUserService.getMainUser(loginId, password);
        boolean success = mainUserId != null;

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("mainUserId", mainUserId);
        response.put("message", success ? "유저 로그인 성공" : "로그인 실패");

        if (success) {
            String accessToken = authService.createAccessToken(mainUserId);
            String refreshToken = authService.createRefreshToken(mainUserId);

            authService.saveTokens(mainUserId, accessToken, refreshToken);

            response.put("accessToken", accessToken);
            response.put("refreshToken", refreshToken);
        }

        return ResponseEntity.ok(response);
    }


    // 사용자 정보 저장
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveMainUser(@RequestBody RequestMainUserSaveDTO requestMainUserSaveDTO) {
        UUID mainUserId = mainUserService.saveMainUser(requestMainUserSaveDTO);
        boolean success = mainUserId != null;

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("mainUserId", mainUserId);
        response.put("message", success ? "사용자 정보 저장 성공" : "사용자 정보 저장 실패");

        return ResponseEntity.ok(response);
    }
}
