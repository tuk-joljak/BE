package com.example.graduation_work_BE.job_posting.service;

import com.example.graduation_work_BE.job_posting.domain.CompanyCategory;
import com.example.graduation_work_BE.job_posting.domain.CompanyDAO;
import com.example.graduation_work_BE.job_posting.repository.CompanyRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepositoryJPA companyRepositoryJPA;

    /**
     * ✅ 회사명으로 companyId 조회
     * @param companyName 회사명
     * @return companyId (없으면 null 반환)
     */
    @Transactional(readOnly = true)
    public UUID getCompanyId(String companyName) {
        Optional<CompanyDAO> company = companyRepositoryJPA.findByCompanyName(companyName);
        return company.map(CompanyDAO::getCompanyId).orElse(null);
    }

    /**
     * ✅ 새로운 회사 정보 저장
     * @param companyName 회사명
     * @param companyDescription 회사 설명 (기본값 사용 가능)
     * @return 새로 생성된 companyId
     */
    @Transactional
    public UUID saveCompany(String companyName, String companyDescription) {
        CompanyDAO company = CompanyDAO.builder()
                .companyId(UUID.randomUUID())
                .companyName(companyName)
                .companyDescription(companyDescription)
                .companyCategory(CompanyCategory.SENIOR)  // ✅ 기본 카테고리 (필요시 변경)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
        company = companyRepositoryJPA.save(company);
        return company.getCompanyId();
    }

    /**
     * ✅ 회사 정보 조회 후, 없으면 자동 저장
     * @param companyName 회사명
     * @return companyId (기존 ID 또는 새로 생성된 ID)
     */
    @Transactional
    public UUID getOrCreateCompany(String companyName) {
        UUID companyId = getCompanyId(companyName);
        if (companyId != null) {
            return companyId;  // ✅ 기존 회사 ID 반환
        }
        return saveCompany(companyName, "기본 회사 설명");
    }

    public UUID getOrCreateCompanyId(String companyName) {
        return companyRepositoryJPA.findByCompanyName(companyName)
                .map(CompanyDAO::getCompanyId)
                .orElseGet(() -> {
                    CompanyDAO newCompany = new CompanyDAO();
                    newCompany.setCompanyName(companyName);
                    newCompany.setCompanyId(UUID.randomUUID()); // 새 UUID 생성
                    companyRepositoryJPA.save(newCompany);
                    return newCompany.getCompanyId();
                });
    }
}
