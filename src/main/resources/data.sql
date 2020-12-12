CREATE TABLE IF NOT EXISTS User
(
 user_id     integer NOT NULL ,
 nom         varchar(45) NOT NULL ,
 prenom      varchar(45) NOT NULL ,
 password    nvarchar(45) NOT NULL ,
 birthday    date NULL ,
 description nvarchar(200) NULL ,

PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS Post
(
 post_id integer NOT NULL ,
 text    nvarchar(45) NOT NULL ,
 user_id integer NOT NULL ,
 private_post binary NOT NULL ,

PRIMARY KEY (post_id)
);

ALTER TABLE Post
    ADD FOREIGN KEY (user_id)
    REFERENCES User(user_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;

INSERT INTO User (user_id, nom, prenom, password, birthday, description) VALUES (1,'billy', 'henry', '1234', '1998-10-02', 'love pancake');
INSERT INTO User (user_id, nom, prenom, password, birthday, description) VALUES (2,'valjean', 'jul', 'Gregoir2003', '2003-02-24', 'i prefer dog');
INSERT INTO User (user_id, nom, prenom, password, birthday, description) VALUES (3,'snow', 'jhon', 'A,!@lOKm234[]', '1999-12-01', 'join the dark side, we have cookies');
INSERT INTO User (user_id, nom, prenom, password, birthday, description) VALUES (4,'pat', 'frederic', '4321', '1978-10-12', 'love pancake');
INSERT INTO User (user_id, nom, prenom, password, birthday, description) VALUES (5,'gaulois', 'francois', '0000', '2003-01-23', 'love pancake');

INSERT INTO Post (post_id, text, user_id, private_post) VALUES (1, 'Hello', 1, 0);
INSERT INTO Post (post_id, text, user_id, private_post) VALUES (2, 'Neel sent le babouin', 3, 1);
INSERT INTO Post (post_id, text, user_id, private_post) VALUES (3, 'J aime les cookies', 4, 0);
INSERT INTO Post (post_id, text, user_id, private_post) VALUES (4, 'DITES NON AU MANIDESTATION', 2, 0);
