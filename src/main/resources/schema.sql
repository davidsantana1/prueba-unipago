CREATE TABLE IF NOT EXISTS movies (
    id              VARCHAR(60)     DEFAULT RANDOM_UUID() PRIMARY KEY,
    title           VARCHAR         NOT NULL,
    release_year    INT             NULL,
    status          VARCHAR(9)      NOT NULL
);