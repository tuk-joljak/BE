package com.example.graduation_work_BE.job_posting.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyDAO {
    @Id
    UUID companyId;

    String companyName;
    String companyDescription;

    CompanyCategory companyCategory;

    LocalDateTime createAt;
    LocalDateTime updateAt;
}
