-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2018 at 11:09 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appcuatoi`
--

-- --------------------------------------------------------

--
-- Table structure for table `phuongxa`
--

CREATE TABLE `phuongxa` (
  `Id_phuong` int(11) NOT NULL,
  `Id_quanphuong` int(11) NOT NULL,
  `Name_phuong` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `phuongxa`
--

INSERT INTO `phuongxa` (`Id_phuong`, `Id_quanphuong`, `Name_phuong`) VALUES
(1, 1, 'Khuê Trung'),
(2, 1, 'Hòa Thọ Tây'),
(3, 1, 'Hòa Thọ Đông'),
(4, 1, 'Hòa Xuân'),
(5, 1, 'Hòa An'),
(6, 1, 'Hòa Phát'),
(7, 2, 'An Khê'),
(8, 2, 'Thanh Khê Đông'),
(9, 2, 'Xuân Hà'),
(10, 2, 'Tam Thuận'),
(11, 2, 'Tân Chính'),
(12, 2, 'Thạc Gían'),
(13, 2, 'Chính Gián'),
(14, 2, 'Hòa Khê'),
(15, 2, 'Vĩnh Trung'),
(16, 2, 'Thanh Khê Tây'),
(17, 3, 'An Hải Bắc'),
(18, 3, 'An Hải Đông'),
(19, 3, 'An Hải Tây'),
(20, 3, 'Mân Thái'),
(21, 3, 'Nại Hiên Đông'),
(22, 3, 'Phước Mỹ'),
(23, 3, 'Thọ Quang'),
(24, 4, 'Hòa Bắc'),
(25, 4, 'Hòa Châu'),
(26, 4, 'Hòa Khương'),
(27, 4, 'Hòa Liên'),
(28, 4, 'Hòa Nhơn'),
(29, 4, 'Hòa Ninh'),
(30, 4, 'Hòa Phong'),
(31, 4, 'Hòa Phú'),
(32, 4, 'Hòa Phước'),
(33, 4, 'Hòa Tiến'),
(34, 5, 'Bình Hiên'),
(35, 5, 'Bình Thuận'),
(36, 5, 'Hòa Cường Bắc'),
(37, 5, 'Hòa Cường Nam'),
(38, 5, 'Hoà Thuận Đông'),
(39, 5, 'Hòa Thuận Tây'),
(40, 5, 'Phước Ninh'),
(41, 5, 'Nam Dương'),
(42, 6, 'Hòa Hiệp Bắc'),
(43, 6, 'Hòa Hiệp Nam'),
(44, 6, 'Hòa Khánh Bắc'),
(45, 6, 'Hòa Khánh Nam'),
(46, 6, 'Hòa Minh'),
(47, 7, 'Hòa Hải'),
(48, 7, 'Hòa Qúy'),
(49, 7, 'Khuê Mỹ'),
(50, 7, 'Mỹ An');

-- --------------------------------------------------------

--
-- Table structure for table `qlbl`
--

CREATE TABLE `qlbl` (
  `Id_BL` int(11) NOT NULL,
  `MaCT` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Ngay_Nhap` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Chu_Ky_Month` int(11) NOT NULL,
  `Chu_Ky_Year` int(11) NOT NULL,
  `Chi_So_CT` int(11) NOT NULL,
  `Chi_So_Cu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `qlbl`
--

INSERT INTO `qlbl` (`Id_BL`, `MaCT`, `Ngay_Nhap`, `Chu_Ky_Month`, `Chu_Ky_Year`, `Chi_So_CT`, `Chi_So_Cu`) VALUES
(8, '1AA', '16/01/2018', 1, 2018, 127, 0),
(9, '1AA', '16/02/2018', 2, 2018, 267, 127),
(10, '1BB', '16/01/2018', 1, 2018, 234, 0),
(13, '1AA', '16/03/2018', 3, 2018, 463, 267),
(15, '1AA', '17/04/2018', 4, 2018, 569, 463),
(16, '1AA', '17/05/2018', 5, 2018, 676, 569),
(39, '1D', '01/12/2016', 12, 2016, 123, 0),
(40, '1D', '03/01/2017', 1, 2017, 235, 0),
(41, '1HH', '09/01/2018', 1, 2018, 123, 0),
(42, '1HH', '13/02/2018', 2, 2018, 311, 123);

-- --------------------------------------------------------

--
-- Table structure for table `qlkh`
--

CREATE TABLE `qlkh` (
  `Id_KH` int(11) NOT NULL,
  `MaKH` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `MaCT` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Quan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Phuong` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Pass` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `qlkh`
--

INSERT INTO `qlkh` (`Id_KH`, `MaKH`, `MaCT`, `Name`, `DiaChi`, `Quan`, `Phuong`, `Email`, `Phone`, `Pass`) VALUES
(7, '1A', '1AA', 'trang le', 'số 3 An Hò 4', 'Cẩm Lệ', 'Khuê Trung', 'trang@gmail.com', '01838569', '1234567'),
(8, '1B', '1BB', 'minh ngọc', '4 minh hi', 'Cẩm Lệ', 'Hòa Thọ Tây', 'ngojcminh@gmai', '0849746', '123123'),
(9, '1DD', '1D', 'minh hoàng', 'uhfkwf', 'Hòa Vang', 'Hòa Bắc', 'hoangftrfh@gmail.com', '9876957', '123123'),
(14, '1C', '1CC', 'anh kiet', 'feew', 'Hải Châu', 'Bình Hiên', 'chau@gmail.com', '5635345', '123123'),
(15, '1E', '1EE', 'van bo', 'fseeef', 'Hải Châu', 'Bình Hiên', 'chau@gmail.com', '09876543', '123123'),
(16, '1H', '1HH', 'minh hằng', 'minh tu', 'Hải Châu', 'Bình Hiên', 'hang@gmail.com', '097857937', '123123');

-- --------------------------------------------------------

--
-- Table structure for table `quanuy`
--

CREATE TABLE `quanuy` (
  `Id_quan` int(11) NOT NULL,
  `Name_quan` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `quanuy`
--

INSERT INTO `quanuy` (`Id_quan`, `Name_quan`) VALUES
(1, 'Cẩm Lệ'),
(2, 'Thanh Khê'),
(3, 'Sơn Trà'),
(4, 'Hòa Vang'),
(5, 'Hải Châu'),
(6, 'Liên Chiểu'),
(7, 'Ngũ Hành Sơn');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `phuongxa`
--
ALTER TABLE `phuongxa`
  ADD PRIMARY KEY (`Id_phuong`);

--
-- Indexes for table `qlbl`
--
ALTER TABLE `qlbl`
  ADD PRIMARY KEY (`Id_BL`);

--
-- Indexes for table `qlkh`
--
ALTER TABLE `qlkh`
  ADD PRIMARY KEY (`Id_KH`,`MaCT`) USING BTREE;

--
-- Indexes for table `quanuy`
--
ALTER TABLE `quanuy`
  ADD PRIMARY KEY (`Id_quan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `phuongxa`
--
ALTER TABLE `phuongxa`
  MODIFY `Id_phuong` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `qlbl`
--
ALTER TABLE `qlbl`
  MODIFY `Id_BL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `qlkh`
--
ALTER TABLE `qlkh`
  MODIFY `Id_KH` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
