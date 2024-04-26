package org.example.java19_instagram.service.interfaces;

import org.example.java19_instagram.dto.CommentDto;
import org.example.java19_instagram.models.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CommentService {
    public int addComment(CommentDto comment);

    public List<Comment> getComments();

    public int deleteComment(int id);

    public int updateComment(CommentDto comment);


}
