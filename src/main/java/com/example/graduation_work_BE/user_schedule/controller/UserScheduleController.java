package com.example.graduation_work_BE.user_schedule.controller;

import com.example.graduation_work_BE.user_schedule.entity.DTO.ResponseUserScheduleGetDTO;
import com.example.graduation_work_BE.user_schedule.service.UserScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("user/schedule")
@CrossOrigin("*")
public class UserScheduleController {

    UserScheduleService userScheduleService;

    @Autowired
    public UserScheduleController(UserScheduleService userScheduleService){
        this.userScheduleService = userScheduleService;
    }

    // 특정 일정 조회
    @GetMapping("/{userScheduleId}")
    public ResponseEntity<Map<String, Object>> getUserSchedule(@PathVariable("userScheduleId")UUID userScheduleId){

        ResponseUserScheduleGetDTO responseUserScheduleGetDTO = userScheduleService.getUserSchedule(userScheduleId);

        boolean success = (responseUserScheduleGetDTO == null) ? false:true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "특정 일정 조회 성공" : "특정 일정 조회 실패");
        requestMap.put("userScheduleInfo", responseUserScheduleGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 전체 일정 조회
    @GetMapping("/all/{userId}")
    public ResponseEntity<Map<String, Object>> getUserSchedules(@PathVariable("userId")UUID userId){

        List<ResponseUserScheduleGetDTO> responseUserSchedulesGetDTO = userScheduleService.getUserSchedules(userId);

        boolean success = (responseUserSchedulesGetDTO == null) ? false:true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "전체 일정 조회 성공" : "전체 일정 조회 실패");
        requestMap.put("UserScheduleList", responseUserSchedulesGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 일정 저장



    // 일정 수정



    // 일정 삭제

}
