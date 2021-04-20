# creating user
CREATE USER 'jesustorres'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON * . * TO 'jesustorres'@'localhost';

# creating db schema
CREATE SCHEMA prueba_practica;