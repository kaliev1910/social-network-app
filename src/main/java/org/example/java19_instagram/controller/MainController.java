package org.example.java19_instagram.controller;

import lombok.RequiredArgsConstructor;
import org.example.java19_instagram.dto.PostImageDto;
import org.example.java19_instagram.service.impl.PostImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final PostImageService postImageService;

    @PostMapping("/upload")
    public String uploadImage(PostImageDto postImageDto) {
        postImageService.uploadImage(postImageDto);
        return "redirect:profile";
    }
}
