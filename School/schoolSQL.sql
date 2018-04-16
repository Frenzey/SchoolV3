-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  Dim 15 avr. 2018 à 14:41
-- Version du serveur :  5.6.38
-- Version de PHP :  7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `schoolSQL`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL,
  `individus_idindividus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `affectations`
--

CREATE TABLE `affectations` (
  `idAffectation` int(11) NOT NULL,
  `loginAffectation` varchar(45) DEFAULT NULL,
  `motPasseAffectation` varchar(45) DEFAULT NULL,
  `dateEntrAffectation` varchar(45) DEFAULT NULL,
  `datesortAffectation` varchar(45) DEFAULT NULL,
  `referentAffectation` varchar(45) DEFAULT NULL,
  `validAffectation` tinyint(1) DEFAULT NULL,
  `contrats_idContrat` int(11) NOT NULL,
  `individus_idindividus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `affectations`
--

INSERT INTO `affectations` (`idAffectation`, `loginAffectation`, `motPasseAffectation`, `dateEntrAffectation`, `datesortAffectation`, `referentAffectation`, `validAffectation`, `contrats_idContrat`, `individus_idindividus`) VALUES
(1, 'jejk.fr', '14/04/2018', '18/04/2018', '26/04/2018', 'ADMIN', 0, 2, 12),
(6, 'ded.ded', '20/04/2018', '20/04/2018', '26/04/2018', 'ADMIN', 0, 3, 17);

-- --------------------------------------------------------

--
-- Structure de la table `assiduite`
--

CREATE TABLE `assiduite` (
  `idAssiduite` int(11) NOT NULL,
  `presence` tinyint(4) DEFAULT NULL,
  `evalution_idEvalution` int(11) NOT NULL,
  `evalution_groupes_has_etudiants_groupes_idGroupe` int(11) NOT NULL,
  `evalution_groupes_has_etudiants_groupes_sessions_idsessions` int(11) NOT NULL,
  `evalution_groupes_has_etudiants_etudiants_idEtudiant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `auth`
--

CREATE TABLE `auth` (
  `ID` int(11) NOT NULL,
  `user` varchar(25) NOT NULL,
  `pass` varchar(25) NOT NULL,
  `level` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `auth`
--

INSERT INTO `auth` (`ID`, `user`, `pass`, `level`) VALUES
(1, 'admin', 'admin', 1),
(4, 'jay', 'jay', 1),
(5, 'ded.ded', '20/04/2018', 5);

-- --------------------------------------------------------

--
-- Structure de la table `authentification`
--

CREATE TABLE `authentification` (
  `idAuthentification` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `competences`
--

CREATE TABLE `competences` (
  `matieres_idMatiere` int(11) NOT NULL,
  `enseignants_idEnseignant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `comptable`
--

CREATE TABLE `comptable` (
  `idComptable` int(11) NOT NULL,
  `individus_idindividus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `contrats`
--

CREATE TABLE `contrats` (
  `idContrat` int(11) NOT NULL,
  `libelContrat` varchar(45) DEFAULT NULL,
  `dateEntrContrat` varchar(45) DEFAULT NULL,
  `datesortContrat` varchar(45) DEFAULT NULL,
  `salaireContrat` varchar(4) DEFAULT NULL,
  `indemniteContrat` float DEFAULT NULL,
  `contratcol` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `contrats`
--

INSERT INTO `contrats` (`idContrat`, `libelContrat`, `dateEntrContrat`, `datesortContrat`, `salaireContrat`, `indemniteContrat`, `contratcol`) VALUES
(1, '', 'date 1', 'date 2', NULL, NULL, NULL),
(2, '', 'date 1', 'date 2', NULL, NULL, NULL),
(3, 'Etudiant', 'date 1', 'date 1', '0', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `Cours`
--

CREATE TABLE `Cours` (
  `idCours` int(11) NOT NULL,
  `libelCours` varchar(45) DEFAULT NULL,
  `niveauCours` int(11) DEFAULT NULL,
  `matieres_idMatiere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `directeur`
--

CREATE TABLE `directeur` (
  `idDirecteur` int(11) NOT NULL,
  `idindividus` int(11) DEFAULT NULL,
  `individus_idindividus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `enseignants`
--

CREATE TABLE `enseignants` (
  `idEnseignant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

CREATE TABLE `etudiants` (
  `idEtudiant` int(11) NOT NULL,
  `individus_idindividus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiants`
--

INSERT INTO `etudiants` (`idEtudiant`, `individus_idindividus`) VALUES
(1, 1),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17);

-- --------------------------------------------------------

--
-- Structure de la table `evalution`
--

CREATE TABLE `evalution` (
  `idEvalution` int(11) NOT NULL,
  `groupes_has_etudiants_groupes_idGroupe` int(11) NOT NULL,
  `groupes_has_etudiants_groupes_sessions_idsessions` int(11) NOT NULL,
  `groupes_has_etudiants_etudiants_idEtudiant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `exam`
--

CREATE TABLE `exam` (
  `idExam` int(11) NOT NULL,
  `evalution_idEvalution` int(11) NOT NULL,
  `evalution_groupes_has_etudiants_groupes_idGroupe` int(11) NOT NULL,
  `evalution_groupes_has_etudiants_groupes_sessions_idsessions` int(11) NOT NULL,
  `evalution_groupes_has_etudiants_etudiants_idEtudiant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `groupes`
--

CREATE TABLE `groupes` (
  `idGroupe` int(11) NOT NULL,
  `libelGroupe` varchar(45) DEFAULT NULL,
  `sessions_idsessions` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `groupes_has_etudiants`
--

CREATE TABLE `groupes_has_etudiants` (
  `groupes_idGroupe` int(11) NOT NULL,
  `groupes_sessions_idsessions` int(11) NOT NULL,
  `etudiants_idEtudiant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `horaires`
--

CREATE TABLE `horaires` (
  `idHoraires` int(11) NOT NULL,
  `libelHorraire` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `individus`
--

CREATE TABLE `individus` (
  `idindividus` int(11) NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `datedenaissance` varchar(45) DEFAULT NULL,
  `lieudenaissance` varchar(45) DEFAULT NULL,
  `telephoneFixe` varchar(45) DEFAULT NULL,
  `telephoneMobile` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `individus`
--

INSERT INTO `individus` (`idindividus`, `nom`, `prenom`, `genre`, `adresse`, `datedenaissance`, `lieudenaissance`, `telephoneFixe`, `telephoneMobile`) VALUES
(1, 'sundara', 'jay', 'H', '9 AVENE HS', '08/09/1994', 'JUVISY', '0100000000', '0600000000'),
(11, 'dzz', 'de', 'H', 'de', '20/04/2018', 'ded', 'de', 'de'),
(12, 'jejk', 'fr', 'H', 'fr', '14/04/2018', 'fr', 'fr', 'fr'),
(13, 'jay', 'de', 'H', 'de', '12/04/2018', 'de', 'de', 'de'),
(14, 'jay', 'jay', 'H', 'dz', '20/04/2018', 'ja', 'dz', 'dz'),
(15, 'hej', 'fe', 'F', 'fe', '14/04/2018', 'fe', 'fe', 'fe'),
(16, 'de', 'de', 'H', 'de', '12/04/2018', 'ded', 'de', 'de'),
(17, 'ded', 'ded', 'H', 'de', '20/04/2018', 'de', 'ed', 'de');

-- --------------------------------------------------------

--
-- Structure de la table `materiels`
--

CREATE TABLE `materiels` (
  `idMateriel` int(11) NOT NULL,
  `libelMateriel` varchar(45) DEFAULT NULL,
  `prixMateriel` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `matieres`
--

CREATE TABLE `matieres` (
  `idMatiere` int(11) NOT NULL,
  `libelMatiere` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `paiements`
--

CREATE TABLE `paiements` (
  `idPaiement` int(11) NOT NULL,
  `idTarifs` int(11) DEFAULT NULL,
  `datePaiement` date DEFAULT NULL,
  `montantPaiement` float DEFAULT NULL,
  `modePaiement` varchar(45) DEFAULT NULL,
  `affectations_idAffectation` int(11) NOT NULL,
  `affectations_contrats_idContrat` int(11) NOT NULL,
  `etudiants_idEtudiant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `salles`
--

CREATE TABLE `salles` (
  `idSalles` int(11) NOT NULL,
  `libelsalles` varchar(45) DEFAULT NULL,
  `capasalles` int(11) DEFAULT NULL,
  `disposalles` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `seances`
--

CREATE TABLE `seances` (
  `idseances` int(11) NOT NULL,
  `Cours_idCours` int(11) NOT NULL,
  `Cours_matieres_idMatiere` int(11) NOT NULL,
  `salles_idsalles` int(11) NOT NULL,
  `groupes_idGroupe` int(11) NOT NULL,
  `horaires_idHoraires` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `secretaire`
--

CREATE TABLE `secretaire` (
  `idSecretaire` int(11) NOT NULL,
  `individus_idindividus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sessions`
--

CREATE TABLE `sessions` (
  `idSessions` int(11) NOT NULL,
  `annéeSession` int(11) DEFAULT NULL,
  `libelSession` varchar(45) DEFAULT NULL,
  `datedebutSession` date DEFAULT NULL,
  `datefinSession` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `paiements_idPaiement` int(11) NOT NULL,
  `paiements_affectations_idAffectation` int(11) NOT NULL,
  `paiements_affectations_contrats_idContrat` int(11) NOT NULL,
  `materiels_idmateriels` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`),
  ADD KEY `fk_admin_individus1_idx` (`individus_idindividus`);

--
-- Index pour la table `affectations`
--
ALTER TABLE `affectations`
  ADD PRIMARY KEY (`idAffectation`,`contrats_idContrat`,`individus_idindividus`),
  ADD KEY `fk_affectations_contrats1_idx` (`contrats_idContrat`),
  ADD KEY `fk_affectations_individus1_idx` (`individus_idindividus`);

--
-- Index pour la table `assiduite`
--
ALTER TABLE `assiduite`
  ADD PRIMARY KEY (`idAssiduite`,`evalution_idEvalution`,`evalution_groupes_has_etudiants_groupes_idGroupe`,`evalution_groupes_has_etudiants_groupes_sessions_idsessions`,`evalution_groupes_has_etudiants_etudiants_idEtudiant`),
  ADD KEY `fk_assiduite_evalution1_idx` (`evalution_idEvalution`,`evalution_groupes_has_etudiants_groupes_idGroupe`,`evalution_groupes_has_etudiants_groupes_sessions_idsessions`,`evalution_groupes_has_etudiants_etudiants_idEtudiant`);

--
-- Index pour la table `auth`
--
ALTER TABLE `auth`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `user` (`user`);

--
-- Index pour la table `authentification`
--
ALTER TABLE `authentification`
  ADD PRIMARY KEY (`idAuthentification`);

--
-- Index pour la table `competences`
--
ALTER TABLE `competences`
  ADD PRIMARY KEY (`matieres_idMatiere`,`enseignants_idEnseignant`),
  ADD KEY `fk_matieres_has_enseignants_enseignants1_idx` (`enseignants_idEnseignant`),
  ADD KEY `fk_matieres_has_enseignants_matieres1_idx` (`matieres_idMatiere`);

--
-- Index pour la table `comptable`
--
ALTER TABLE `comptable`
  ADD PRIMARY KEY (`idComptable`,`individus_idindividus`),
  ADD KEY `fk_comptable_individus1_idx` (`individus_idindividus`);

--
-- Index pour la table `contrats`
--
ALTER TABLE `contrats`
  ADD PRIMARY KEY (`idContrat`);

--
-- Index pour la table `Cours`
--
ALTER TABLE `Cours`
  ADD PRIMARY KEY (`idCours`,`matieres_idMatiere`),
  ADD KEY `fk_Cours_matieres1_idx` (`matieres_idMatiere`);

--
-- Index pour la table `directeur`
--
ALTER TABLE `directeur`
  ADD PRIMARY KEY (`idDirecteur`),
  ADD KEY `fk_directeur_individus1_idx` (`individus_idindividus`);

--
-- Index pour la table `enseignants`
--
ALTER TABLE `enseignants`
  ADD PRIMARY KEY (`idEnseignant`);

--
-- Index pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD PRIMARY KEY (`idEtudiant`,`individus_idindividus`),
  ADD KEY `fk_etudiants_individus1_idx` (`individus_idindividus`);

--
-- Index pour la table `evalution`
--
ALTER TABLE `evalution`
  ADD PRIMARY KEY (`idEvalution`,`groupes_has_etudiants_groupes_idGroupe`,`groupes_has_etudiants_groupes_sessions_idsessions`,`groupes_has_etudiants_etudiants_idEtudiant`),
  ADD KEY `fk_evalution_groupes_has_etudiants1_idx` (`groupes_has_etudiants_groupes_idGroupe`,`groupes_has_etudiants_groupes_sessions_idsessions`,`groupes_has_etudiants_etudiants_idEtudiant`);

--
-- Index pour la table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`idExam`,`evalution_idEvalution`,`evalution_groupes_has_etudiants_groupes_idGroupe`,`evalution_groupes_has_etudiants_groupes_sessions_idsessions`,`evalution_groupes_has_etudiants_etudiants_idEtudiant`),
  ADD KEY `fk_exam_evalution1_idx` (`evalution_idEvalution`,`evalution_groupes_has_etudiants_groupes_idGroupe`,`evalution_groupes_has_etudiants_groupes_sessions_idsessions`,`evalution_groupes_has_etudiants_etudiants_idEtudiant`);

--
-- Index pour la table `groupes`
--
ALTER TABLE `groupes`
  ADD PRIMARY KEY (`idGroupe`,`sessions_idsessions`),
  ADD KEY `fk_groupes_sessions1_idx` (`sessions_idsessions`);

--
-- Index pour la table `groupes_has_etudiants`
--
ALTER TABLE `groupes_has_etudiants`
  ADD PRIMARY KEY (`groupes_idGroupe`,`groupes_sessions_idsessions`,`etudiants_idEtudiant`),
  ADD KEY `fk_groupes_has_etudiants_etudiants1_idx` (`etudiants_idEtudiant`),
  ADD KEY `fk_groupes_has_etudiants_groupes1_idx` (`groupes_idGroupe`,`groupes_sessions_idsessions`);

--
-- Index pour la table `horaires`
--
ALTER TABLE `horaires`
  ADD PRIMARY KEY (`idHoraires`);

--
-- Index pour la table `individus`
--
ALTER TABLE `individus`
  ADD PRIMARY KEY (`idindividus`);

--
-- Index pour la table `materiels`
--
ALTER TABLE `materiels`
  ADD PRIMARY KEY (`idMateriel`);

--
-- Index pour la table `matieres`
--
ALTER TABLE `matieres`
  ADD PRIMARY KEY (`idMatiere`);

--
-- Index pour la table `paiements`
--
ALTER TABLE `paiements`
  ADD PRIMARY KEY (`idPaiement`,`affectations_idAffectation`,`affectations_contrats_idContrat`,`etudiants_idEtudiant`),
  ADD KEY `fk_paiements_etudiants1_idx` (`etudiants_idEtudiant`);

--
-- Index pour la table `salles`
--
ALTER TABLE `salles`
  ADD PRIMARY KEY (`idSalles`);

--
-- Index pour la table `seances`
--
ALTER TABLE `seances`
  ADD PRIMARY KEY (`idseances`,`Cours_idCours`,`Cours_matieres_idMatiere`,`salles_idsalles`,`groupes_idGroupe`,`horaires_idHoraires`),
  ADD KEY `fk_seances_Cours1_idx` (`Cours_idCours`,`Cours_matieres_idMatiere`),
  ADD KEY `fk_seances_salles1_idx` (`salles_idsalles`),
  ADD KEY `fk_seances_groupes1_idx` (`groupes_idGroupe`),
  ADD KEY `fk_seances_horaires1_idx` (`horaires_idHoraires`);

--
-- Index pour la table `secretaire`
--
ALTER TABLE `secretaire`
  ADD PRIMARY KEY (`idSecretaire`),
  ADD KEY `fk_secretaire_individus1_idx` (`individus_idindividus`);

--
-- Index pour la table `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`idSessions`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`paiements_idPaiement`,`paiements_affectations_idAffectation`,`paiements_affectations_contrats_idContrat`,`materiels_idmateriels`),
  ADD KEY `fk_paiements_has_materiels_materiels1_idx` (`materiels_idmateriels`),
  ADD KEY `fk_paiements_has_materiels_paiements1_idx` (`paiements_idPaiement`,`paiements_affectations_idAffectation`,`paiements_affectations_contrats_idContrat`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `affectations`
--
ALTER TABLE `affectations`
  MODIFY `idAffectation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `assiduite`
--
ALTER TABLE `assiduite`
  MODIFY `idAssiduite` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `auth`
--
ALTER TABLE `auth`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `authentification`
--
ALTER TABLE `authentification`
  MODIFY `idAuthentification` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `comptable`
--
ALTER TABLE `comptable`
  MODIFY `idComptable` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `contrats`
--
ALTER TABLE `contrats`
  MODIFY `idContrat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `Cours`
--
ALTER TABLE `Cours`
  MODIFY `idCours` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `directeur`
--
ALTER TABLE `directeur`
  MODIFY `idDirecteur` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `enseignants`
--
ALTER TABLE `enseignants`
  MODIFY `idEnseignant` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `etudiants`
--
ALTER TABLE `etudiants`
  MODIFY `idEtudiant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `evalution`
--
ALTER TABLE `evalution`
  MODIFY `idEvalution` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `exam`
--
ALTER TABLE `exam`
  MODIFY `idExam` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `groupes`
--
ALTER TABLE `groupes`
  MODIFY `idGroupe` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `horaires`
--
ALTER TABLE `horaires`
  MODIFY `idHoraires` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `individus`
--
ALTER TABLE `individus`
  MODIFY `idindividus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `materiels`
--
ALTER TABLE `materiels`
  MODIFY `idMateriel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `matieres`
--
ALTER TABLE `matieres`
  MODIFY `idMatiere` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `paiements`
--
ALTER TABLE `paiements`
  MODIFY `idPaiement` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `salles`
--
ALTER TABLE `salles`
  MODIFY `idSalles` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `seances`
--
ALTER TABLE `seances`
  MODIFY `idseances` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `secretaire`
--
ALTER TABLE `secretaire`
  MODIFY `idSecretaire` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `sessions`
--
ALTER TABLE `sessions`
  MODIFY `idSessions` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_individus1` FOREIGN KEY (`individus_idindividus`) REFERENCES `individus` (`idindividus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `affectations`
--
ALTER TABLE `affectations`
  ADD CONSTRAINT `fk_affectations_contrats1` FOREIGN KEY (`contrats_idContrat`) REFERENCES `contrats` (`idContrat`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_affectations_individus1` FOREIGN KEY (`individus_idindividus`) REFERENCES `individus` (`idindividus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `assiduite`
--
ALTER TABLE `assiduite`
  ADD CONSTRAINT `fk_assiduite_evalution1` FOREIGN KEY (`evalution_idEvalution`,`evalution_groupes_has_etudiants_groupes_idGroupe`,`evalution_groupes_has_etudiants_groupes_sessions_idsessions`,`evalution_groupes_has_etudiants_etudiants_idEtudiant`) REFERENCES `evalution` (`idEvalution`, `groupes_has_etudiants_groupes_idGroupe`, `groupes_has_etudiants_groupes_sessions_idsessions`, `groupes_has_etudiants_etudiants_idEtudiant`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `competences`
--
ALTER TABLE `competences`
  ADD CONSTRAINT `fk_matieres_has_enseignants_enseignants1` FOREIGN KEY (`enseignants_idEnseignant`) REFERENCES `enseignants` (`idEnseignant`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_matieres_has_enseignants_matieres1` FOREIGN KEY (`matieres_idMatiere`) REFERENCES `matieres` (`idMatiere`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `comptable`
--
ALTER TABLE `comptable`
  ADD CONSTRAINT `fk_comptable_individus1` FOREIGN KEY (`individus_idindividus`) REFERENCES `individus` (`idindividus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Cours`
--
ALTER TABLE `Cours`
  ADD CONSTRAINT `fk_Cours_matieres1` FOREIGN KEY (`matieres_idMatiere`) REFERENCES `matieres` (`idMatiere`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `directeur`
--
ALTER TABLE `directeur`
  ADD CONSTRAINT `fk_directeur_individus1` FOREIGN KEY (`individus_idindividus`) REFERENCES `individus` (`idindividus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD CONSTRAINT `fk_etudiants_individus1` FOREIGN KEY (`individus_idindividus`) REFERENCES `individus` (`idindividus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `evalution`
--
ALTER TABLE `evalution`
  ADD CONSTRAINT `fk_evalution_groupes_has_etudiants1` FOREIGN KEY (`groupes_has_etudiants_groupes_idGroupe`,`groupes_has_etudiants_groupes_sessions_idsessions`,`groupes_has_etudiants_etudiants_idEtudiant`) REFERENCES `groupes_has_etudiants` (`groupes_idGroupe`, `groupes_sessions_idsessions`, `etudiants_idEtudiant`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `fk_exam_evalution1` FOREIGN KEY (`evalution_idEvalution`,`evalution_groupes_has_etudiants_groupes_idGroupe`,`evalution_groupes_has_etudiants_groupes_sessions_idsessions`,`evalution_groupes_has_etudiants_etudiants_idEtudiant`) REFERENCES `evalution` (`idEvalution`, `groupes_has_etudiants_groupes_idGroupe`, `groupes_has_etudiants_groupes_sessions_idsessions`, `groupes_has_etudiants_etudiants_idEtudiant`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `groupes`
--
ALTER TABLE `groupes`
  ADD CONSTRAINT `fk_groupes_sessions1` FOREIGN KEY (`sessions_idsessions`) REFERENCES `sessions` (`idSessions`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `groupes_has_etudiants`
--
ALTER TABLE `groupes_has_etudiants`
  ADD CONSTRAINT `fk_groupes_has_etudiants_etudiants1` FOREIGN KEY (`etudiants_idEtudiant`) REFERENCES `etudiants` (`idEtudiant`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_groupes_has_etudiants_groupes1` FOREIGN KEY (`groupes_idGroupe`,`groupes_sessions_idsessions`) REFERENCES `groupes` (`idGroupe`, `sessions_idsessions`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `paiements`
--
ALTER TABLE `paiements`
  ADD CONSTRAINT `fk_paiements_etudiants1` FOREIGN KEY (`etudiants_idEtudiant`) REFERENCES `etudiants` (`idEtudiant`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `seances`
--
ALTER TABLE `seances`
  ADD CONSTRAINT `fk_seances_Cours1` FOREIGN KEY (`Cours_idCours`,`Cours_matieres_idMatiere`) REFERENCES `Cours` (`idCours`, `matieres_idMatiere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_seances_groupes1` FOREIGN KEY (`groupes_idGroupe`) REFERENCES `groupes` (`idGroupe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_seances_horaires1` FOREIGN KEY (`horaires_idHoraires`) REFERENCES `horaires` (`idHoraires`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_seances_salles1` FOREIGN KEY (`salles_idsalles`) REFERENCES `salles` (`idSalles`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `secretaire`
--
ALTER TABLE `secretaire`
  ADD CONSTRAINT `fk_secretaire_individus1` FOREIGN KEY (`individus_idindividus`) REFERENCES `individus` (`idindividus`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `vente`
--
ALTER TABLE `vente`
  ADD CONSTRAINT `fk_paiements_has_materiels_materiels1` FOREIGN KEY (`materiels_idmateriels`) REFERENCES `materiels` (`idMateriel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_paiements_has_materiels_paiements1` FOREIGN KEY (`paiements_idPaiement`,`paiements_affectations_idAffectation`,`paiements_affectations_contrats_idContrat`) REFERENCES `paiements` (`idPaiement`, `affectations_idAffectation`, `affectations_contrats_idContrat`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
