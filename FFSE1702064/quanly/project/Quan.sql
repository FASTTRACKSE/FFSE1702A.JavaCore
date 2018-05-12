-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 11 Mai 2018 à 09:58
-- Version du serveur :  5.6.30
-- Version de PHP :  5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `project`
--

-- --------------------------------------------------------

--
-- Structure de la table `Quan`
--

CREATE TABLE IF NOT EXISTS `Quan` (
  `ID` int(10) NOT NULL,
  `TenQuan` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaQuan` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Quan`
--

INSERT INTO `Quan` (`ID`, `TenQuan`, `MaQuan`) VALUES
(1, 'Sơn Trà', 1),
(2, 'Hải Châu', 2),
(3, 'Thanh Khê', 3),
(4, 'Liên Chiểu', 4),
(5, 'Cẩm Lệ', 5),
(6, 'Ngũ Hành Sơn', 6);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Quan`
--
ALTER TABLE `Quan`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Quan`
--
ALTER TABLE `Quan`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
