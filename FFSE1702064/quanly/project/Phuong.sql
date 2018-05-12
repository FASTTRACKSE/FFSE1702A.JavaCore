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
-- Structure de la table `Phuong`
--

CREATE TABLE IF NOT EXISTS `Phuong` (
  `ID` int(11) NOT NULL,
  `TenPhuong` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaQuan` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Phuong`
--

INSERT INTO `Phuong` (`ID`, `TenPhuong`, `MaQuan`) VALUES
(1, 'Mân Thái', 1),
(2, 'Hòa Phát', 2),
(3, 'An Khê', 3),
(4, 'Bình Hiên', 4),
(5, 'Hòa Quý', 5),
(6, 'Hòa Khánh Bắc', 6),
(7, 'An Hải Bắc', 1),
(8, 'Bình Hiên', 2),
(9, 'Bình Thuận', 2),
(10, 'Thuận Phước', 2),
(12, 'Hòa Khê', 3),
(13, 'Xuân Hà', 3),
(14, 'Hòa Minh', 4),
(15, 'Hòa Hiệp Bắc', 4),
(16, 'Hòa Khánh Nam', 4),
(17, 'Hòa An', 5),
(18, 'Hòa Thọ Đông', 5),
(19, 'Hòa Thọ Tây', 5),
(20, 'Hòa Hải', 6),
(21, 'Khuê Mỹ', 6),
(22, 'Mỹ An', 6);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Phuong`
--
ALTER TABLE `Phuong`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Phuong`
--
ALTER TABLE `Phuong`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
