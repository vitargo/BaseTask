CREATE SCHEMA IF NOT EXISTS crud;
USE crud;
CREATE TABLE IF NOT EXISTS people
(
    id int auto_increment
        primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    age int not null,
    city varchar(50) not null
);