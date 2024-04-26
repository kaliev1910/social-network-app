package org.example.java19_instagram.dao;

import org.example.java19_instagram.dao.interfaces.SubscriptionDao;
import org.example.java19_instagram.models.Subscription;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@Component
public class SubscriptionDaoImpl implements SubscriptionDao {
    private JdbcTemplate jdbcTemplate;

    public SubscriptionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Subscription findById(int subscriptionId) {
        String sql = "SELECT * FROM subscriptions WHERE subscription_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{subscriptionId}, new BeanPropertyRowMapper<>(Subscription.class));
    }

    @Override
    public List<Subscription> findAll() {
        String sql = "SELECT * FROM subscriptions";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Subscription.class));
    }


    @Override
    public void save(Subscription subscription) {
        String sql = "INSERT INTO subscriptions (follower_id, followed_id, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, subscription.getFollowerId(), subscription.getFollowedId(), subscription.getCreatedAt());
    }

    @Override
    public void update(Subscription subscription) {
        String sql = "UPDATE subscriptions SET follower_id = ?, followed_id = ?, created_at = ? WHERE subscription_id = ?";
        jdbcTemplate.update(sql, subscription.getFollowerId(), subscription.getFollowedId(), subscription.getCreatedAt(), subscription.getSubscriptionId());
    }

    @Override
    public void deleteById(int subscriptionId) {
        String sql = "DELETE FROM subscriptions WHERE subscription_id = ?";
        jdbcTemplate.update(sql, subscriptionId);
    }
}