package org.example.java19_instagram.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public ResponseEntity<?> getOutputFile(String fileName, String subDir, MediaType mediaType);
    public String saveUploadedFile(MultipartFile file, String subDir);
}
