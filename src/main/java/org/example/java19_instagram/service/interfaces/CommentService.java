package org.example.java19_instagram.service.interfaces;

import org.example.java19_instagram.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CommentService {
    int addComment(CommentDto comment);

    List<CommentDto> getComments(long postId);
    List<CommentDto> getUserComments(String username);

    int deleteComment(int id);

    int updateComment(CommentDto comment);



}
