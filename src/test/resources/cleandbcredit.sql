ALTER TABLE credited DISABLE KEYS;
SET foreign_key_checks = 0;
TRUNCATE TABLE credited;
INSERT INTO credited (first_name, last_name, episode_id, role_id) VALUES ('Andy', 'Alerson', 2, 1);
INSERT INTO credited (first_name, last_name, episode_id, role_id) VALUES ('Kelly', 'Kapowski', 2, 2);
INSERT INTO credited (first_name, last_name, episode_id, role_id) VALUES ('Bobby', 'Bindle', 4, 3);
INSERT INTO credited (first_name, last_name, episode_id, role_id) VALUES ('Dave', 'Davidson', 2, 4);
SET foreign_key_checks = 1;
ALTER TABLE credited ENABLE KEYS;