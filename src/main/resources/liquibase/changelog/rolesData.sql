-- liquibase formatted sql

-- changeset developer:roles-data
INSERT INTO tblRole (name, active) VALUES ("ADMIN", 1);
INSERT INTO tblRole (name, active) VALUES ("USER", 1);
INSERT INTO tblRole (name, active) VALUES ("COMPANY", 1);