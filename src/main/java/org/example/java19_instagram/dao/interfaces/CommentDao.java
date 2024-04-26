package org.example.java19_instagram.dao.interfaces;

import org.example.java19_instagram.models.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CommentDao {
    Comment findById(int commentId);
    List<Comment> findAll();
    void save(Comment comment);
    void update(Comment comment);
    void deleteById(int commentId);

    List<Comment> findByPostId(long postId);
}
