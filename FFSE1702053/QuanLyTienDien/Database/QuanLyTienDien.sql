-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 11, 2018 at 03:39 AM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QuanLyTienDien`
--

-- --------------------------------------------------------

--
-- Table structure for table `ffse1702053_BienLai`
--

CREATE TABLE IF NOT EXISTS `ffse1702053_BienLai` (
  `ID` int(11) NOT NULL,
  `MaKH` int(50) NOT NULL,
  `Ngay_Nhap` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Chu_Ky_Thang` int(50) NOT NULL,
  `Chu_Ky_Nam` int(100) NOT NULL,
  `Chi_So_CT` int(50) NOT NULL,
  `Chi_So_Cu` int(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse1702053_BienLai`
--

INSERT INTO `ffse1702053_BienLai` (`ID`, `MaKH`, `Ngay_Nhap`, `Chu_Ky_Thang`, `Chu_Ky_Nam`, `Chi_So_CT`, `Chi_So_Cu`) VALUES
(7, 2, '10/05/2018', 5, 2018, 123, 0),
(8, 1, '11/05/2018', 5, 2018, 200, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ffse1702053_KhachHang`
--

CREATE TABLE IF NOT EXISTS `ffse1702053_KhachHang` (
  `ID` int(11) NOT NULL,
  `HoTen` varchar(255) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `DiaChi` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Ma_Phuong` int(100) DEFAULT NULL,
  `Ma_Quan` int(100) DEFAULT NULL,
  `Email` text NOT NULL,
  `MaCongTo` text NOT NULL,
  `DienThoai` text NOT NULL,
  `MaKH` int(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse1702053_KhachHang`
--

INSERT INTO `ffse1702053_KhachHang` (`ID`, `HoTen`, `DiaChi`, `Ma_Phuong`, `Ma_Quan`, `Email`, `MaCongTo`, `DienThoai`, `MaKH`) VALUES
(1, 'nguyen van a', '124 , dường hung vuong,da nang ', 5, 1, 'hlocnd@gmail.com', 'MI1890', '01269661412', 1),
(2, 'nguyen van b', '244 ngo quyen, da nang', 1, 2, 'locns@gmail.com', 'MTRB11234', '012345678', 2),
(3, 'aaaaaaaa', 'bbbbbbbb', 3, 2, 'cccccccccccc', 'dddddd', '11233333', 3);

-- --------------------------------------------------------

--
-- Table structure for table `ffse1702053_Phuong`
--

CREATE TABLE IF NOT EXISTS `ffse1702053_Phuong` (
  `ID` int(11) NOT NULL,
  `ID_Quan` int(11) NOT NULL,
  `Phuong` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse1702053_Phuong`
--

INSERT INTO `ffse1702053_Phuong` (`ID`, `ID_Quan`, `Phuong`) VALUES
(1, 2, 'Hòa An'),
(2, 2, 'Hòa Phát'),
(3, 2, 'Hòa Xuân'),
(4, 2, 'Hòa Thọ Đông'),
(5, 1, 'Hải Châu 1'),
(6, 1, 'Hải Châu 2'),
(7, 1, 'Hòa Cường Bắc '),
(8, 1, 'Hòa Cường Nam'),
(9, 1, 'Nam Dương'),
(10, 3, 'An Hải Bắc'),
(11, 3, 'An Hải Đông'),
(12, 3, 'Mân Thái'),
(13, 3, 'Thọ Quang'),
(14, 3, 'Phước Mỹ'),
(15, 4, 'Hòa Hiệp Bắc'),
(16, 4, 'Hòa Hiệp Nam'),
(17, 4, 'Hòa Khánh Bắc'),
(18, 4, 'Hòa Minh'),
(19, 4, 'Hòa Khánh Nam');

-- --------------------------------------------------------

--
-- Table structure for table `ffse1702053_Quan`
--

CREATE TABLE IF NOT EXISTS `ffse1702053_Quan` (
  `ID` int(11) NOT NULL,
  `Quan` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse1702053_Quan`
--

INSERT INTO `ffse1702053_Quan` (`ID`, `Quan`) VALUES
(1, 'Hải Châu '),
(2, 'Cẩm lệ'),
(3, 'Sơn Trà '),
(4, 'Liên Chiêu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ffse1702053_BienLai`
--
ALTER TABLE `ffse1702053_BienLai`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ffse1702053_KhachHang`
--
ALTER TABLE `ffse1702053_KhachHang`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ffse1702053_Phuong`
--
ALTER TABLE `ffse1702053_Phuong`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ffse1702053_Quan`
--
ALTER TABLE `ffse1702053_Quan`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ffse1702053_BienLai`
--
ALTER TABLE `ffse1702053_BienLai`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `ffse1702053_KhachHang`
--
ALTER TABLE `ffse1702053_KhachHang`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ffse1702053_Phuong`
--
ALTER TABLE `ffse1702053_Phuong`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `ffse1702053_Quan`
--
ALTER TABLE `ffse1702053_Quan`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
