-- Заполнение таблицы "users"
INSERT INTO users (username, email, password, avatar, name, enabled, bio)
VALUES ('user1', 'user1@example.com', 'password1', 'avatar1.jpg', 'User One', true, 'Bio for User One'),
       ('user2', 'user2@example.com', 'password2', 'avatar2.jpg', 'User Two', true, 'Bio for User Two'),
       ('user3', 'user3@example.com', 'password3', 'avatar3.jpg', 'User Three', true, 'Bio for User Three');

-- Заполнение таблицы "posts"
INSERT INTO posts (user_id, file_name, description, likes_count, created_at)
VALUES (1, 'post1.jpg', 'Description for Post 1', 10, '2024-04-26 08:00:00'),
       (2, 'post2.jpg', 'Description for Post 2', 5, '2024-04-25 12:00:00'),
       (3, 'post3.jpg', 'Description for Post 3', 3, '2024-04-24 15:00:00');

-- Заполнение таблицы "comments"
INSERT INTO comments (post_id, user_id, content, created_at)
VALUES (1, 2, 'Comment on Post 1 by User 2', '2024-04-26 08:05:00'),
       (2, 3, 'Comment on Post 2 by User 3', '2024-04-25 12:05:00'),
       (3, 1, 'Comment on Post 3 by User 1', '2024-04-24 15:05:00');

-- Заполнение таблицы "subscriptions"
INSERT INTO subscriptions (user_id, follower_id, created_at)
VALUES (1, 2, '2024-04-26 08:10:00'),
       (2, 3, '2024-04-25 12:10:00'),
       (3, 1, '2024-04-24 15:10:00');

-- Заполнение таблицы "likes"
INSERT INTO likes (user_id, post_id, created_at)
VALUES (1, 2, '2024-04-26 08:15:00'),
       (2, 3, '2024-04-25 12:15:00'),
       (3, 1, '2024-04-24 15:15:00');

-- Заполнение таблицы "authorities"
INSERT INTO authorities (authority)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

-- Заполнение таблицы "user_authorities"
INSERT INTO user_authorities (user_id, authority_id)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (1, 2);

-- -- Заполнение таблицы "post_images"
-- INSERT INTO post_images (post_id, file_name)
-- VALUES (1, 'post1_image1.jpg'),
--        (1, 'post1_image2.jpg'),
--        (2, 'post2_image1.jpg');
