package org.example.java19_instagram.dao.interfaces;

import org.example.java19_instagram.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserDao {
    User findById(int userId);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void deleteById(int userId);
}
