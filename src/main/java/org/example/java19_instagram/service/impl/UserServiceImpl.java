package org.example.java19_instagram.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.java19_instagram.dao.interfaces.UserDao;
import org.example.java19_instagram.dto.UserDto;
import org.example.java19_instagram.exeptions.UserNotFoundException;
import org.example.java19_instagram.models.User;
import org.example.java19_instagram.service.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private final PasswordEncoder encoder;

    @Override
    public int signUp(UserDto user) {
        User u = new User();

        try {
            u = fromDto(user);
            u.setPassword(encoder.encode(user.getPassword()));


        } catch (Exception e) {
            log.error("Error while trying to create user", e);
            throw e;
        }

        return 0;
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return null;
    }

    @Override
    public UserDto getUserById(int id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public Optional<List<UserDto>> findUserLike(String username) {
        return Optional.empty();
    }

    public UserDto toDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .name(user.getName())
                .bio(user.getBio())
                .build();
    }

    public static User fromDto(UserDto userDto) {
        return User.builder()
                .userId(userDto.getUserId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .enabled(true)
                .bio(userDto.getBio())
                .build();
    }
}
