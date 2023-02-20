SET foreign_key_checks = 0;

TRUNCATE TABLE user;
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First1','Last1','fl1@test.com','fl1','password','user','2023-02-17 15:33:28');
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First2','Last2','fl2@test.com','fl2','password','user','2023-02-17 15:33:28');
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First3','Last3','fl3@test.com','fl3','password','user','2023-02-17 15:33:28');
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First4','Last4','fl4@test.com','fl4','password','user','2023-02-17 15:33:28');
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First5','Last5','fl5@test.com','fl5','password','user','2023-02-17 15:33:28');
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First6','Last6','fl6@test.com','fl6','password','user','2023-02-17 15:33:28');
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First7','Last7','fl7@test.com','fl7','password','user','2023-02-17 15:33:28');
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First8','Last8','fl8@test.com','fl8','password','user','2023-02-17 15:33:28');
INSERT INTO user (first_name, last_name, email, user_name, password, privileges, created) VALUES ('First9','Last9','fl9@test.com','fl9','password','user','2023-02-17 15:33:28');

SET foreign_key_checks = 1;
