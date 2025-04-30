package com.example.graduation_work_BE.study_group.controller;

import com.example.graduation_work_BE.study_group.entity.DTO.*;
import com.example.graduation_work_BE.study_group.entity.StudyGroupDAO;
import com.example.graduation_work_BE.study_group.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/study/group")
@CrossOrigin("*")
public class StudyGroupController {

    StudyGroupService studyGroupService;

    @Autowired
    public StudyGroupController(StudyGroupService studyGroupService) {
        this.studyGroupService = studyGroupService;
    }

    // 특정 스터디그룹 조회
    @GetMapping("/{studyGroupId}")
    public ResponseEntity<Map<String, Object>> getStudyGroup(@PathVariable("studyGroupId") UUID studyGroupId) {

        ResponseStudyGroupGetDTO responseStudyGroupGetDTO = studyGroupService.getStudyGroup(studyGroupId);

        boolean success = (responseStudyGroupGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "특정 스터디 조회 성공" : "특정 스터디 조회 실패");
        requestMap.put("studyGroupInfo", responseStudyGroupGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 전체 스터디그룹 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getStudyGroups() {

        List<ResponseStudyGroupGetDTO> responseStudyGroupsGetDTO = studyGroupService.getStudyGroups();

        boolean success = (responseStudyGroupsGetDTO == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "전체 스터디 조회 성공" : "전체 스터디 조회 실패");
        requestMap.put("studyGroupList", responseStudyGroupsGetDTO);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 미싱 스킬에 따른 스터디그룹 조회
    @PostMapping("missing/skills")
    public ResponseEntity<Map<String, Object>> getStudyGroupsByMissingSkills(@RequestBody RequestRecommendStudyGroupGetDTO requestRecommendStudyGroupGetDTO) {

        List<ResponseRecommendStudyGroupGetDTO> responseRecommendStudyGroupGetDTOS = studyGroupService.getRecommendStudyGroupBySkills(requestRecommendStudyGroupGetDTO.getMissingSkills());

        boolean success = (responseRecommendStudyGroupGetDTOS.isEmpty()) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "추천 스터디 조회 성공" : "추천 스터디 조회 실패");
        requestMap.put("studyGroupList", responseRecommendStudyGroupGetDTOS);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 스터디그룹 생성
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
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateStudyGroup(@RequestBody RequestStudyGroupUpdateDTO requestStudyGroupUpdateDTO) {

        UUID studyGroupId = studyGroupService.updateStudyGroup(requestStudyGroupUpdateDTO);

        boolean success = (studyGroupId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "스터디 수정 성공" : "스터디 수정 실패");
        requestMap.put("studyGroupId", studyGroupId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }



    // 스터디그룹 삭제
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteStudyGroup(@RequestBody RequestStudyGroupDeleteDTO requestStudyGroupDeleteDTO){

        UUID studyGroupId = studyGroupService.deleteStudyGroup(requestStudyGroupDeleteDTO);

        boolean success = (studyGroupId == null) ? false : true;

        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "스터디 삭제 성공" : "스터디 삭제 실패");
        requestMap.put("studyGroupId", studyGroupId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
