package org.example.java19_instagram.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Subscription {
    private int subscriptionId;
    private int followerId;
    private int followedId;
    private Timestamp createdAt;

}
