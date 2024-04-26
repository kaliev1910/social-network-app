package org.example.java19_instagram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PostDto {
    private int postId;
    private int userId;
    private MultipartFile file;
    private String description;
    private int likesCount;
    private Timestamp createdAt;

}