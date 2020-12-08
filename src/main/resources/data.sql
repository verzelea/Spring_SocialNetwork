CREATE TABLE IF NOT EXISTS marque
(
    id_marque INT NOT NULL,
    nom VARCHAR(250) NOT NULL,
    PRIMARY KEY(id_marque)

);


CREATE TABLE IF NOT EXISTS voiture
(
    id_voiture INT NOT NULL,
    id_marque INT NOT NULL,
    id_client INT NOT NULL,
    modele VARCHAR(250) NOT NULL,
    PRIMARY KEY(id_voiture)
);

CREATE TABLE IF NOT EXISTS concessionaire
(
    id_concessionaire INT NOT NULL,
    nom VARCHAR(250) NOT NULL,
    PRIMARY KEY(id_concessionaire)
);

CREATE TABLE IF NOT EXISTS adresse
(
    id_adresse INT NOT NULL,
    libelle VARCHAR(250) NOT NULL,
    id_concessionaire INT NOT NULL,
    PRIMARY KEY(id_adresse)
);

CREATE TABLE IF NOT EXISTS client
(
    id_client INT NOT NULL,
    nom VARCHAR(250) NOT NULL,
    PRIMARY KEY(id_client)
);

CREATE TABLE IF NOT EXISTS mar_co
(
    id_marque INT NOT NULL,
    id_concessionaire INT NOT NULL,
    PRIMARY KEY(id_marque, id_concessionaire)
);


ALTER TABLE voiture
    ADD    FOREIGN KEY (id_marque)
    REFERENCES marque(id_marque)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
    
ALTER TABLE adresse
    ADD    FOREIGN KEY (id_concessionaire)
    REFERENCES concessionaire(id_concessionaire)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
    
ALTER TABLE voiture
    ADD    FOREIGN KEY (id_client)
    REFERENCES client(id_client)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
    
ALTER TABLE mar_co
    ADD    FOREIGN KEY (id_marque)
    REFERENCES marque(id_marque)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;
    
ALTER TABLE mar_co
    ADD    FOREIGN KEY (id_concessionaire)
    REFERENCES concessionaire(id_concessionaire)
    ON DELETE CASCADE
    ON UPDATE CASCADE
;


INSERT INTO marque (id_marque, nom) VALUES (1,'peugeot');
INSERT INTO marque (id_marque, nom) VALUES (2,'renault');
INSERT INTO marque (id_marque, nom) VALUES (3,'ferrari');
INSERT INTO marque (id_marque, nom) VALUES (4,'bugatti');
INSERT INTO marque (id_marque, nom) VALUES (5,'mercedes');

INSERT INTO concessionaire (id_concessionaire, nom) VALUES (1,'autosphere');
INSERT INTO concessionaire (id_concessionaire, nom) VALUES (2,'aramisauto');
INSERT INTO concessionaire (id_concessionaire, nom) VALUES (3,'topauto');
INSERT INTO concessionaire (id_concessionaire, nom) VALUES (4,'franceauto');
INSERT INTO concessionaire (id_concessionaire, nom) VALUES (5,'topgarage');

INSERT INTO adresse (id_adresse, libelle, id_concessionaire) VALUES (1,'rue de la paix',1);
INSERT INTO adresse (id_adresse, libelle, id_concessionaire) VALUES (2,'boulevard de lille',2);
INSERT INTO adresse (id_adresse, libelle, id_concessionaire) VALUES (3,'allee des deux lions',3);
INSERT INTO adresse (id_adresse, libelle, id_concessionaire) VALUES (4,'rue de la toison d or',4);
INSERT INTO adresse (id_adresse, libelle, id_concessionaire) VALUES (5,'rue voltaire',5);
INSERT INTO adresse (id_adresse, libelle, id_concessionaire) VALUES (6,'boulevard de la liberté',4);
INSERT INTO adresse (id_adresse, libelle, id_concessionaire) VALUES (7,'boulevard de l ouest ',5);

INSERT INTO client (id_client, nom) VALUES (1,'billy');
INSERT INTO client (id_client, nom) VALUES (2,'jean');
INSERT INTO client (id_client, nom) VALUES (3,'pierre');
INSERT INTO client (id_client, nom) VALUES (4,'polnaref');
INSERT INTO client (id_client, nom) VALUES (5,'jojo');
INSERT INTO client (id_client, nom) VALUES (6,'bob');
INSERT INTO client (id_client, nom) VALUES (7,'alberto');
INSERT INTO client (id_client, nom) VALUES (8,'marcelo');
INSERT INTO client (id_client, nom) VALUES (9,'franck');
INSERT INTO client (id_client, nom) VALUES (10,'omar');

INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (1,1, 1,'307');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (2,2,2,'megane rs');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (3,3,3,'enzo');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (4,4,4,'chiron');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (5,4,5,'divo');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (6,5,6,'gla');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (7,1,7,'onyx');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (8,2,8,'laguna');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (9,5,9,'sls amg');
INSERT INTO voiture (id_voiture, id_marque, id_client, modele) VALUES (10,3,10,'portofino m');

INSERT INTO mar_co (id_marque, id_concessionaire) VALUES (1,2);
INSERT INTO mar_co (id_marque, id_concessionaire) VALUES (2,3);
INSERT INTO mar_co (id_marque, id_concessionaire) VALUES (3,4);
INSERT INTO mar_co (id_marque, id_concessionaire) VALUES (4,5);
INSERT INTO mar_co (id_marque, id_concessionaire) VALUES (5,1);
INSERT INTO mar_co (id_marque, id_concessionaire) VALUES (4,1);
INSERT INTO mar_co (id_marque, id_concessionaire) VALUES (5,2);
