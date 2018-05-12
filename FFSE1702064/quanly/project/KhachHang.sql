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
-- Structure de la table `KhachHang`
--

CREATE TABLE IF NOT EXISTS `KhachHang` (
  `ID` int(5) NOT NULL,
  `MaKH` varchar(9) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TenKH` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Phone` int(12) NOT NULL,
  `Email` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Quan` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Phuong` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(35) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `MaCT` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `KhachHang`
--

INSERT INTO `KhachHang` (`ID`, `MaKH`, `TenKH`, `Phone`, `Email`, `Quan`, `Phuong`, `DiaChi`, `MaCT`) VALUES
(1, 'KH1', 'Nguyễn Văn B', 127894236, 'nguyenvana@gmail.com', 'Cẩm Lệ', 'Hòa Quý', '25 Hòa Quý', 'CT1'),
(2, 'KH2', 'Nguyễn Mạnh Dũng', 1259731678, 'Thenightblue0@gmail.com', 'Thanh Khê', 'Hòa Khê', '68 Hồ Nghinh', 'CT2'),
(4, 'KH3 ', 'Nguyễn Thị Nữ', 125648942, 'kh3@gmail.com', 'Hải Châu', 'Bình Hiên', '08 Bình Hiên ', 'CT3'),
(5, 'KH4', 'Nguyễn Văn A', 1259761521, 'nguyen@gmail.com', 'Ngũ Hành Sơn', 'Hòa Khánh Bắc', '38 Hòa Khánh Bắc', 'CT4'),
(6, 'KH5', 'Nguyễn Văn B', 127894236, 'nguyenvana@gmail.com', 'Thanh Khê', 'Xuân Hà', '21 Xuân Hà', 'CT5'),
(7, 'KH6 ', 'Nguyễn Thị C', 125678452, 'nguyenvana@gmail.com', 'Liên Chiểu', 'Hòa Minh', '42 Hòa Minh', 'CT6'),
(8, 'KH7 ', 'Nguyễn Công Tân', 91236548, 'thenightblue0@gmail.com', 'Cẩm Lệ', 'Hòa Quý', '02 Hòa Quý', 'CT7');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `KhachHang`
--
ALTER TABLE `KhachHang`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `KhachHang`
--
ALTER TABLE `KhachHang`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
