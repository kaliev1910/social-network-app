package org.example.java19_instagram.dao.interfaces;

import org.example.java19_instagram.models.Like;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LikeDao {
    public void save(Like like);
    public List<Like> getLikes();
    public Like getLike(int id);
    public void deleteLike(int id);

}
