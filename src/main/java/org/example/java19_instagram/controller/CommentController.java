package org.example.java19_instagram.controller;

import lombok.RequiredArgsConstructor;
import org.example.java19_instagram.dto.CommentDto;
import org.example.java19_instagram.service.interfaces.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping()
    int addComment(@RequestBody CommentDto comment) {

        return commentService.addComment(comment);
    }
}
