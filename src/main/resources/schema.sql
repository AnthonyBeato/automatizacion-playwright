CREATE TABLE IF NOT EXISTS tbl_photos (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          url VARCHAR(255),
    title VARCHAR(255),
    subtitle VARCHAR(255),
    description VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS tbl_users (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         username VARCHAR(255),
    password VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS tbl_messages (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(255),
    email VARCHAR(255),
    text VARCHAR(255)
    );
