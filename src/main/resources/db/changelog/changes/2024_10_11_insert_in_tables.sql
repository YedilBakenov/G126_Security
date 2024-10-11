INSERT INTO items(created_at, update_at, name, description, price)
VALUES (null,null, 'OPTICAL MOUSE','PRO-MAX', 2000),
       (null,null, 'MOUSE', 'PRO', 1000);

INSERT INTO permissions (role)
VALUES ('ROLE_USER'),
       ('ROLE_STUDENT'),
       ('ROLE_TEACHER'),
       ('ROLE_ADMIN');

INSERT INTO users (email, full_name, password)
VALUES ('berik@gmail.com', 'Berik Berikov', '$2a$12$M3h7.oAYXGQVXw7Cgsl07uHmR8.ouQKC9SqdDbQczi.S5xhr6M0w6'),
       ('serik@gmail.com', 'Serik Serikov', '$2a$10$vO96gan1VhVgltnt07RameadrMzp0f/RL9yx9YBic7esoqrXpT4vm');

INSERT INTO users_permissions(user_id, permissions_id)
VALUES(1, 1),
        (1, 2),
        (2, 4);