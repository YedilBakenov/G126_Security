CREATE TABLE items(
    id          SERIAL PRIMARY KEY,
    created_at  TIMESTAMP,
    update_at   TIMESTAMP,
    name        varchar,
    description text,
    price       double precision
);

CREATE TABLE permissions(
    id   SERIAL PRIMARY KEY,
    role varchar
);

CREATE TABLE users(
    id        SERIAL PRIMARY KEY,
    email     varchar,
    full_name varchar,
    password  varchar
);


CREATE TABLE users_permissions(
    user_id        int,
    permissions_id int
);


ALTER TABLE users_permissions
    ADD CONSTRAINT fk_users_permissions_users
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON UPDATE CASCADE;

ALTER TABLE users_permissions
    ADD CONSTRAINT fk_users_permissions_permission
        FOREIGN KEY (permissions_id)
            REFERENCES permissions (id)
            ON DELETE CASCADE;

