-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 11 Mai 2018 à 09:57
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
-- Structure de la table `BienLai`
--

CREATE TABLE IF NOT EXISTS `BienLai` (
  `ID` int(11) NOT NULL,
  `Quan` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Phuong` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaCT` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaKH` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgayNhap` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Nam` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Thang` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Chiso` int(5) NOT NULL,
  `Sotien` int(25) NOT NULL,
  `ChuKy` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `BienLai`
--

INSERT INTO `BienLai` (`ID`, `Quan`, `Phuong`, `MaCT`, `MaKH`, `NgayNhap`, `Nam`, `Thang`, `Chiso`, `Sotien`, `ChuKy`) VALUES
(18, 'Cẩm lệ', 'Hòa Quý', 'CT1', 'KH1', '12/02/2008', '2008', '02', 50, 25, '200802'),
(19, 'Thanh Khê', 'Hòa Khê', 'CT2', 'KH2', '12/02/2008', '2008', '02', 60, 10, '200802'),
(20, 'Hải Châu', 'Bình Hiên', 'CT3', 'KH3', '02/05/2009', '2009', '05', 150, 250, '200905'),
(23, 'Ngũ Hành Sơn', 'Hòa Khánh Băc', 'CT4', 'KH4', '02/05/2010', '2010', '05', 120, 210, '201005'),
(24, 'Thanh Khê', 'Xuân Hà', 'CT5', 'KH5', '02/06/2011', '2011', '06', 23, 1200, '201106'),
(25, 'Liên Chiểu', 'Hòa Minh', 'CT6', 'KH6', '12/03/2013', '2013', '03', 15, 2500, '201303'),
(26, 'Cẩm Lệ', 'Hòa Quý', 'CT7', 'KH7', '12/11/2013', '2013', '11', 15, 1200, '201311'),
(27, 'Ngũ Hành Sơn ', 'Hòa Khánh Bắc', 'CT4', 'KH4', '02/05/2010', '2010', '05', 150, 46470, '201005'),
(28, 'Cẩm Lệ ', 'Hòa Quý', 'CT1', 'KH1', '12/04/2008', '2008', '04', 150, 154900, '200804'),
(29, 'Cẩm Lệ', 'Hòa Quý', 'CT1', 'KH1', '12/12/2008', '2009', '12', 175, 193625, '200901'),
(30, 'Cẩm Lệ ', 'Hòa Quý', 'CT1', 'KH1', '12/04/2008', '2008', '06', 175, 38725, '200806');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `BienLai`
--
ALTER TABLE `BienLai`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `BienLai`
--
ALTER TABLE `BienLai`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=31;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
