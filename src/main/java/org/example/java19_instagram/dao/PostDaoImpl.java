package org.example.java19_instagram.dao;

import org.example.java19_instagram.dao.interfaces.PostDao;
import org.example.java19_instagram.models.Post;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
@Component
public class PostDaoImpl implements PostDao {
    private JdbcTemplate jdbcTemplate;

    public PostDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Post findById(int postId) {
        String sql = "SELECT * FROM posts WHERE post_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{postId}, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> findAll() {
        String sql = "SELECT * FROM posts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public void save(Post post) {
        String sql = "INSERT INTO posts (user_id, file_name, description, likes_count, created_at) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, post.getUserId(), post.getFileName(), post.getDescription(), post.getLikesCount(), post.getCreatedAt());
    }

    @Override
    public void update(Post post) {
        String sql = "UPDATE posts SET user_id = ?, file_name = ?, description = ?, likes_count = ?, created_at = ? WHERE post_id = ?";
        jdbcTemplate.update(sql, post.getUserId(), post.getFileName(), post.getDescription(), post.getLikesCount(), post.getCreatedAt(), post.getPostId());
    }

    @Override
    public void deleteById(int postId) {
        String sql = "DELETE FROM posts WHERE post_id = ?";
        jdbcTemplate.update(sql, postId);
    }
}