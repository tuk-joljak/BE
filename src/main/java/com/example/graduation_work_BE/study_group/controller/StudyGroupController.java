package com.example.graduation_work_BE.study_group.controller;

import com.example.graduation_work_BE.study_group.entity.DTO.RequestStudyGroupSaveDTO;
import com.example.graduation_work_BE.study_group.service.StudyGroupService;
import com.example.graduation_work_BE.user_schedule.entity.DTO.RequestUserScheduleSaveDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("study/group")
@CrossOrigin("*")
public class StudyGroupController {

    StudyGroupService studyGroupService;

    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }
    // 스터디그룹 전체조회




    // 스터디그룹 상세조회



    // 스터디그룹 생성
    // 사용자가 스터디그룹 생성 -> 정보 입력해서 프론트 request를 보내겠지 -> controller로 받고 service로 보내주겠지
    // -> bean(small)로 가서 생성할 내용 db에 저장해줘
    @PostMapping
    public ResponseEntity<Map<String, Object>> saveStudyGroup(@RequestBody RequestStudyGroupSaveDTO requestStudyGroupSaveDTO) {

        UUID studyGroupId = studyGroupService.saveStudyGroup(requestStudyGroupSaveDTO);

        boolean success = (studyGroupId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "스터디 생성 성공" : "스터디 생성 실패");
        requestMap.put("studyGroupId", studyGroupId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 스터디그룹 수정




    // 스터디그룹 삭제

}
