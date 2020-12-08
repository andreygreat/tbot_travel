CREATE TABLE city
(
    id     SERIAL PRIMARY KEY,
    name   VARCHAR(200) NOT NULL UNIQUE,
    info   TEXT
)