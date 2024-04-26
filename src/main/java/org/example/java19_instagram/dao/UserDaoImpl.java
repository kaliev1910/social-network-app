package org.example.java19_instagram.dao;

import org.example.java19_instagram.dao.interfaces.UserDao;
import org.example.java19_instagram.models.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql,  new BeanPropertyRowMapper<>(User.class), userId);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (username, email, password, avatar, name, enabled, bio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getAvatar(), user.getName(), user.isEnabled(), user.getBio());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET username = ?, email = ?, password = ?, avatar = ?, name = ?, enabled = ?, bio = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getAvatar(), user.getName(), user.isEnabled(), user.getBio(), user.getUserId());
    }

    @Override
    public void deleteById(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
