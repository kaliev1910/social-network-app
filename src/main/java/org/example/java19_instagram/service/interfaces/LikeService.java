package org.example.java19_instagram.service.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface LikeService {
    void like(int post_id);

    void unlike(int post_id);


}
