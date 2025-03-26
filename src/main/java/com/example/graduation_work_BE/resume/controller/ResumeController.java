package com.example.graduation_work_BE.resume.controller;

import com.example.graduation_work_BE.resume.entity.DTO.RequestResumeSaveDTO;
import com.example.graduation_work_BE.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/resume")
@CrossOrigin("*")
public class ResumeController {

    ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createResume(@RequestBody RequestResumeSaveDTO requestResumeSaveDTO) {

        UUID resumeId = resumeService.createResume(requestResumeSaveDTO);
        boolean success = resumeId != null;

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("resumeId", resumeId);
        response.put("message", success ? "이력서 저장 성공" : "이력서 저장 실패");

        return ResponseEntity.ok(response);
    }
}
