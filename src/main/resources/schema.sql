DROP TABLE IF EXISTS person;

CREATE TABLE person (
    id BIGINT IDENTITY PRIMARY KEY,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    birthdate DATE NULL,
    family_id BIGINT NULL
);

DROP TABLE IF EXISTS family;

CREATE TABLE family (
    id BIGINT IDENTITY PRIMARY KEY,
    name VARCHAR(50)
);

ALTER TABLE person ADD CONSTRAINT fk_person_family FOREIGN KEY (family_id) REFERENCES family (id);