package org.example.java19_instagram.service.impl;

import lombok.AllArgsConstructor;
import org.example.java19_instagram.dao.interfaces.SubscriptionDao;
import org.example.java19_instagram.models.Subscription;
import org.example.java19_instagram.service.interfaces.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionDao subscriptionDao;

    @Override
    public void subscribe(String username) {
    }

    @Override
    public void unsubscribe(String username) {

    }



    @Override
    public List<Subscription> getSubscriptionsByUsername(String username) {
        return List.of();
    }

    @Override
    public List<Subscription> getSubscriptionsByUsername(String username, int limit) {
        return List.of();
    }

    @Override
    public List<Subscription> getSubscriptionsByUsername(String username, int limit, int offset) {
        return List.of();
    }
}
