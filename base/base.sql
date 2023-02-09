create database imprimerie;
\c imprimerie postgres
CREATE SEQUENCE s_Employe INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_Fonctionnalite INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_FonctionnaliteEmploye INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_Genre INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE TABLE Employe (
  idEmploye     varchar(20) NOT NULL, 
  Nom           varchar(100) NOT NULL, 
  Prenom        varchar(100) NOT NULL, 
  DateNaissance date NOT NULL, 
  idGenre       varchar(20) NOT NULL, 
  PRIMARY KEY (idEmploye));
CREATE TABLE Fonctionnalite (
  idFonctionnalite varchar(20) NOT NULL, 
  Designation      varchar(30) NOT NULL, 
  PRIMARY KEY (idFonctionnalite));
CREATE TABLE FonctionnaliteEmploye (
  idFonctionnaliteEmploye varchar(30) NOT NULL, 
  idFonctionnalite        varchar(20) NOT NULL, 
  idEmploye               varchar(20) NOT NULL, 
  PRIMARY KEY (idFonctionnaliteEmploye));
CREATE TABLE Genre (
  idGenre     varchar(20) NOT NULL, 
  Designation varchar(20) NOT NULL, 
  PRIMARY KEY (idGenre));
ALTER TABLE FonctionnaliteEmploye ADD CONSTRAINT FKFonctionna557252 FOREIGN KEY (idEmploye) REFERENCES Employe (idEmploye);
ALTER TABLE FonctionnaliteEmploye ADD CONSTRAINT FKFonctionna276728 FOREIGN KEY (idFonctionnalite) REFERENCES Fonctionnalite (idFonctionnalite);
ALTER TABLE Employe ADD CONSTRAINT FKEmploye277043 FOREIGN KEY (idGenre) REFERENCES Genre (idGenre);

INSERT INTO Fonctionnalite
  (idFonctionnalite, 
  Designation) 
VALUES 
  ('Fonctionnalite_'||nextval('s_Fonctionnalite'), 
  'testeur de papier');


INSERT INTO Fonctionnalite
  (idFonctionnalite, 
  Designation) 
VALUES 
  ('Fonctionnalite_'||nextval('s_Fonctionnalite'), 
  'saisie ');

  INSERT INTO Fonctionnalite
  (idFonctionnalite, 
  Designation) 
VALUES 
  ('Fonctionnalite_'||nextval('s_Fonctionnalite'), 
  'machiniste ');

  INSERT INTO Fonctionnalite
  (idFonctionnalite, 
  Designation) 
VALUES 
  ('Fonctionnalite_'||nextval('s_Fonctionnalite'), 
  'manao maquette ');

  INSERT INTO Fonctionnalite
  (idFonctionnalite, 
  Designation) 
VALUES 
  ('Fonctionnalite_'||nextval('s_Fonctionnalite'), 
  'mpanapaka taratasy ');

INSERT INTO Genre
  (idGenre, 
  Designation) 
VALUES 
  ('Genre_'||nextval('s_Genre'), 
  'Femme');

  
INSERT INTO Genre
  (idGenre, 
  Designation) 
VALUES 
  ('Genre_'||nextval('s_Genre'), 
  'Homme');

CREATE SEQUENCE s_Activite INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_EmployeActivite INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_Salaire INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE TABLE Activite (
  idActivite  varchar(20) NOT NULL, 
  Designation varchar(50) NOT NULL, 
  PRIMARY KEY (idActivite));
CREATE TABLE EmployeActivite (
  idEmployeActivite varchar(20) NOT NULL, 
  idFonctionnalite  varchar(20) NOT NULL, 
  Duree             int4 NOT NULL, 
  idActivite        varchar(20) NOT NULL, 
  PRIMARY KEY (idEmployeActivite));
ALTER TABLE EmployeActivite ADD CONSTRAINT FKEmployeAct342010 FOREIGN KEY (idActivite) REFERENCES Activite (idActivite);

CREATE TABLE Salaire (
  idSalaire        varchar(20) NOT NULL, 
  idFonctionnalite varchar(20) NOT NULL, 
  Valeur           DOUBLE PRECISION NOT NULL, 
  TempsHeure       int4 NOT NULL, 
  PRIMARY KEY (idSalaire));
ALTER TABLE Salaire ADD CONSTRAINT FKSalaire142549 FOREIGN KEY (idFonctionnalite) REFERENCES Fonctionnalite (idFonctionnalite);
ALTER TABLE EmployeActivite ADD CONSTRAINT FKEmployeAct839041 FOREIGN KEY (idFonctionnalite) REFERENCES Fonctionnalite (idFonctionnalite);

CREATE TABLE ActiviteMB (
  idActiviteMB  varchar(30) NOT NULL, 
  Valeur        DOUBLE PRECISION NOT NULL, 
  DateInsertion timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  PRIMARY KEY (idActiviteMB));
CREATE TABLE Materiel (
  idMateriel   varchar(30) NOT NULL, 
  Nom          text NOT NULL, 
  PrixUnitaire DOUBLE PRECISION NOT NULL, 
  PRIMARY KEY (idMateriel));
CREATE TABLE MaterielActivite (
  idMaterielActivite varchar(30) NOT NULL, 
  idMateriel         varchar(30) NOT NULL, 
  Quantite           int4 NOT NULL, 
  idActivite         varchar(20) NOT NULL, 
  PRIMARY KEY (idMaterielActivite));
ALTER TABLE MaterielActivite ADD CONSTRAINT FKMaterielAc70093 FOREIGN KEY (idMateriel) REFERENCES Materiel (idMateriel);
ALTER TABLE MaterielActivite ADD CONSTRAINT FKMaterielAc460696 FOREIGN KEY (idActivite) REFERENCES Activite (idActivite);

INSERT INTO Activite
  (idActivite, 
  Designation) 
VALUES 
  ('Activite_'||nextval('s_Activite'), 
  'Fiche');


INSERT INTO EmployeActivite
  (idEmployeActivite,idActivite, 
  idFonctionnalite, 
  Duree) 
VALUES 
  ('EmployeActivite_'||nextval('s_EmployeActivite'),'Activite_1' ,
  'Fonctionnalite_3',
  30);

  INSERT INTO EmployeActivite
  (idEmployeActivite,idActivite, 
  idFonctionnalite, 
  Duree) 
VALUES 
  ('EmployeActivite_'||nextval('s_EmployeActivite'),'Activite_1' ,
  'Fonctionnalite_4',
  180);

  INSERT INTO EmployeActivite
  (idEmployeActivite,idActivite, 
  idFonctionnalite, 
  Duree) 
VALUES 
  ('EmployeActivite_'||nextval('s_EmployeActivite'),'Activite_1' ,
  'Fonctionnalite_5',
  10);


INSERT INTO Salaire
  (idSalaire, 
  idFonctionnalite, 
  Valeur, 
  TempsHeure) 
VALUES 
  ('Salaire_'||nextval('s_Salaire'), 
  'Fonctionnalite_3', 
  20000, 
  60);

  INSERT INTO Salaire
  (idSalaire, 
  idFonctionnalite, 
  Valeur, 
  TempsHeure) 
VALUES 
  ('Salaire_'||nextval('s_Salaire'), 
  'Fonctionnalite_4', 
  30000, 
  60);

  INSERT INTO Salaire
  (idSalaire, 
  idFonctionnalite, 
  Valeur, 
  TempsHeure) 
VALUES 
  ('Salaire_'||nextval('s_Salaire'), 
  'Fonctionnalite_5', 
  25000, 
  60);

CREATE SEQUENCE s_ActiviteMB INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_Materiel INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_MaterielActivite INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;


  INSERT INTO ActiviteMB
  (idActiviteMB, 
  Valeur) 
VALUES 
  ('ActiviteMB_'||nextval('s_ActiviteMB'), 
  20);

  
INSERT INTO Materiel
  (idMateriel, 
  Nom, 
  PrixUnitaire) 
VALUES 
  ('Materiel_'||nextval('s_Materiel'), 
  'Papier', 
  '20000');

  INSERT INTO Materiel
  (idMateriel, 
  Nom, 
  PrixUnitaire) 
VALUES 
  ('Materiel_'||nextval('s_Materiel'), 
  'Trambone', 
  '10000');

INSERT INTO MaterielActivite
  (idMaterielActivite, 
  idMateriel, 
  Quantite, 
  idActivite) 
VALUES 
  ('MaterielActivite_'||nextval('s_MaterielActivite'), 
  'Materiel_1', 
  10, 
  'Activite_1');


INSERT INTO MaterielActivite
  (idMaterielActivite, 
  idMateriel, 
  Quantite, 
  idActivite) 
VALUES 
  ('MaterielActivite_'||nextval('s_MaterielActivite'), 
  'Materiel_2', 
  10, 
  'Activite_1');



CREATE OR REPLACE VIEW v_DetailActivite AS
  SELECT A.*,F.Designation as  nomFonctionnalite , S.* ,EA.Duree FROM Activite A 
  JOIN EmployeActivite EA ON (EA.idActivite=A.idActivite)
  JOIN Fonctionnalite F ON (F.idFonctionnalite=EA.idFonctionnalite)
  JOIN Salaire S ON (S.idFonctionnalite=EA.idFonctionnalite);

CREATE OR REPLACE VIEW v_TotaleMasokarena AS
  SELECT idActivite,SUM((duree*valeur)/TempsHeure) as somme FROM v_DetailActivite GROUP BY idActivite;  

/* nisy novaina*/
CREATE OR REPLACE VIEW v_Masokarena AS
  SELECT v.*,vt.somme,A.MargeBeneficiaire   FROM v_DetailActivite v 
  JOIN v_TotaleMasokarena vt ON (vt.idActivite=v.idActivite)
  JOIN Activite A ON (v.idActivite=A.idActivite);

CREATE OR REPLACE VIEW v_MaterielActivite AS
  SELECT MA.*,M.prixUnitaire FROM MaterielActivite MA JOIN Materiel M ON (MA.idMateriel=M.IdMateriel);

CREATE VIEW v_RM AS 
  SELECT sum(prixUnitaire*quantite) as somme ,idActivite FROM v_MaterielActivite v GROUP BY idActivite;

/* novaina */
  CREATE OR REPLACE VIEW v_DetailActiviteMateriel AS
    SELECT (M.prixUnitaire*Ma.Quantite) as prix, A.*, M.* ,MA.Quantite as quantite,RM.somme FROM Activite A 
    JOIN MaterielActivite MA ON (MA.idActivite=A.idActivite)
    JOIN Materiel M ON (M.idMateriel=Ma.idMateriel)
    JOIN v_RM RM ON (RM.idActivite=A.idActivite);

/* manomboka eto*/
ALTER TABLE Activite ADD COLUMN MargeBeneficiaire DOUBLE PRECISION;

UPDATE Activite SET MargeBeneficiaire=20;


/** nisy novaina **/
  create or replace view v_Benefice as
  SELECT A.idActivite,A.Designation ,((VR.somme+VTM.somme)*A.MargeBeneficiaire/100) as Benefice,(((VR.somme+VTM.somme)*A.MargeBeneficiaire/100)*A.MargeBeneficiaire)+((VR.somme+VTM.somme)*A.MargeBeneficiaire/100) as PVS,A.MargeBeneficiaire from Activite A 
  JOIN v_RM vr on (VR.idActivite=A.idActivite)
  JOIN v_TotaleMasokarena VTM on(VTM.idActivite=A.idActivite);


INSERT INTO Activite
  (idActivite, 
  Designation,MargeBeneficiaire) 
VALUES 
  ('Activite_'||nextval('s_Activite'), 
  'Impression',15);


  INSERT INTO Materiel
  (idMateriel, 
  Nom, 
  PrixUnitaire) 
VALUES 
  ('Materiel_'||nextval('s_Materiel'), 
  'Ancre', 
  '12000');


  INSERT INTO MaterielActivite
  (idMaterielActivite, 
  idMateriel, 
  Quantite, 

  idActivite) 
VALUES 
  ('MaterielActivite_'||nextval('s_MaterielActivite'), 
  'Materiel_3', 
  20, 
  'Activite_2');

  INSERT INTO EmployeActivite
  (idEmployeActivite,idActivite, 
  idFonctionnalite, 
  Duree) 
VALUES 
  ('EmployeActivite_'||nextval('s_EmployeActivite'),'Activite_2' ,
  'Fonctionnalite_4',
  20);

   INSERT INTO EmployeActivite
  (idEmployeActivite,idActivite, 
  idFonctionnalite, 
  Duree) 
VALUES 
  ('EmployeActivite_'||nextval('s_EmployeActivite'),'Activite_2' ,
  'Fonctionnalite_3',
  120);


/* update recent */
  CREATE TABLE prixBenefice (
  idPrixBenefice varchar(30) NOT NULL, 
  prixMin        double PRECISION NOT NULL, 
  prixMax        double PRECISION NOT NULL, 
  benefice       double PRECISION NOT NULL, 
  PRIMARY KEY (idPrixBenefice));

CREATE TABLE Produit (
  idProduit varchar(30) NOT NULL, 
  nom       varchar(50) NOT NULL, 
  prix      double PRECISION NOT NULL, 
  PRIMARY KEY (idProduit));

  CREATE SEQUENCE s_Produit INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
  CREATE SEQUENCE s_PrixBenefice INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;

create or replace view v_BeneficeProduit as
select p.* ,(pB.benefice*p.prix)/100 as benefice,((pB.benefice*p.prix)/100)+p.prix as prixConseille,pB.benefice as marge
from produit p 
join prixBenefice pB on (prix<prixMax and prix >= prixMin);

INSERT INTO Produit(idProduit, nom, prix) VALUES ('Produit_'||nextval('s_Produit'), 'papier', 12500);
INSERT INTO Produit(idProduit, nom, prix) VALUES ('Produit_'||nextval('s_Produit'), 'ancre', 20000);

INSERT INTO prixBenefice VALUES ('PrixBenefice_'||nextval('s_PrixBenefice'), 8000, 15000,20);
INSERT INTO prixBenefice VALUES ('PrixBenefice_'||nextval('s_PrixBenefice'), 15000, 21000,10);

CREATE SEQUENCE s_Facture INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_SousFacture INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_Client INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;
CREATE SEQUENCE s_FacturePaiement INCREMENT BY 1 MINVALUE 1 NO MAXVALUE START WITH 1;


CREATE TABLE Client (
  idClient varchar(30) NOT NULL, 
  Nom      varchar(50) NOT NULL, 
  PRIMARY KEY (idClient)
);
CREATE TABLE Facture (
  idFacture    varchar(30) NOT NULL, 
  idClient     varchar(30) NOT NULL, 
  DateFacture  date NOT NULL, 
  GrandTotal   DOUBLE PRECISION NOT NULL, 
  EtatPaiement int4 NOT NULL, 
  PRIMARY KEY (idFacture)
);
CREATE TABLE FacturePaiement (
  idFacturePaiement varchar(30) NOT NULL, 
  idFacture         varchar(30) NOT NULL, 
  MontantPaye       DOUBLE PRECISION NOT NULL, 
  DatePaiement      date NOT NULL, 
  PRIMARY KEY (idFacturePaiement)
);
CREATE TABLE SousFacture (
  idSousFacture varchar(30) NOT NULL, 
  idFacture     varchar(30) NOT NULL, 
  Designation   varchar(50) NOT NULL, 
  nombre        int4 NOT NULL, 
  SousTotal     DOUBLE PRECISION NOT NULL, 
  prixUnitaire  DOUBLE PRECISION NOT NULL, 
  remise        DOUBLE PRECISION NOT NULL, 
  PRIMARY KEY (idSousFacture)
);
ALTER TABLE Facture ADD CONSTRAINT FKFacture235398 FOREIGN KEY (idClient) REFERENCES Client (idClient);
ALTER TABLE FacturePaiement ADD CONSTRAINT FKFacturePai594672 FOREIGN KEY (idFacture) REFERENCES Facture (idFacture);
ALTER TABLE SousFacture ADD CONSTRAINT FKSousFactur813355 FOREIGN KEY (idFacture) REFERENCES Facture (idFacture);

INSERT INTO Client(idClient, Nom) VALUES ('Client_'||nextval('s_Client'), 'Karen');
INSERT INTO Client(idClient, Nom) VALUES ('Client_'||nextval('s_Client'), 'Mitantsoa');
INSERT INTO Client(idClient, Nom) VALUES ('Client_'||nextval('s_Client'), 'Megane');
INSERT INTO Client(idClient, Nom) VALUES ('Client_'||nextval('s_Client'), 'Antonio');



INSERT INTO Facture VALUES ('Test','Client_1',NOW,20000,1);

INSERT INTO FacturePaiement VALUES('gew','Test',15000,NOW());

CREATE OR REPLACE VIEW v_Facture AS
  SELECT F.*,
  C.Nom as NomClient ,
  CASE 
  WHEN SUM(FP.MontantPaye) is NULL THEN F.GrandTotal
  ELSE F.GrandTotal-SUM(FP.MontantPaye) 
  END
  as ResteAPaye,
  CASE 
  WHEN SUM(FP.MontantPaye) is NULL THEN 0
  ELSE SUM(FP.MontantPaye) 
  END
  as TotalPaye
  FROM Facture F LEFT JOIN FacturePaiement FP ON (F.idFacture=FP.idFacture) 
  JOIN Client C ON (F.idClient=C.idClient) GROUP BY F.idFacture,C.Nom;

ALTER TABLE Client ADD COLUMN DateNaissance Date;

UPDATE Client SET DateNaissance='2004-04-01' where idClient='Client_1';
UPDATE Client SET DateNaissance='2004-05-11' where idClient='Client_2';
UPDATE Client SET DateNaissance='2000-11-05' where idClient='Client_3';
UPDATE Client SET DateNaissance='2005-02-07' where idClient='Client_4';

ALTER TABLE Facture ADD COLUMN RemiseSurTotale DOUBLE PRECISION DEFAULT 0;
