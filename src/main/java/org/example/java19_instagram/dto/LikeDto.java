package org.example.java19_instagram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class LikeDto {
    private int likeId;
    private int userId;
    private int postId;
    private Timestamp createdAt;

    // Геттеры и сеттеры
}

