CREATE TABLE IF NOT EXISTS users
(
    id                  VARCHAR(36) PRIMARY KEY,
    username            VARCHAR(50)  NOT NULL UNIQUE,
    email               VARCHAR(255) UNIQUE,
    first_name          VARCHAR(100),
    last_name           VARCHAR(100),
    bio                 TEXT,
    profile_picture_url VARCHAR(500),
    status              VARCHAR(50),
    phone_number        VARCHAR(30),
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

