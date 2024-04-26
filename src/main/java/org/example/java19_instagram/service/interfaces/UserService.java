package org.example.java19_instagram.service.interfaces;

import org.example.java19_instagram.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    int signUp(UserDto user);

    Optional<UserDto> getUserByUsername(String username);

    UserDto getUserById(int id);

    List<UserDto> getAllUsers();

    Optional<List<UserDto>> findUserLike(String username);

}
