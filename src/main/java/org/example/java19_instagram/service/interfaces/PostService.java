package org.example.java19_instagram.service.interfaces;

import org.example.java19_instagram.dto.PostDto;
import org.example.java19_instagram.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    void createPost(PostDto post);

    Post getPost(String id);

    List<PostDto> getUserPosts(String username);

    void deletePost(String id);

    void updatePost(PostDto post);

    int countPosts();


}
