-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-02-10 14:31:07.327

-- tables
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

-- Table: user
CREATE TABLE user (
    id int  NOT NULL AUTO_INCREMENT,
    first_name varchar(35)  NOT NULL,
    last_name varchar(35)  NOT NULL,
    email varchar(50)  NOT NULL,
    user_name varchar(35)  NOT NULL,
    password varchar(255)  NOT NULL,
    privileges varchar(10)  NOT NULL DEFAULT "user",
    created timestamp  NOT NULL,
    last_login timestamp  NULL,
    deactivated timestamp  NULL,
    active int  NOT NULL DEFAULT 1,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: viewing
CREATE TABLE viewing (
    user_id int  NOT NULL,
    episode_id int  NOT NULL,
    status_id int  NOT NULL,
    CONSTRAINT viewing_pkey PRIMARY KEY (status_id,episode_id,user_id)
);

-- foreign keys
-- Reference: episode_series_season (table: episode)
ALTER TABLE episode ADD CONSTRAINT episode_series_season FOREIGN KEY episode_series_season (series_season_id)
    REFERENCES series_season (id);

-- Reference: ownership_series_season (table: ownership)
ALTER TABLE ownership ADD CONSTRAINT ownership_series_season FOREIGN KEY ownership_series_season (series_season_id)
    REFERENCES series_season (id);

-- Reference: ownership_user (table: ownership)
ALTER TABLE ownership ADD CONSTRAINT ownership_user FOREIGN KEY ownership_user (user_id)
    REFERENCES user (id);

-- Reference: viewing_episode (table: viewing)
ALTER TABLE viewing ADD CONSTRAINT viewing_episode FOREIGN KEY viewing_episode (episode_id)
    REFERENCES episode (id);

-- Reference: viewing_status (table: viewing)
ALTER TABLE viewing ADD CONSTRAINT viewing_status FOREIGN KEY viewing_status (status_id)
    REFERENCES status (id);

-- Reference: viewing_user (table: viewing)
ALTER TABLE viewing ADD CONSTRAINT viewing_user FOREIGN KEY viewing_user (user_id)
    REFERENCES user (id);

-- End of file.

