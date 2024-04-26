package org.example.java19_instagram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SubscriptionDto {
    private int subscriptionId;
    private int followerId;
    private int followedId;
    private Timestamp createdAt;

}
