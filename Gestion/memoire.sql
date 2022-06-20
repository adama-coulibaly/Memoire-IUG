-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 13 juin 2022 à 10:59
-- Version du serveur : 10.4.19-MariaDB
-- Version de PHP : 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `memoire`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE `administrateur` (
  `IDadministrateur` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `passe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`IDadministrateur`, `nom`, `prenom`, `email`, `passe`) VALUES
(1, 'Coulibaly', 'Adama', 'adama@c.com', 'ca01');

-- --------------------------------------------------------

--
-- Structure de la table `apprenants`
--

CREATE TABLE `apprenants` (
  `IDapprenants` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sexe` varchar(25) NOT NULL,
  `date_naissance` date NOT NULL DEFAULT current_timestamp(),
  `telephone` int(25) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `profession` varchar(255) NOT NULL,
  `passe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `apprenants`
--

INSERT INTO `apprenants` (`IDapprenants`, `nom`, `prenom`, `email`, `sexe`, `date_naissance`, `telephone`, `adresse`, `profession`, `passe`) VALUES
(1, 'Coulibaly', 'Adama', 'adama@c.ml', 'homme', '2000-02-11', 50254015, 'Doumanzana', 'Etudiants', 'CoAd22'),
(2, 'karembé', 'Alpha', 'alpha@gmail.com', 'homme', '1999-05-28', 68784590, 'Moribabougou', 'Etudiants', 'kaAl22'),
(3, 'dirra', 'awa', 'adama@c.ml', 'femme', '2005-06-09', 66335426, 'Koulikoro', 'Etudiantes', 'diaw22');

-- --------------------------------------------------------

--
-- Structure de la table `formateurs`
--

CREATE TABLE `formateurs` (
  `IDformateurs` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` int(11) NOT NULL,
  `specialite` varchar(55) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `passe` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `formateurs`
--

INSERT INTO `formateurs` (`IDformateurs`, `nom`, `prenom`, `email`, `telephone`, `specialite`, `adresse`, `passe`) VALUES
(1, 'Sylla', 'Néné', 'sylla@nene.com', 78757410, 'C++', 'Hamdalaye ACI', 'SyNé22'),
(2, 'Moussoudou', 'Oumar', 'moussoudou@ouma.com', 68784590, 'java', 'Djelibougou', 'MoOu22'),
(3, 'Diallo', 'Ousmane', 'diallo@ousmane.ml', 66335426, 'Python', 'Koulikoro', 'DiOu22');

-- --------------------------------------------------------

--
-- Structure de la table `formations`
--

CREATE TABLE `formations` (
  `IDformations` int(11) NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `IDformateurs` int(11) NOT NULL,
  `IDmodule` int(11) NOT NULL,
  `IDsession` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `formations`
--

INSERT INTO `formations` (`IDformations`, `dateDebut`, `dateFin`, `IDformateurs`, `IDmodule`, `IDsession`) VALUES
(1, '2022-06-10', '2022-05-31', 1, 2, 1),
(2, '2022-06-10', '2022-06-21', 2, 3, 2),
(3, '2022-06-08', '2022-06-30', 3, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `IDinscription` int(11) NOT NULL,
  `IDformation` int(11) NOT NULL,
  `IDapprenants` int(11) NOT NULL,
  `dateInscription` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`IDinscription`, `IDformation`, `IDapprenants`, `dateInscription`) VALUES
(1, 1, 2, '2022-04-19'),
(2, 2, 5, '2022-04-05'),
(3, 12, 2, '2022-04-30'),
(4, 1, 2, '2022-06-08'),
(5, 5, 4, '2022-06-29'),
(6, 6, 4, '2022-06-05'),
(7, 1, 4, '2022-06-01'),
(8, 1, 4, '2022-06-03'),
(9, 1, 5, '2022-06-08'),
(10, 1, 7, '2022-06-03');

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `IDmodule` int(11) NOT NULL,
  `titre_du_module` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`IDmodule`, `titre_du_module`) VALUES
(1, 'C++'),
(2, 'Java EE'),
(3, 'Reseaux Informatiques');

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

CREATE TABLE `session` (
  `IDsession` int(11) NOT NULL,
  `date_debut_session` date NOT NULL,
  `date_fin_session` date NOT NULL,
  `numSession` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `session`
--

INSERT INTO `session` (`IDsession`, `date_debut_session`, `date_fin_session`, `numSession`) VALUES
(1, '2022-06-05', '2022-06-15', 'C001'),
(2, '2022-06-15', '2022-06-20', 'C002'),
(3, '2022-06-25', '2022-06-30', 'C003');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`IDadministrateur`);

--
-- Index pour la table `apprenants`
--
ALTER TABLE `apprenants`
  ADD PRIMARY KEY (`IDapprenants`);

--
-- Index pour la table `formateurs`
--
ALTER TABLE `formateurs`
  ADD PRIMARY KEY (`IDformateurs`);

--
-- Index pour la table `formations`
--
ALTER TABLE `formations`
  ADD PRIMARY KEY (`IDformations`),
  ADD KEY `IDformateurs` (`IDformateurs`),
  ADD KEY `IDmodule` (`IDmodule`),
  ADD KEY `codeSession` (`IDsession`);

--
-- Index pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`IDinscription`),
  ADD KEY `IDformations` (`IDformation`),
  ADD KEY `IDapprenants` (`IDapprenants`),
  ADD KEY `IDformations_2` (`IDformation`),
  ADD KEY `IDformations_3` (`IDformation`),
  ADD KEY `IDformations_4` (`IDformation`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`IDmodule`);

--
-- Index pour la table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`IDsession`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `administrateur`
--
ALTER TABLE `administrateur`
  MODIFY `IDadministrateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `apprenants`
--
ALTER TABLE `apprenants`
  MODIFY `IDapprenants` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `formateurs`
--
ALTER TABLE `formateurs`
  MODIFY `IDformateurs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `formations`
--
ALTER TABLE `formations`
  MODIFY `IDformations` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `IDinscription` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `module`
--
ALTER TABLE `module`
  MODIFY `IDmodule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `session`
--
ALTER TABLE `session`
  MODIFY `IDsession` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `formations`
--
ALTER TABLE `formations`
  ADD CONSTRAINT `formations_ibfk_1` FOREIGN KEY (`IDformateurs`) REFERENCES `formateurs` (`IDformateurs`),
  ADD CONSTRAINT `formations_ibfk_2` FOREIGN KEY (`IDsession`) REFERENCES `session` (`IDsession`),
  ADD CONSTRAINT `formations_ibfk_3` FOREIGN KEY (`IDmodule`) REFERENCES `module` (`IDmodule`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `inscription_ibfk_1` FOREIGN KEY (`IDapprenants`) REFERENCES `apprenants` (`IDapprenants`),
  ADD CONSTRAINT `inscription_ibfk_3` FOREIGN KEY (`IDformation`) REFERENCES `formations` (`IDformations`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
