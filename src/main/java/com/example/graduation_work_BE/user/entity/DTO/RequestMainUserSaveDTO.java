package com.example.graduation_work_BE.user.entity.DTO;


import lombok.Data;

@Data
public class RequestMainUserSaveDTO {
    private String mainUserName;
    private String loginId;
    private String password;
}
