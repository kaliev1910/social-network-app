package org.example.java19_instagram.dao.interfaces;

import org.example.java19_instagram.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface PostDao {
    public Post findById(int postId);
    public List<Post> findAll();
    public void save(Post post);
    public void update(Post post);
    public void deleteById(int postId);

}
