-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-17 17:22:44.207

-- foreign keys
ALTER TABLE credit
    DROP FOREIGN KEY credit_episode;

ALTER TABLE credit
    DROP FOREIGN KEY credit_person;

ALTER TABLE credit
    DROP FOREIGN KEY credit_role;

ALTER TABLE episode
    DROP FOREIGN KEY episode_series_season;

ALTER TABLE episode
    DROP FOREIGN KEY episode_synopsis;

ALTER TABLE own
    DROP FOREIGN KEY own_series_season;

ALTER TABLE own
    DROP FOREIGN KEY own_user;

ALTER TABLE view
    DROP FOREIGN KEY view_episode;

ALTER TABLE view
    DROP FOREIGN KEY view_status;

ALTER TABLE view
    DROP FOREIGN KEY view_user;

-- tables
DROP TABLE credit;

DROP TABLE episode;

DROP TABLE own;

DROP TABLE person;

DROP TABLE role;

DROP TABLE series_season;

DROP TABLE status;

DROP TABLE synopsis;

DROP TABLE user;

DROP TABLE view;

-- End of file.

-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-17 17:22:44.207

-- tables
-- Table: credit
CREATE TABLE credit (
    id int  NOT NULL AUTO_INCREMENT,
    episode_id int  NOT NULL,
    person_id int  NOT NULL,
    role_id int  NOT NULL,
    CONSTRAINT credit_pk PRIMARY KEY (id)
);

-- Table: episode
CREATE TABLE episode (
    id int  NOT NULL AUTO_INCREMENT,
    title varchar(100)  NOT NULL,
    synopsis_id int  NOT NULL,
    series_season_id int  NOT NULL,
    CONSTRAINT episode_pk PRIMARY KEY (id)
);

-- Table: own
CREATE TABLE own (
    id int  NOT NULL AUTO_INCREMENT,
    user_id int  NOT NULL,
    series_season_id int  NOT NULL,
    CONSTRAINT ownership_pkey PRIMARY KEY (id)
);

-- Table: person
CREATE TABLE person (
    id int  NOT NULL AUTO_INCREMENT,
    first_name varchar(30)  NOT NULL,
    last_name varchar(30)  NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id int  NOT NULL AUTO_INCREMENT,
    role_name varchar(30)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: series_season
CREATE TABLE series_season (
    id int  NOT NULL AUTO_INCREMENT,
    series_name varchar(40)  NOT NULL,
    season int  NOT NULL,
    CONSTRAINT series_season_pk PRIMARY KEY (id)
);

-- Table: status
CREATE TABLE status (
    id int  NOT NULL AUTO_INCREMENT,
    status varchar(30)  NOT NULL,
    CONSTRAINT status_pk PRIMARY KEY (id)
);

-- Table: synopsis
CREATE TABLE synopsis (
    id int  NOT NULL AUTO_INCREMENT,
    summary text  NOT NULL,
    CONSTRAINT synopsis_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE user (
    id int  NOT NULL AUTO_INCREMENT,
    first_name varchar(35)  NOT NULL,
    last_name varchar(35)  NOT NULL,
    email varchar(50)  NOT NULL,
    user_name varchar(35)  NOT NULL,
    password varchar(255)  NOT NULL,
    privileges varchar(10)  NOT NULL DEFAULT "user",
    created timestamp  NOT NULL DEFAULT NOW(),
    last_login timestamp  NULL,
    deactivated timestamp  NULL,
    active int  NOT NULL DEFAULT 1,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: view
CREATE TABLE view (
    id int  NOT NULL AUTO_INCREMENT,
    status_id int  NOT NULL,
    user_id int  NOT NULL,
    episode_id int  NOT NULL,
    CONSTRAINT viewing_pkey PRIMARY KEY (id)
);

-- foreign keys
-- Reference: credit_episode (table: credit)
ALTER TABLE credit ADD CONSTRAINT credit_episode FOREIGN KEY credit_episode (episode_id)
    REFERENCES episode (id);

-- Reference: credit_person (table: credit)
ALTER TABLE credit ADD CONSTRAINT credit_person FOREIGN KEY credit_person (person_id)
    REFERENCES person (id);

-- Reference: credit_role (table: credit)
ALTER TABLE credit ADD CONSTRAINT credit_role FOREIGN KEY credit_role (role_id)
    REFERENCES role (id);

-- Reference: episode_series_season (table: episode)
ALTER TABLE episode ADD CONSTRAINT episode_series_season FOREIGN KEY episode_series_season (series_season_id)
    REFERENCES series_season (id);

-- Reference: episode_synopsis (table: episode)
ALTER TABLE episode ADD CONSTRAINT episode_synopsis FOREIGN KEY episode_synopsis (synopsis_id)
    REFERENCES synopsis (id);

-- Reference: own_series_season (table: own)
ALTER TABLE own ADD CONSTRAINT own_series_season FOREIGN KEY own_series_season (series_season_id)
    REFERENCES series_season (id);

-- Reference: own_user (table: own)
ALTER TABLE own ADD CONSTRAINT own_user FOREIGN KEY own_user (user_id)
    REFERENCES user (id);

-- Reference: view_episode (table: view)
ALTER TABLE view ADD CONSTRAINT view_episode FOREIGN KEY view_episode (episode_id)
    REFERENCES episode (id);

-- Reference: view_status (table: view)
ALTER TABLE view ADD CONSTRAINT view_status FOREIGN KEY view_status (status_id)
    REFERENCES status (id);

-- Reference: view_user (table: view)
ALTER TABLE view ADD CONSTRAINT view_user FOREIGN KEY view_user (user_id)
    REFERENCES user (id);

-- End of file.

