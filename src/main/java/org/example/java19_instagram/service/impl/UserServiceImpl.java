package org.example.java19_instagram.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.java19_instagram.dao.interfaces.UserDao;
import org.example.java19_instagram.dto.UserDto;
import org.example.java19_instagram.models.User;
import org.example.java19_instagram.service.interfaces.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private final PasswordEncoder encoder;

    @Override
    public int signUp(UserDto userDto) {
        try {

            Optional<User> existingUser = userDao.findByUsername(userDto.getUsername());

            if (existingUser.isPresent()) {

                log.warn("User with username {} already exists", userDto.getUsername());

                // throw new UsernameAlreadyExistsException("User with username already exists");
                return 0;
            } else {
                // Пользователь с таким username не существует, можно регистрировать
                User user = fromDto(userDto);
                user.setPassword(encoder.encode(userDto.getPassword()));
                int newUserId = userDao.createUser(user);
                log.info("User with email {} has been created", userDto.getEmail());
                return newUserId;
            }
        } catch (Exception e) {
            log.error("Error while trying to create user", e);

            throw e;
        }
    }


    @Override
    public Optional<UserDto> getUserByUsername(String username) {
        try {
            var user = userDao.findByUsername(username);
            log.info("Retrieved user by username: {}", username);
            return user.map(this::toDto);
        } catch (Exception e) {
            log.error("Error while trying to find user by username: {}", username, e);
            throw e;
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        try {
            var users = userDao.getAllUsers();
            log.info("Retrieved {} users", users.size());
            return users.stream().map(this::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error while trying to get users", e);
            throw e;
        }
    }

    @Override
    public UserDto getUserById(int id) {
        try {
            Optional<User> user = Optional.ofNullable(userDao.findById(id));
            if (user.isPresent()) {
                log.info("Retrieved user by id: {}", id);
                return toDto(user.get());
            } else {
                log.warn("User with id {} not found", id);
                return null;
            }
        } catch (Exception e) {
            log.error("Error while trying to get user by id: {}", id, e);
            throw e;
        }
    }

    @Override
    public Optional<List<UserDto>> findUserLike(String username) {
        try {
            Optional<List<User>> users = userDao.findUserLike(username);
            if (users.isPresent()) {
                log.info("Retrieved users like username: {}", username);
                return users.map(userList -> userList.stream().map(this::toDto).collect(Collectors.toList()));
            } else {
                log.info("No users found like username: {}", username);
                return Optional.empty();
            }
        } catch (Exception e) {
            log.error("Error while trying to find users like username: {}", username, e);
            throw e;
        }
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

    public  User fromDto(UserDto userDto) {
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