SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS languages (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);


CREATE TABLE IF NOT EXISTS phrases (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 phrase VARCHAR,
 definition VARCHAR,
);


--CREATE TABLE IF NOT EXISTS words (
-- id int PRIMARY KEY auto_increment,
-- word VARCHAR,
-- definition VARCHAR,
-- photo VARCHAR,
-- languageid INTEGER
-- );
