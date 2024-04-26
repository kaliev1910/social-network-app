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

    private int id;
    private String name;
    private String surname;
    private byte age;
    private String email;
    private String password;
    private String avatar;
    private String accountType;
    private boolean enabled;

}
