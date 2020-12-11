CREATE TABLE IF NOT EXISTS Users
(
 user_id     integer NOT NULL ,
 nom         varchar(45) NOT NULL ,
 prenom      varchar(45) NOT NULL ,
 password    varchar(45) NOT NULL ,
 birthday    date NULL ,
 description varchar(200) NULL ,

PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS Post
(
 post_id integer NOT NULL ,
 text    varchar(45) NOT NULL ,
 user_id integer NOT NULL ,
 private_post binary NOT NULL ,

PRIMARY KEY (post_id)
);

ALTER TABLE Post
    ADD FOREIGN KEY (user_id)
    REFERENCES Users(user_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;

INSERT INTO Users (user_id, nom, prenom, password, birthday, description) VALUES (1,'billy', 'henry', '1234', '1998-10-02', 'love pancake');
INSERT INTO Users (user_id, nom, prenom, password, birthday, description) VALUES (2,'jul', 'valjean', 'Gregoir2003', '2003-02-24', 'i prefer dog');
INSERT INTO Users (user_id, nom, prenom, password, birthday, description) VALUES (3,'jhon', 'snow', 'A,!@lOKm234[]', '1999-12-01', 'join the dark side, we have cookies');
INSERT INTO Users (user_id, nom, prenom, password, birthday, description) VALUES (4,'billy', 'henry', '1234', '1998-10-02', 'love pancake');
INSERT INTO Users (user_id, nom, prenom, password, birthday, description) VALUES (5,'billy', 'henry', '1234', '1998-10-02', 'love pancake');