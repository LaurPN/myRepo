-- password: $2b$12$5bvp5Pp6RabvmP5KHqTwauinm/cBJfxKwus3IW4ZVAdgkBHyZ3g2q
-- select email, password, authentication_role from user inner join authentication_role on user.authentication_role_id=authentication_role.id;

CREATE USER 'proiect_db_auth_user'@'localhost' IDENTIFIED BY 'Auth123';

CREATE DATABASE proiect_db_auth;

GRANT ALL PRIVILEGES ON proiect_db_auth.* TO 'proiect_db_auth_user'@'localhost';

FLUSH PRIVILEGES;

USE proiect_db_auth

CREATE TABLE authentication_role (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, authentication_role VARCHAR(50) NOT NULL UNIQUE);

INSERT INTO authentication_role (authentication_role) VALUES ("admin");
INSERT INTO authentication_role (authentication_role) VALUES ("mechanic");
INSERT INTO authentication_role (authentication_role) VALUES ("accountant");

CREATE TABLE user (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, email VARCHAR(255) NOT NULL UNIQUE, password VARCHAR(255) NOT NULL, authentication_role_id INT NOT NULL, CONSTRAINT FK_user_authentication_role FOREIGN KEY (authentication_role_id) REFERENCES authentication_role(id));

INSERT INTO user (email, password, authentication_role_id) VALUES ("laurentiu.nicolae1@gmail.com", "$2b$12$5bvp5Pp6RabvmP5KHqTwauinm/cBJfxKwus3IW4ZVAdgkBHyZ3g2q", 1);