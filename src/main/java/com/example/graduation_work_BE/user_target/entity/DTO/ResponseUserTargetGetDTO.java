package com.example.graduation_work_BE.user_target.entity.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserTargetGetDTO {
    String targetContent;

    Boolean isFinish;

}
