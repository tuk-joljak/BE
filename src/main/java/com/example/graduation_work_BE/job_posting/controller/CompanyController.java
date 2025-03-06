package com.example.graduation_work_BE.job_posting.controller;

import com.example.graduation_work_BE.job_posting.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    /**
     * ✅ 회사명으로 companyId 조회 API
     */
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> getCompanyId(@RequestParam String name) {
        UUID companyId = companyService.getCompanyId(name);
        boolean success = companyId != null;

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("companyId", companyId);
        response.put("message", success ? "회사 조회 성공" : "회사 정보 없음");

        return ResponseEntity.ok(response);
    }

    /**
     * ✅ 새로운 회사 생성 API
     */
    @PostMapping
    public ResponseEntity<Map<String, Object>> createCompany(@RequestBody Map<String, String> request) {
        String companyName = request.get("companyName");
        String companyDescription = request.getOrDefault("companyDescription", "기본 회사 설명");

        UUID companyId = companyService.saveCompany(companyName, companyDescription);
        boolean success = companyId != null;

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("companyId", companyId);
        response.put("message", success ? "회사 저장 성공" : "회사 저장 실패");

        return ResponseEntity.ok(response);
    }
}
