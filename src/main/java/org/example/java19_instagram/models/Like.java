package org.example.java19_instagram.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Like {
    private int likeId;
    private int userId;
    private int postId;
    private Timestamp createdAt;

}

