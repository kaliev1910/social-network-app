package org.example.java19_instagram.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String name;
    private boolean enabled;
    private String bio;

}
