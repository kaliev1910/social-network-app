package org.example.java19_instagram.dao;

import org.example.java19_instagram.dao.interfaces.SubscriptionDao;
import org.example.java19_instagram.models.Subscription;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubscriptionDaoImpl implements SubscriptionDao {
    private final JdbcTemplate jdbcTemplate;

    public SubscriptionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Subscription findById(int subscriptionId) {
        String sql = "SELECT * FROM subscriptions WHERE subscription_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Subscription.class));
    }

    @Override
    public List<Subscription> getUserSubscriptions() {
        String sql = "SELECT * FROM subscriptions";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Subscription.class));
    }


    @Override
    public void subscribe(Subscription subscription) {
        String sql = "INSERT INTO subscriptions (user_id, follower_id, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, subscription.getUserId(), subscription.getFollowerId(), subscription.getCreatedAt());
    }

//    @Override
//    public void edit(Subscription subscription) {
//        String sql = "UPDATE subscriptions SET user_id = ?, follower_id = ?, created_at = ? WHERE subscription_id = ?";
//        jdbcTemplate.update(sql, subscription.getUserId(), subscription.getFollowerId(), subscription.getCreatedAt(), subscription.getSubscriptionId());
//    }

    @Override
    public void deleteById(int subscriptionId) {
        String sql = "DELETE FROM subscriptions WHERE subscription_id = ?";
        jdbcTemplate.update(sql, subscriptionId);
    }
}