ALTER TABLE viewing DISABLE KEYS;
SET foreign_key_checks = 0;
TRUNCATE TABLE viewing;
INSERT INTO viewing (user_id, series_season_id, episode_id, status_id) VALUES (1,3,1,1);
INSERT INTO viewing (user_id, series_season_id, episode_id, status_id) VALUES (2,1,1,2);
INSERT INTO viewing (user_id, series_season_id, episode_id, status_id) VALUES (3,1,3,2);
INSERT INTO viewing (user_id, series_season_id, episode_id, status_id) VALUES (1,2,2,4);
SET foreign_key_checks = 1;
ALTER TABLE viewing ENABLE KEYS;
