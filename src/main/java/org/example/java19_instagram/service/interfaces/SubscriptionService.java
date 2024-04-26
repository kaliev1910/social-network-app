package org.example.java19_instagram.service.interfaces;

import org.example.java19_instagram.models.Subscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionService {
    void subscribe(String username);

    void unsubscribe(String username);

    List<Subscription> getSubscriptionsByUsername(String username);

    List<Subscription> getSubscriptionsByUsername(String username, int limit);

    List<Subscription> getSubscriptionsByUsername(String username, int limit, int offset);

}
