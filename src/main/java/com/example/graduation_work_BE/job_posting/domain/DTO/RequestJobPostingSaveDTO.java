package com.example.graduation_work_BE.job_posting.domain.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
public class RequestJobPostingSaveDTO {
    private UUID companyId;
    private String companyName;
    private String title;
    private String description;
    private String deadline;
    private String location;
    private String career;
    private String task;
    private String qualification;
    private String preference;
    private String stack;
    private String hiringProcess;
    private String imageUrl;
}
