DROP TABLE `wood`;

CREATE TABLE wood (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    age INTEGER NOT NULL,
    artificial BOOLEAN NOT NULL,
    colour VARCHAR(255),
    coniferous BOOLEAN NOT NULL,
    name VARCHAR(255),
    soft BOOLEAN NOT NULL,
    weight INTEGER NOT NULL
);