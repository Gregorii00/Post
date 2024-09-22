CREATE TABLE IF NOT EXISTS users (
    id BIGINT
        CONSTRAINT users_pk
            primary key,
    surname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    patronymic VARCHAR(255),
    gender VARCHAR(255) ,
    birthday TIMESTAMP ,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
    );