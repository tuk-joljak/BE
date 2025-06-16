package com.example.graduation_work_BE.user_target.controller;

import com.example.graduation_work_BE.user_schedule.entity.DTO.ResponseUserScheduleGetDTO;
import com.example.graduation_work_BE.user_target.entity.DTO.ResponseUserTargetGetDTO;
import com.example.graduation_work_BE.user_target.service.UserTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("user/target")
@CrossOrigin("*")
public class UserTargetController {

    UserTargetService userTargetService;

    @Autowired
    public UserTargetController(UserTargetService userTargetService) {
        this.userTargetService = userTargetService;
    }
    // 특정 목표 조회
    @GetMapping("/{userTargetId}")
    public ResponseEntity<Map<String, Object>> getUserTarget(@PathVariable("userTargetId") UUID userTargetId) {

        ResponseUserTargetGetDTO responseUserTargetGetDTO = userTargetService.getUserTarget(userTargetId);

        boolean success = (responseUserTargetGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "특정 목표 조회 성공" : "특정 목표 조회 실패");
        requestMap.put("userTargetInfo", responseUserTargetGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
    // 전체 목표 조회
    @GetMapping("/all/{userId}")
    public ResponseEntity<Map<String, Object>> getUserTargets(@PathVariable("userId") UUID userId) {

        List<ResponseUserTargetGetDTO> responseUserTargetsGetDTO = userTargetService.getUserTargets(userId);

        boolean success = (responseUserTargetsGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "전체 목표 조회 성공" : "전체 목표 조회 실패");
        requestMap.put("userTargetList", responseUserTargetsGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 목표 저장

    // 목표 수정

    // 목표 삭제

}
