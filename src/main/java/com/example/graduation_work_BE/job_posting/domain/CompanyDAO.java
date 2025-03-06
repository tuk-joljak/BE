package com.example.graduation_work_BE.job_posting.domain;

import jakarta.persistence.*;
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

    @Column(unique = true)
    String companyName;

    String companyDescription;

    @Enumerated(EnumType.STRING)
    CompanyCategory companyCategory;

    LocalDateTime createAt;
    LocalDateTime updateAt;

    @PrePersist
    public void prePersist(){
        if (this.companyId == null){
            this.companyId = UUID.randomUUID();
        }
    }
}
