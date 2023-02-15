ALTER TABLE status DISABLE KEYS;
SET foreign_key_checks = 0;
TRUNCATE TABLE status;
INSERT INTO status (status) VALUES ("Unviewed");
INSERT INTO status (status) VALUES ("Queued");
INSERT INTO status (status) VALUES ("In Progress");
INSERT INTO status (status) VALUES ("Viewed");
SET foreign_key_checks = 1;
ALTER TABLE status ENABLE KEYS;
