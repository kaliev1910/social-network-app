package org.example.java19_instagram.dao;

import org.example.java19_instagram.dao.interfaces.UserDao;
import org.example.java19_instagram.models.User;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

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
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int save(User user) {
        String sql = "INSERT INTO users (username, email, password, avatar, name, enabled, bio) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Use KeyHolder to capture the generated key (usually user_id)
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getAvatar());
            ps.setString(5, user.getName());
            ps.setBoolean(6, user.isEnabled());
            ps.setString(7, user.getBio());
            return ps;
        }, keyHolder);

        return (int) keyHolder.getKey().intValue();
    }

    @Override
    public Optional<List<User>> findUserLike(String username){
        String sql = "SELECT * FROM users WHERE username LIKE ?";
      return   Optional.of(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username));
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

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = """
                select * from users where email = ?;
                """;
        return Optional.ofNullable(DataAccessUtils.singleResult(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)));
    }
}
