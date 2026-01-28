CREATE TABLE IF NOT EXISTS cities
(
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
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
    city_id             VARCHAR(36),
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    FOREIGN KEY (city_id) REFERENCES cities(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS books
(
    id      VARCHAR(36) PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(500),
    author  VARCHAR(255),
    image   VARCHAR(500)
);

