SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS languages (
 id int PRIMARY KEY auto_increment,
 name VARCHAR
);


CREATE TABLE IF NOT EXISTS locations(
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 city VARCHAR,
 region VARCHAR,
 address VARCHAR
);


CREATE TABLE IF NOT EXISTS phrases (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 phrase VARCHAR,
 definition VARCHAR,
);


--CREATE TABLE IF NOT EXISTS residences(
-- id int PRIMARY KEY auto_increment,
-- name VARCHAR,
-- city VARCHAR,
-- region VARCHAR
-- address VARCHAR,
-- residenceowner VARCHAR,
-- foodiate VARCHAR,
-- description VARCHAR,
--);

--
--CREATE TABLE IF NOT EXISTS restaurants (
-- id int PRIMARY KEY auto_increment,
-- name VARCHAR,
-- foodiate VARCHAR,
-- address VARCHAR,
-- description VARCHAR,
-- locationid INTEGER
-- );
--
--
--CREATE TABLE IF NOT EXISTS sights (
-- id int PRIMARY KEY auto_increment,
-- name VARCHAR,
-- address VARCHAR,
-- description VARCHAR,
-- locationid INTEGER
-- );
--
--
--CREATE TABLE IF NOT EXISTS words (
-- id int PRIMARY KEY auto_increment,
-- word VARCHAR,
-- definition VARCHAR,
-- photo VARCHAR,
-- languageid INTEGER
-- );
--
--
--
--
