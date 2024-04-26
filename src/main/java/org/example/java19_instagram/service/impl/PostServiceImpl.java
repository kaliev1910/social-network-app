package org.example.java19_instagram.service.impl;

import org.example.java19_instagram.dto.PostDto;
import org.example.java19_instagram.models.Post;
import org.example.java19_instagram.service.interfaces.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public void createPost(PostDto post) {

    }

    @Override
    public Post getPost(String id) {
        return null;
    }

    @Override
    public List<PostDto> getUserPosts(String username) {
        return List.of();
    }

    @Override
    public void deletePost(String id) {

    }

    @Override
    public void updatePost(PostDto post) {

    }

    @Override
    public int countPosts() {
        return 0;
    }
}
