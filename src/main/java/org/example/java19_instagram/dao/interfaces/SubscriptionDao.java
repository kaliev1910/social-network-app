package org.example.java19_instagram.dao.interfaces;

import org.example.java19_instagram.models.Subscription;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SubscriptionDao {
    public Subscription findById(int subscriptionId);
    public List<Subscription> getUserSubscriptions();
    public void subscribe(Subscription subscription);
//    public void edit(Subscription subscription);
    public void deleteById(int subscriptionId);



}
