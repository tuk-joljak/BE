package com.example.graduation_work_BE.comment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class CommentDAO {
    @Id
    UUID commentId;

    UUID targetId;
    UUID userId;
    String content;

    Boolean isDeleted;

    LocalDateTime createAt;
    LocalDateTime updateAt;

    @Enumerated(EnumType.STRING)
    Type type;
}
