CREATE DATABASE workshop2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE workshop2;

CREATE TABLE users (
    id int (11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    email VARCHAR(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    password VARCHAR(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO users (username, email, password) VALUES (?, ?, ?);
UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;
SELECT * FROM users WHERE id = ?;
DELETE FROM users WHERE id = ?;

SELECT * FROM users;