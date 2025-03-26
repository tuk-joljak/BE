package com.example.graduation_work_BE.posting.entity;

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
public class PostingDAO {
    @Id
    UUID postingId;

    UUID userId;

    String imageUrl;
    String title;
    String content;

    LocalDateTime createAt;
    LocalDateTime uploadAt;
}
