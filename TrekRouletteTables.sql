-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-14 16:19:16.418

-- foreign keys
ALTER TABLE credited
    DROP FOREIGN KEY credited_episode;

ALTER TABLE credited
    DROP FOREIGN KEY credited_role;

ALTER TABLE episode
    DROP FOREIGN KEY episode_series_season;

ALTER TABLE ownership
    DROP FOREIGN KEY ownership_series_season;

ALTER TABLE ownership
    DROP FOREIGN KEY ownership_user;

ALTER TABLE synopsis
    DROP FOREIGN KEY synopsis_episode;

ALTER TABLE viewing
    DROP FOREIGN KEY viewing_episode;

ALTER TABLE viewing
    DROP FOREIGN KEY viewing_series_season;

ALTER TABLE viewing
    DROP FOREIGN KEY viewing_status;

ALTER TABLE viewing
    DROP FOREIGN KEY viewing_user;

-- tables
DROP TABLE credited;

DROP TABLE episode;

DROP TABLE ownership;

DROP TABLE role;

DROP TABLE series_season;

DROP TABLE status;

DROP TABLE synopsis;

DROP TABLE user;

DROP TABLE viewing;

-- End of file.



-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-14 16:19:16.418

-- tables
-- Table: credited
CREATE TABLE credited (
    id int  NOT NULL AUTO_INCREMENT,
    first_name varchar(30)  NOT NULL,
    last_name varchar(30)  NOT NULL,
    episode_id int  NOT NULL,
    role_id int  NOT NULL,
    CONSTRAINT credited_pk PRIMARY KEY (id)
);

-- Table: episode
CREATE TABLE episode (
    id int  NOT NULL AUTO_INCREMENT,
    ep_title varchar(50)  NOT NULL,
    series_season_id int  NOT NULL,
    CONSTRAINT episode_pk PRIMARY KEY (id)
);

-- Table: ownership
CREATE TABLE ownership (
    user_id int  NOT NULL,
    series_season_id int  NOT NULL,
    CONSTRAINT ownership_pkey PRIMARY KEY (user_id,series_season_id)
);

-- Table: role
CREATE TABLE role (
    id int  NOT NULL AUTO_INCREMENT,
    role_name varchar(50)  NOT NULL,
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
    episode_id int  NOT NULL,
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

-- Table: viewing
CREATE TABLE viewing (
    user_id int  NOT NULL,
    series_season_id int  NOT NULL,
    episode_id int  NOT NULL,
    status_id int  NOT NULL,
    CONSTRAINT viewing_pkey PRIMARY KEY (status_id,episode_id,user_id,series_season_id)
);

-- foreign keys
-- Reference: credited_episode (table: credited)
ALTER TABLE credited ADD CONSTRAINT credited_episode FOREIGN KEY credited_episode (episode_id)
    REFERENCES episode (id);

-- Reference: credited_role (table: credited)
ALTER TABLE credited ADD CONSTRAINT credited_role FOREIGN KEY credited_role (role_id)
    REFERENCES role (id);

-- Reference: episode_series_season (table: episode)
ALTER TABLE episode ADD CONSTRAINT episode_series_season FOREIGN KEY episode_series_season (series_season_id)
    REFERENCES series_season (id);

-- Reference: ownership_series_season (table: ownership)
ALTER TABLE ownership ADD CONSTRAINT ownership_series_season FOREIGN KEY ownership_series_season (series_season_id)
    REFERENCES series_season (id);

-- Reference: ownership_user (table: ownership)
ALTER TABLE ownership ADD CONSTRAINT ownership_user FOREIGN KEY ownership_user (user_id)
    REFERENCES user (id);

-- Reference: synopsis_episode (table: synopsis)
ALTER TABLE synopsis ADD CONSTRAINT synopsis_episode FOREIGN KEY synopsis_episode (episode_id)
    REFERENCES episode (id);

-- Reference: viewing_episode (table: viewing)
ALTER TABLE viewing ADD CONSTRAINT viewing_episode FOREIGN KEY viewing_episode (episode_id)
    REFERENCES episode (id);

-- Reference: viewing_series_season (table: viewing)
ALTER TABLE viewing ADD CONSTRAINT viewing_series_season FOREIGN KEY viewing_series_season (series_season_id)
    REFERENCES series_season (id);

-- Reference: viewing_status (table: viewing)
ALTER TABLE viewing ADD CONSTRAINT viewing_status FOREIGN KEY viewing_status (status_id)
    REFERENCES status (id);

-- Reference: viewing_user (table: viewing)
ALTER TABLE viewing ADD CONSTRAINT viewing_user FOREIGN KEY viewing_user (user_id)
    REFERENCES user (id);

-- End of file.

