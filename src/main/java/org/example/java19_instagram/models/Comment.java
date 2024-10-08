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
public class Comment {
    private int commentId;
    private int postId;
    private int userId;
    private String content;
    private Timestamp createdAt;


}