package com.example.graduation_work_BE.user_post.entity;

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
public class UserPostDAO {
    @Id
    UUID userPostId;

    UUID userId;

    String postTitle;
    String postContent;

    Boolean isFinish;

    LocalDateTime createAt;
    LocalDateTime uploadAt;
}
