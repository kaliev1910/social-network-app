package org.example.java19_instagram.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostImageDto {
    private MultipartFile file;
    private long postId;
}
