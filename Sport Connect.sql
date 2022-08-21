--
-- Base de données :  `SportConnect`
--

-- --------------------------------------------------------

--
-- Structure de la table `competiteur`
--

CREATE TABLE `competiteur` (
  `ID_COMPETITEUR` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `ID_EQUIPE` int(11) DEFAULT 0,
  `ID_VILLE` int(11) DEFAULT 0,
  `ID_SPORT` int(11) DEFAULT 0,
  `NOM` text,
  `PRENOM` text,
  `SEXE` varchar(30) DEFAULT "",
  `DATE_NAISSANCE` date DEFAULT NULL,
  `EMAIL` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `ID_COMPETITION` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `ID_SPORT` int(11) NOT NULL,
  `ID_VILLE` int(11) NOT NULL,
  `LIBELLE` text,
  `DATE_DEBUT` date DEFAULT NULL,
  `DATE_FIN` date DEFAULT NULL,
  `TYPE` text DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `ID_EMPLOYE` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `IDENTIFIANT` text,
  `MOT_DE_PASSE` text,
  `DATE_CREATION` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `ID_EQUIPE` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `ID_SPORT` int(11) NOT NULL,
  `ID_VILLE` int(11) NOT NULL,
  `NOM` text,
  `TYPE` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `inscription_equipe`
--

CREATE TABLE `inscription_equipe` (
  `ID_COMPETITION` int(11) NOT NULL,
  `ID_EQUIPE` int(11) NOT NULL,
  `DATE` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

CREATE TABLE `sport` (
  `ID_SPORT` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `LIBELLE` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `ID_VILLE` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `NOM` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `competiteur`
--
ALTER TABLE `competiteur`
  ADD UNIQUE KEY `COMPETITEUR_PK` (`ID_COMPETITEUR`),
  ADD KEY `APPARTIENT_A_FK` (`ID_EQUIPE`),
  ADD KEY `VIENS_DE_FK` (`ID_VILLE`),
  ADD KEY `PRATIQUE_FK` (`ID_SPORT`);

--
-- Index pour la table `competition`
--
ALTER TABLE `competition`
  ADD UNIQUE KEY `COMPETITION_PK` (`ID_COMPETITION`),
  ADD KEY `DE_FK` (`ID_SPORT`),
  ADD KEY `SE_DEROULE_A_FK` (`ID_VILLE`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD UNIQUE KEY `EMPLOYE_PK` (`ID_EMPLOYE`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD UNIQUE KEY `EQUIPE_PK` (`ID_EQUIPE`),
  ADD KEY `ES_SPECIALISEE_DANS_FK` (`ID_SPORT`),
  ADD KEY `RESIDE_FK` (`ID_VILLE`);

--
-- Index pour la table `inscription_equipe`
--
ALTER TABLE `inscription_equipe`
  ADD PRIMARY KEY (`ID_COMPETITION`,`ID_EQUIPE`),
  ADD UNIQUE KEY `INSCRIPTION_EQUIPE_PK` (`ID_COMPETITION`,`ID_EQUIPE`),
  ADD KEY `INSCRIPTION_EQUIPE_FK` (`ID_COMPETITION`),
  ADD KEY `INSCRIPTION_EQUIPE2_FK` (`ID_EQUIPE`);

--
-- Index pour la table `sport`
--
ALTER TABLE `sport`
  ADD UNIQUE KEY `SPORT_PK` (`ID_SPORT`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD UNIQUE KEY `VILLE_PK` (`ID_VILLE`);
COMMIT;

-- --------------------------------------------------------

--
-- Add Data
--
INSERT INTO sport (id_sport,libelle) 
VALUES (1,"Football"),
(2,"VTT"),
(3,"Basketball"),
(4,"Ping-Pong"),
(5,"Tenis"),
(6,"Volleyball");

INSERT INTO ville (id_ville,nom)
VALUES (1,"Paris"),
(2,"Gap"),
(3,"Digne"),
(4,"Toulouse"),
(5,"Tour"),
(6,"Strasbourg"),
(7,"Bordeau"),
(8,"Montpeliler"),
(9,"Lilles"),
(10,"Grenoble");

INSERT INTO equipe (id_equipe,nom,type,id_sport,id_ville)
VALUES (1,"Equipe1","mixte",1,5),
(2,"Equipe2","mixte",1,1),
(3,"Equipe3","femme",6,9),
(4,"Equipe4","homme",5,4),
(5,"Equipe5","homme",3,3);

INSERT INTO competiteur (id_competiteur, nom, prenom, sexe, date_naissance, email, id_equipe, id_ville, id_sport)
VALUES (1,"Realista","William","homme","1995-01-30", "william.realista@gmail.com",4,1,5),
(2,"Spitz", "Jonathan","homme","1973-03-03","jonathan.spitz@gmail.com",4,2,5),
(5,"Delais","Emily","femme","1064-03-08","emily.delais@gmail.com",3,7,6),
(6,"Bianco","Clarice","femme","2000-03-13","clarice.bianco@gmail.com",1,6,1),
(7,"Lantier","Luna","femme","1994-03-23","luna.lantier@gmail.com",1,5,1),
(8,"Simon","Leo","homme","2002-05-03","leo.simon@gmail.com",1,4,1),
(9,"Laporte","Angelo","homme","1995-05-13","angelo.laporte@gmail.com",1,8,1),
(10,"Marchand","Maxien","homme","1973-05-16","maxien.marchand@gmail.com",1,7,1),
(11,"Pascal","Stephane","homme","1973-06-18","stephane.pascal@gmail.com",1,9,1),
(12,"Moiron","Michael","homme","1993-06-28","michael.moiron@gmail.com",2,5,1),
(13,"Belgrand","Lily","femme","2000-07-14","lily.belgrand@gmail.com",2,2,1),
(14,"Verciny","Gladice","femme","2002-07-24","gladice.verciny@gmail.com",2,4,1),
(15,"Vassily","Emma","femme","1977-07-30","emma.vassily@gmail.com",2,6,1),
(17,"Cogne","Lucie","femme","1994-08-08","lucie.cogne@gmail.com",3,3,6),
(18,"Rivals","Nathan","homme","1973-08-23","nathan.rivals@gmail.com",5,1,3),
(19,"Loglisci","Antonin","homme","1995-09-24","antonin.loglisci@gmail.com",5,2,3);


INSERT INTO competiteur (id_competiteur, nom, prenom, sexe, date_naissance, email, id_ville, id_sport)
VALUES (3,"Germain","Anais","femme","1967-03-01","anais.germain@gmail.com",3,2),
(4,"Larzille","Orlane","femme","1977-03-06","orlane.larzille@gmail.com",1,4),
(16,"Comparin","Lise","femme","2002-07-31","lise.comparin@gmail.com",9,1),
(20,"Borie","Raphael","homme","2002-12-15","raphael.borie@gmail.com",6,3);

INSERT INTO competition (id_competition,libelle,date_debut,date_fin,type,id_sport,id_ville)
VALUES (1,"Competition1","2020-03-14","2020-03-15","mixte",1,1),
(2,"Competition2","2021-07-16","2021-07-19","homme",5,2),
(3,"Competition3","2022-08-03","2022-08-05","femme",6,9),
(4,"Competition4","2021-09-16","2021-09-17","homme",3,5);

INSERT INTO inscription_equipe (id_equipe,id_competition,date) 
VALUES (1,1,"2019-04-15"),(3,3,"2022-04-16"),(4,2,"2020-04-28"),(5,4,"2021-03-30");

INSERT INTO employe (ID_EMPLOYE,IDENTIFIANT,MOT_DE_PASSE,DATE_CREATION)
VALUES (1,"root","","2022-03-27"),(2,"tristan","","2022-05-09"),(3,"loane","","2022-05-09");

commit;