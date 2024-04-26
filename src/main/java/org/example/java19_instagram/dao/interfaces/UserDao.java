package org.example.java19_instagram.dao.interfaces;

import org.example.java19_instagram.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserDao {
    User findById(int userId);
    List<User> getAllUsers();
    int save(User user);

    Optional<List<User>> findUserLike(String username);

    void update(User user);
    void deleteById(int userId);

    Optional<User> findByEmail(String email);
}
