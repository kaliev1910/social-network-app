package org.example.java19_instagram.service.impl;

import org.example.java19_instagram.dto.CommentDto;
import org.example.java19_instagram.models.Comment;
import org.example.java19_instagram.service.interfaces.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl  implements CommentService {
    @Override
    public int addComment(CommentDto comment) {
        return 0;
    }

    @Override
    public List<Comment> getComments() {
        return List.of();
    }

    @Override
    public int deleteComment(int id) {
        return 0;
    }

    @Override
    public int updateComment(CommentDto comment) {
        return 0;
    }
}
