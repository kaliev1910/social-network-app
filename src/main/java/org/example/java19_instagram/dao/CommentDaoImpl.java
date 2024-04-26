package org.example.java19_instagram.dao;

import org.example.java19_instagram.dao.interfaces.CommentDao;
import org.example.java19_instagram.models.Comment;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@Component
public class CommentDaoImpl implements CommentDao {
    private final JdbcTemplate jdbcTemplate;

    public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment findById(int commentId) {
        String sql = "SELECT * FROM comments WHERE comment_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{commentId}, new BeanPropertyRowMapper<>(Comment.class));
    }

    @Override
    public List<Comment> findAll() {
        String sql = "SELECT * FROM comments";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class));
    }

    @Override
    public void save(Comment comment) {
        String sql = "INSERT INTO comments (post_id, user_id, content, created_at) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, comment.getPostId(), comment.getUserId(), comment.getContent(), comment.getCreatedAt());
    }

    @Override
    public void update(Comment comment) {
        String sql = "UPDATE comments SET post_id = ?, user_id = ?, content = ?, created_at = ? WHERE comment_id = ?";
        jdbcTemplate.update(sql, comment.getPostId(), comment.getUserId(), comment.getContent(), comment.getCreatedAt(), comment.getCommentId());
    }

    @Override
    public void deleteById(int commentId) {
        String sql = "DELETE FROM comments WHERE comment_id = ?";
        jdbcTemplate.update(sql, commentId);
    }

    @Override
    public List<Comment> findByPostId(long postId) {
        return List.of();
    }
}