-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2018 at 06:10 PM
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
-- Database: `ffse1702029`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Pass` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`ID`, `Name`, `Email`, `Pass`) VALUES
(1, 'Lý Thái', 'thai@gmail.com', 'thai123'),
(2, 'Lâm Ly', 'ly@gmail.com', 'ly12345'),
(3, 'Ngô Hạ', 'ha@gmail.com', 'hacute123'),
(4, 'Đỗ Kì', 'ki@gmail.com', 'ki12345');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID` int(11) NOT NULL,
  `Name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Lop` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Ngaysinh` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `Masv` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Phone` int(11) NOT NULL,
  `Email` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Pass` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nam_hoc` int(11) DEFAULT NULL,
  `Diem_CN` int(11) DEFAULT NULL,
  `Diem_TA` int(11) DEFAULT NULL,
  `Diem_Tong` int(11) DEFAULT NULL,
  `Xep_Loai` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Tinh` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Huyen` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `xa` varchar(11) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `Name`, `Lop`, `Ngaysinh`, `DiaChi`, `Masv`, `Phone`, `Email`, `Pass`, `nam_hoc`, `Diem_CN`, `Diem_TA`, `Diem_Tong`, `Xep_Loai`, `Tinh`, `Huyen`, `xa`) VALUES
(1, 'Tran Binh Trọng', 'FFSE1702', '02/02/1999', '45-Ngô Quyền', 'ffse1701001', 98764, 'binh@gmail.com', '12345', 2018, 6, 9, 8, 'giỏi', 'TP.Đà Nẵng', 'Sơn Trà', 'Mân Thái'),
(2, 'nguyễn trâm', 'FFSE1701', '12/09/1997', 'Tổ 4-Tân Đông', 'ffse1701002', 143454667, 'tram@gmail.com', '111', 2017, 7, 7, 7, 'khá', 'Quảng Nam', 'Quế Sơn', 'Phú Thọ'),
(3, 'Lâm Vĩ Dạ', 'FFSE1701', '30/08/1988', 'Tổ 2-Tam Ly', 'ffse1701003', 1623566, 'da@gmail.com', 'da12345', 2017, 8, 4, 6, 'trung bình', 'Quảng Nam', 'Quế Sơn', 'Phú Thọ'),
(4, 'Trần Vũ Linh', 'FFSE1701', '03/11/2000', '111-Lê Văn Hiến', 'ffse1701004', 203454565, 'linh@gmail.com', 'linh12345', 2017, 4, 9, 7, 'khá', 'TP.Đà Nẵng', 'Ngũ Hành Sơn', 'Hòa Hải'),
(5, 'Ngô Gia Vĩ ', 'FFSE1702', '30/08/1988', '22-Ngô Quyền', 'ffse1702001', 1623566, 'vi@gmail.com', 'vi12345', 2018, 9, 6, 8, 'gioi', 'TP.Đà Nẵng', 'Sơn Trà', 'Mân Thái'),
(6, 'Trần Thảo Tin', 'FFSE1702', '03/11/2000', 'Tổ 1-Phước Sơn', 'ffse1702002', 203454565, 'tin@gmail.com', 'tin12345', 2018, 6, 8, 7, 'khá', 'Quảng Nam', 'Quế Sơn', 'Quế Thuận'),
(14, 'trân hoa', 'FFSE1701', '12/02/1994', 'Phước Sơn', 'ffse1701005', 1232343, 'hoa@gmail,com', NULL, 2017, 4, 5, 5, 'khá', 'Quảng Nam', 'Quế Sơn', 'Quế Thuận'),
(18, 'nguyễn Hạ trâm', 'FFSE1702', '12/09/1997', 'Tổ 4-Tân Đông', 'ffse1702003', 143454667, 'tram@gmail.com', NULL, 2018, 7, 9, 8, 'giỏi', 'Quảng Nam', 'Quế Sơn', 'Phú Thọ'),
(22, 'Lý Nhã Kỳ', 'FFSE1701', '30/08/1988', '22-Ngô Quyền', 'ffse1702005', 1623566, 'ki@gmail.com', NULL, 2017, 3, 4, 4, 'yếu', 'TP.Đà Nẵng', 'Sơn Trà', 'Mân Thái'),
(24, 'Lý Nhã Phương', 'FFSE1701', '30/08/1987', '22-lê văn hiến', 'ffse1702006', 1623566, 'phuong@gmail.com', NULL, 2018, 5, 4, 5, 'trung bình', 'TP.Đà Nẵng', 'Ngũ Hành Sơn', 'Hòa Hải');

-- --------------------------------------------------------

--
-- Table structure for table `huyen`
--

CREATE TABLE `huyen` (
  `id` int(11) NOT NULL,
  `Ten_huyen` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ma_huyen` int(11) NOT NULL,
  `Ma_tinh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `huyen`
--

INSERT INTO `huyen` (`id`, `Ten_huyen`, `Ma_huyen`, `Ma_tinh`) VALUES
(1, 'Quế Sơn', 1, 1),
(2, 'Sơn Trà', 2, 2),
(3, 'Ngũ Hành Sơn', 3, 2),
(4, 'TP.Tam Kì', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `mon_hoc`
--

CREATE TABLE `mon_hoc` (
  `id` int(11) NOT NULL,
  `Ten_mon_hoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ma_du_an` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ten_du_an` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `So_tin_chi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `mon_hoc`
--

INSERT INTO `mon_hoc` (`id`, `Ten_mon_hoc`, `Ma_du_an`, `Ten_du_an`, `So_tin_chi`) VALUES
(1, 'Công Nghệ', 'LP#0', 'Living in a digital world\r\n', 0),
(2, 'Công Nghệ', 'LP#1', 'Living in a digital world\r\n', 0),
(3, 'Công Nghệ', 'LP#3', 'Web programming with html, css, javascript, boostrap\r\n\r\n', 1),
(4, 'Công Nghệ', 'LP#4', 'Web-based application development (php, ajax, mysql)\r\n', 1),
(5, 'Tiếng anh', 'E4IT#0', 'English camp', 0),
(6, 'Tiếng anh', 'E4IT#1', 'Basic conversations & requirements understanding', 1),
(7, 'Tiếng anh', 'E4IT#2', 'Requirement understanding(2)', 1),
(8, 'Tiếng anh', 'E4IT#3', 'design & test documentation understanding', 1),
(14, 'Tiếng anh', 'E4IT#4', 'Project communication', 1);

-- --------------------------------------------------------

--
-- Table structure for table `thoi_khoa_bieu`
--

CREATE TABLE `thoi_khoa_bieu` (
  `ID` int(11) NOT NULL,
  `Lop` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Mon_hoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ngay_hoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Thoi_gian` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thoi_khoa_bieu`
--

INSERT INTO `thoi_khoa_bieu` (`ID`, `Lop`, `Mon_hoc`, `Ngay_hoc`, `Thoi_gian`) VALUES
(1, 'ffse1701', 'Công nghệ', '20/3/2017-3/3/2018', '13h-17h'),
(2, 'ffse1701', 'Tiếng anh', '20/3/2017-3/3/2018', '8h-12h'),
(3, 'ffse1702', 'Công nghệ', '5/6/2017-5/6/2018', '13h-17h'),
(4, 'ffse1702', 'Tiếng anh', '5/6/2017-5/6/2018', '08h-12h');

-- --------------------------------------------------------

--
-- Table structure for table `tinh`
--

CREATE TABLE `tinh` (
  `id` int(11) NOT NULL,
  `Ten_tinh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ma_tinh` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tinh`
--

INSERT INTO `tinh` (`id`, `Ten_tinh`, `Ma_tinh`) VALUES
(1, 'Quảng Nam', 1),
(2, 'TP.Đà Nẵng', 2);

-- --------------------------------------------------------

--
-- Table structure for table `xa_phuong`
--

CREATE TABLE `xa_phuong` (
  `id` int(11) NOT NULL,
  `Ten_xa` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ma_huyen` int(11) NOT NULL,
  `Ma_tinh` int(11) NOT NULL,
  `Ma_xa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `xa_phuong`
--

INSERT INTO `xa_phuong` (`id`, `Ten_xa`, `Ma_huyen`, `Ma_tinh`, `Ma_xa`) VALUES
(1, 'Quế Thuận', 1, 1, 1),
(2, 'Phú Thọ', 1, 1, 2),
(3, 'Mân Thái', 2, 2, 3),
(4, 'Tam Lãnh', 4, 1, 4),
(5, 'Hòa Hải', 3, 2, 5),
(6, 'Hòa Qúy', 3, 2, 6),
(7, 'Thọ Quang', 2, 2, 7),
(8, 'Tam Hiệp', 4, 1, 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `huyen`
--
ALTER TABLE `huyen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mon_hoc`
--
ALTER TABLE `mon_hoc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `thoi_khoa_bieu`
--
ALTER TABLE `thoi_khoa_bieu`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tinh`
--
ALTER TABLE `tinh`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `xa_phuong`
--
ALTER TABLE `xa_phuong`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `huyen`
--
ALTER TABLE `huyen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `mon_hoc`
--
ALTER TABLE `mon_hoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `thoi_khoa_bieu`
--
ALTER TABLE `thoi_khoa_bieu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tinh`
--
ALTER TABLE `tinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `xa_phuong`
--
ALTER TABLE `xa_phuong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
