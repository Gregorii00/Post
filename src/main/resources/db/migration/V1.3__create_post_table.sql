CREATE TABLE IF NOT EXISTS post (
    id BIGINT
        CONSTRAINT post_pk
            primary key,
    description VARCHAR(1024),
    users_id BIGINT NOT NULL
        REFERENCES users(id),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    view VARCHAR(5)
    );