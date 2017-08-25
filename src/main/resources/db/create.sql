SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS languages (
 id int PRIMARY KEY auto_increment,
 languagename VARCHAR
);


CREATE TABLE IF NOT EXISTS locations(
 id int PRIMARY KEY auto_increment,
 locationname VARCHAR,
 city VARCHAR,
 region VARCHAR,
 address VARCHAR
);


CREATE TABLE IF NOT EXISTS phrases (
 id int PRIMARY KEY auto_increment,
 phrase VARCHAR,
 definition VARCHAR,
 languageid int,
 wordId int
);


CREATE TABLE IF NOT EXISTS residences(
 id int PRIMARY KEY auto_increment,
 residenceowner VARCHAR,
 foodiate VARCHAR,
 description VARCHAR,
 locationid int
);


CREATE TABLE IF NOT EXISTS restaurants (
 id int PRIMARY KEY auto_increment,
 restaurantname VARCHAR,
 foodiate VARCHAR,
 address VARCHAR,
 description VARCHAR,
 locationid int
 );


CREATE TABLE IF NOT EXISTS sights (
 id int PRIMARY KEY auto_increment,
 sightname VARCHAR,
 address VARCHAR,
 description VARCHAR,
 locationid int
 );


CREATE TABLE IF NOT EXISTS words (
 id int PRIMARY KEY auto_increment,
 word VARCHAR,
 definition VARCHAR,
 photo VARCHAR,
 languageid int
 );




