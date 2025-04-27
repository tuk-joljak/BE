package com.example.graduation_work_BE.study_group.controller;

import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyParticipantDeleteDTO;
import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyParticipantSaveDTO;
import com.example.graduation_work_BE.study_group.entity.DTO.ResponseStudyParticipantGetDTO;
import com.example.graduation_work_BE.study_group.entity.StudyParticipantDAO;
import com.example.graduation_work_BE.study_group.service.StudyParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/study/participant")
@CrossOrigin("*")
public class StudyParticipantController {

    StudyParticipantService studyParticipantService;

    @Autowired
    public StudyParticipantController(StudyParticipantService studyParticipantService) {
        this.studyParticipantService = studyParticipantService;
    }

    // 스터디그룹 참여자 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getStudyParticipant() {

        List<ResponseStudyParticipantGetDTO> responseStudyParticipantGetDTO = studyParticipantService.getStudyParticipant();

        boolean success = (responseStudyParticipantGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "스터디그룹원 조회 성공" : "스터디그룹원 조회 실패");
        requestMap.put("studyParticipantList", responseStudyParticipantGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 스터디그룹 참여자 생성
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveStudyParticipant(@RequestBody RequestStudyParticipantSaveDTO requestStudyParticipantSaveDTO) {

        UUID studyParticipantId = studyParticipantService.saveStudyParticipant(requestStudyParticipantSaveDTO);

        boolean success = (studyParticipantId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "스터디그룹원 추가 성공" : "스터디그룹원 추가 실패");
        requestMap.put("studyParticipantId", studyParticipantId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 스터디그룹 참여자 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteStudyParticipant(@RequestBody RequestStudyParticipantDeleteDTO requestStudyParticipantDeleteDTO){

        UUID userId = studyParticipantService.deleteStudyParticipant(requestStudyParticipantDeleteDTO);

        boolean success = (userId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "스터디그룹원 삭제 성공" : "스터디그룹원 삭제 실패");
        requestMap.put("userId", userId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }
}
