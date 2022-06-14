INSERT INTO webpageusers (username, password, enabled)
VALUES ('user1', 'user1', true),
       ('user2', 'user2', true),
       ('user3', 'user3', false),
       ('admin', 'admin', true);

INSERT INTO webpageauthorities (username, authority)
VALUES ('user1', 'ROLE_USER'),
       ('user2', 'ROLE_USER'),
       ('user2', 'ROLE_ADMIN'),
       ('admin', 'ROLE_ADMIN');