package org.example.java19_instagram.api;


import lombok.RequiredArgsConstructor;
import org.example.java19_instagram.service.impl.PostImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class PostImageController {
    private final PostImageService userImageService;

    @GetMapping("/download/{imageId}")
    public ResponseEntity<?> downloadImage(@PathVariable long imageId) {
        return userImageService.downloadImage(imageId);
    }


    @GetMapping("/{postId}")
    public ResponseEntity<?> getImageByPostId(@PathVariable Long postId) {
        return userImageService.getImageByPostId(postId);
    }
}
