package org.example.java19_instagram.service.impl;

import org.example.java19_instagram.dao.interfaces.CommentDao;
import org.example.java19_instagram.dto.CommentDto;
import org.example.java19_instagram.models.Comment;
import org.example.java19_instagram.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public int addComment(CommentDto commentDto) {
        //TODO
        Comment comment = fromDto(commentDto);
        commentDao.save(comment);
        return comment.getCommentId();
    }

    @Override
    public List<CommentDto> getComments(long postId) {
        List<Comment> comments = commentDao.findByPostId(postId);
        return comments.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDto> getUserComments(String username) {
        return List.of();
    }

    @Override
    public int deleteComment(int id) {
        commentDao.deleteById(id);
        return id;
    }

    @Override
    public int updateComment(CommentDto commentDto) {
        Comment comment = fromDto(commentDto);
        comment.setCommentId(commentDto.getCommentId());
        commentDao.update(comment);
        return comment.getCommentId();
    }

    public CommentDto toDto(Comment comment) {
        return CommentDto.builder()
                .commentId(comment.getCommentId())
                .postId(comment.getPostId())
                .userId(comment.getUserId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    public static Comment fromDto(CommentDto commentDto) {
        return Comment.builder()
                .commentId(commentDto.getCommentId())
                .postId(commentDto.getPostId())
                .userId(commentDto.getUserId())
                .content(commentDto.getContent())
                .createdAt(commentDto.getCreatedAt())
                .build();
    }
}
