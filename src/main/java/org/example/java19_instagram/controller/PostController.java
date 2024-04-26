package org.example.java19_instagram.controller;

import lombok.AllArgsConstructor;
import org.example.java19_instagram.dto.PostImageDto;
import org.example.java19_instagram.service.impl.PostImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor

public class PostController {

    private final PostImageService postImageService;

    @PostMapping("/image/upload")
    public String uploadImage(PostImageDto postImageDto) {
        postImageService.uploadImage(postImageDto);
        return "redirect:/";
    }
}
