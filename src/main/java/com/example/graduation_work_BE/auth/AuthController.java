package com.example.graduation_work_BE.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/main/auth")
public class AuthController {
    AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 고유 UUID 생성
    @PostMapping("/init")
    public ResponseEntity<Map<String, Object>> init(HttpServletResponse response) {
        String uuid = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("UUID", uuid);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        boolean success = cookie != null;

        Map<String, Object> apiResponse = new HashMap<>();
        apiResponse.put("success", success);
        apiResponse.put("cookie", cookie);
        apiResponse.put("message", success ? "고유 UUID 생성 성공" : "고유 UUID 생성 실패");

        return ResponseEntity.ok(apiResponse);
    }

    // Token 생성
    @PostMapping("/token")
    public ResponseEntity<Map<String, Object>> getToken(HttpServletRequest request, HttpServletResponse response) {
        String userId = authService.getCookieValue(request, "UUID");

        // 토큰 생성
        String token = authService.createAccessToken(userId);

        // HTTP 응답 헤더에 토큰 추가
        Cookie cookie = new Cookie("X-CSRF-Token", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60);
        response.addCookie(cookie);

        boolean success = token != null;

        Map<String, Object> apiResponse = new HashMap<>();
        apiResponse.put("success", success);
        apiResponse.put("cookie", cookie);
        apiResponse.put("message", success ? "token 생성 성공" : "token 생성 실패");

        return ResponseEntity.ok(apiResponse);
    }
}