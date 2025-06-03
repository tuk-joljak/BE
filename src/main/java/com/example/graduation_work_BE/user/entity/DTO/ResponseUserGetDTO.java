package com.example.graduation_work_BE.user.entity.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseUserGetDTO {
    UUID userId;
    String userName;
}
