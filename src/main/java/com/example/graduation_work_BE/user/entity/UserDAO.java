package com.example.graduation_work_BE.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDAO {
    @Id
    UUID userId;

    String oauthId;
    String userName;
    String userImage;

    String accessToken;
}
