-- liquibase formatted sql

-- changeset developer:initial-data
-- -----------------------------------------------------
-- Table tblRole
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblRole (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  active TINYINT(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX name_UNIQUE (name ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblUser
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblUser (
  id INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(100) NULL,
  lastName VARCHAR(100) NULL,
  login VARCHAR(45) NOT NULL,
  password VARCHAR(200) NOT NULL,
  email VARCHAR(45) NOT NULL,
  phone VARCHAR(45) NULL,
  active TINYINT(1) NOT NULL,
  idRole INT NOT NULL,
  creationDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updateDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  INDEX FK_USER_ROLE_idx (idRole ASC),
  CONSTRAINT FK_USER_ROLE
    FOREIGN KEY (idRole)
    REFERENCES tblRole (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblEventType
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblEventType (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  active TINYINT(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX name_UNIQUE (name ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblEvent
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblEvent (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  description TEXT NOT NULL,
  longitude VARCHAR(45) NOT NULL,
  latitude VARCHAR(45) NOT NULL,
  date VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  active TINYINT(1) NOT NULL,
  cost DECIMAL(10,2) NOT NULL,
  creationDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updateDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  idUser INT NULL,
  idEventType INT NULL,
  published TINYINT(1) NULL,
  publishedDate TIMESTAMP NULL,
  PRIMARY KEY (id),
  INDEX FK_EVENT_USER_idx (idUser ASC),
  INDEX FK_EVENT_EVENT_TYPE_idx (idEventType ASC),
  CONSTRAINT FK_EVENT_USER
    FOREIGN KEY (idUser)
    REFERENCES tblUser (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_EVENT_EVENT_TYPE
    FOREIGN KEY (idEventType)
    REFERENCES tblEventType (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblFile
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblFile (
  id INT NOT NULL AUTO_INCREMENT,
  content LONGBLOB NULL,
  url VARCHAR(200) NULL,
  active TINYINT(1) NOT NULL,
  idEvent INT NULL,
  creationDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  INDEX FK_FILE_EVENT_idx (idEvent ASC),
  CONSTRAINT FK_FILE_EVENT
    FOREIGN KEY (idEvent)
    REFERENCES tblEvent (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblAttendance
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblAttendance (
  id INT NOT NULL AUTO_INCREMENT,
  attendance TINYINT(1) NOT NULL,
  rate INT NOT NULL,
  idUser INT NOT NULL,
  idEvent INT NOT NULL,
  PRIMARY KEY (id),
  INDEX FK_ATTENDANCE_EVENT_idx (idEvent ASC),
  INDEX FK_ATTENDANCE_USER_idx (idUser ASC),
  CONSTRAINT FK_ATTENDANCE_USER
    FOREIGN KEY (idUser)
    REFERENCES tblUser (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_ATTENDANCE_EVENT
    FOREIGN KEY (idEvent)
    REFERENCES tblEvent (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblComment
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblComment (
  id INT NOT NULL AUTO_INCREMENT,
  comment TEXT NULL,
  creationDate TIMESTAMP NULL,
  updateDate TIMESTAMP NULL,
  idEvent INT NULL,
  idUser INT NULL,
  PRIMARY KEY (id),
  INDEX FK_COMMENT_USER_idx (idUser ASC),
  INDEX FK_COMMENT_EVENT_idx (idEvent ASC),
  CONSTRAINT FK_COMMENT_USER
    FOREIGN KEY (idUser)
    REFERENCES tblUser (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_COMMENT_EVENT
    FOREIGN KEY (idEvent)
    REFERENCES tblEvent (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblTag
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblTag (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table tblTagEvent
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tblTagEvent (
  id INT NOT NULL AUTO_INCREMENT,
  idEvent INT NOT NULL,
  idTag INT NOT NULL,
  PRIMARY KEY (id),
  INDEX FK_TAG_EVENT_TAG_idx (idTag ASC),
  INDEX FK_TAG_EVENT_EVENT_idx (idEvent ASC),
  CONSTRAINT FK_TAG_EVENT_TAG
    FOREIGN KEY (idTag)
    REFERENCES tblTag (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FK_TAG_EVENT_EVENT
    FOREIGN KEY (idEvent)
    REFERENCES tblEvent (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

