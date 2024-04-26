package org.example.java19_instagram.service.interfaces;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface FileService {
    public ResponseEntity<?> getOutputFile(String fileName, String subDir, MediaType mediaType);
    public String saveUploadedFile(MultipartFile file, String subDir);
}
