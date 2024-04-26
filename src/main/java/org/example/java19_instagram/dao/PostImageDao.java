package org.example.java19_instagram.dao;

import org.example.java19_instagram.models.PostImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.Optional;

@Component
public class PostImageDao {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    KeyHolder keyHolder;

    public void save(PostImage postImage) {
        String sql = "insert into post_images (user_id, file_name) " +
                "values ( ?, ? )";
        jdbcTemplate.update(sql, postImage.getPostId(), postImage.getFileName());
    }

    public PostImage getImageById(long imageId) {
        String sql = "select * from post_images where ID = ?";
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PostImage.class), imageId));
    }


    public Long save(Object obj) {
        jdbcTemplate.update(con -> {
            PostImage ui = (PostImage) obj;
            PreparedStatement ps = con.prepareStatement(
                    "insert into post_images(user_id, file_name) values (?, ?)",
                    new String[]{"id"}
            );
            ps.setLong(1, ui.getPostId());
            ps.setString(2, ui.getFileName());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }


    public void delete(Long id) {
        jdbcTemplate.update(
                "delete from post_images where user_id = ?;",
                id
        );
    }

    public Optional<PostImage> findImageByUserId(Long movieId) {
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                """
                                        select *
                                        from post_images
                                        where post_id = ?;
                                        """,
                                new BeanPropertyRowMapper<>(PostImage.class),
                                movieId
                        )
                )
        );
    }
}
