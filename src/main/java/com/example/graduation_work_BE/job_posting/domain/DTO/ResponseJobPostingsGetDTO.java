package com.example.graduation_work_BE.job_posting.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseJobPostingsGetDTO {
    UUID jobPostingId;

    String title;
    String career;
    String deadline;
    String companyName;
    String location;
}
