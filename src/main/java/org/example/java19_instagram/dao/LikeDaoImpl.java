package org.example.java19_instagram.dao;

import org.example.java19_instagram.dao.interfaces.LikeDao;
import org.example.java19_instagram.models.Like;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LikeDaoImpl implements LikeDao {

    private final JdbcTemplate jdbcTemplate;

    public LikeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Like like) {
        String sql = "INSERT INTO likes (user_id, post_id, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, like.getUserId(), like.getPostId(), like.getCreatedAt());
    }

    @Override
    public List<Like> getLikes() {
        String sql = "SELECT * FROM likes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class));
    }

    @Override
    public Like getLike(int id) {
        String sql = "SELECT * FROM likes WHERE like_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Like.class), id);
    }

    @Override
    public void deleteLike(int id) {
        String sql = "DELETE FROM likes WHERE like_id = ?";
        jdbcTemplate.update(sql, id);
    }
}