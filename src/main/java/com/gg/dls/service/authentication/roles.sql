CREATE TABLE roles(
   id serial PRIMARY KEY,
   name VARCHAR (255) UNIQUE NOT NULL
);


        INSERT INTO roles(name) VALUES('ROLE_USER');
        INSERT INTO roles(name) VALUES('ROLE_PM');
        INSERT INTO roles(name) VALUES('ROLE_ADMIN');

<!--

-->