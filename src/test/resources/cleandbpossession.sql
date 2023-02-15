ALTER TABLE ownership DISABLE KEYS;
SET foreign_key_checks = 0;
TRUNCATE TABLE ownership;
INSERT INTO ownership (user_id, series_season_id) VALUES (2,1);
INSERT INTO ownership (user_id, series_season_id) VALUES (2,2);
INSERT INTO ownership (user_id, series_season_id) VALUES (3,1);
INSERT INTO ownership (user_id, series_season_id) VALUES (2,3);
SET foreign_key_checks = 1;
ALTER TABLE ownership ENABLE KEYS;