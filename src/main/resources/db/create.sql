SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS languages (
 id int PRIMARY KEY auto_increment,
 languagename VARCHAR
);

CREATE TABLE IF NOT EXISTS phrases (
 id int PRIMARY KEY auto_increment,
 phrase VARCHAR,
 definition VARCHAR,
 languageid INTEGER
);


CREATE TABLE IF NOT EXISTS words (
 id int PRIMARY KEY auto_increment,
 word VARCHAR,
 definition VARCHAR,
 languageid INTEGER
 );


CREATE TABLE IF NOT EXISTS locations(
 id int PRIMARY KEY auto_increment,
 city VARCHAR,
 region VARCHAR
);

CREATE TABLE IF NOT EXISTS residences(
 id int PRIMARY KEY auto_increment,
 city VARCHAR,
 region VARCHAR,
 residenceowner VARCHAR,
 foodiate VARCHAR,
 description VARCHAR,
 residenceaddress VARCHAR
);

--CREATE TABLE IF NOT EXISTS restaurants (
-- id int PRIMARY KEY auto_increment,
-- restaurantname VARCHAR,
-- foodiate VARCHAR,
-- restaurantaddress VARCHAR,
-- description VARCHAR,
-- locationid INTEGER
-- );
--
--
--CREATE TABLE IF NOT EXISTS sites (
-- id int PRIMARY KEY auto_increment,
-- name VARCHAR,
-- address VARCHAR,
-- description VARCHAR,
-- locationid INTEGER
-- );
