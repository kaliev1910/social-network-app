package org.example.java19_instagram.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.java19_instagram.dao.PostImageDao;
import org.example.java19_instagram.dto.PostImageDto;
import org.example.java19_instagram.models.PostImage;
import org.example.java19_instagram.service.interfaces.FileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostImageService {
    private static final String SUB_DIR = "images";
    private final FileService fileService;
    private final PostImageDao postImageDao;

    public void uploadImage(PostImageDto postImageDto) {
        postImageDao.delete(postImageDto.getPostId());
        String fileName = fileService.saveUploadedFile(postImageDto.getFile(), SUB_DIR);
        PostImage ui = PostImage.builder()
                .postId(postImageDto.getPostId())
                .fileName(fileName)
                .build();
        postImageDao.save(ui);
    }



    public ResponseEntity<?> downloadImage(long imageId) {
        String fileName;
        try {
            PostImage ui = postImageDao.getImageById(imageId);
            fileName = ui.getFileName();
        } catch (NullPointerException e) {
            throw new NoSuchElementException("Image not found");
        }
        return fileService.getOutputFile(fileName, SUB_DIR, MediaType.IMAGE_JPEG);
    }

    public ResponseEntity<?> getImageByUserId(Long userId) {
        var optionalUserImage = postImageDao.findImageByUserId(userId);
        if (optionalUserImage.isEmpty()) {
            return fileService.getOutputFile("no_image.jpeg", SUB_DIR, MediaType.IMAGE_JPEG);
        }
        return fileService.getOutputFile(optionalUserImage.get().getFileName(), SUB_DIR, MediaType.IMAGE_JPEG);
    }
}
