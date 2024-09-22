CREATE TABLE IF NOT EXISTS user_auth (
    id BIGINT
        REFERENCES users(id)
            primary key,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);