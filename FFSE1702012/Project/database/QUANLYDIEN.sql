-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 23, 2018 at 05:01 AM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `QUANLYDIEN`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE IF NOT EXISTS `Admin` (
  `Id` int(10) unsigned NOT NULL,
  `Username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`Id`, `Username`, `Password`) VALUES
(2, 'lehung', 'e10adc3949ba59abbe56e057f20f883e');

-- --------------------------------------------------------

--
-- Table structure for table `BienLai`
--

CREATE TABLE IF NOT EXISTS `BienLai` (
  `Id` int(10) unsigned NOT NULL,
  `Username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Macongto` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Ngaynhap` date NOT NULL,
  `Thang` int(20) NOT NULL,
  `Nam` int(20) NOT NULL,
  `Chiso` int(100) NOT NULL,
  `Tiendien` double NOT NULL,
  `Quan` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Phuong` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Selecttime` date NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `BienLai`
--

INSERT INTO `BienLai` (`Id`, `Username`, `Macongto`, `Ngaynhap`, `Thang`, `Nam`, `Chiso`, `Tiendien`, `Quan`, `Phuong`, `Selecttime`) VALUES
(36, 'Lê Hùng', 'CT_005', '2018-04-19', 6, 2018, 300, 77450, 'Hải Châu', 'Phường Hải Châu 1', '2018-06-01'),
(37, 'Lê Hùng', 'CT_005', '2018-04-19', 7, 2018, 350, 77450, 'Hải Châu', 'Phường Hải Châu 1', '2018-07-01'),
(38, 'Lê Hùng', 'CT_005', '2018-04-19', 8, 2018, 400, 77450, 'Hải Châu', 'Phường Hải Châu 1', '2018-08-01'),
(39, 'Lê Hùng', 'CT_005', '2018-04-19', 9, 2018, 450, 77450, 'Hải Châu', 'Phường Hải Châu 1', '2018-09-01'),
(40, 'Lê Hùng', 'CT_005', '2018-04-19', 10, 2018, 500, 77450, 'Hải Châu', 'Phường Hải Châu 1', '2018-10-01'),
(41, 'Lê Hùng', 'CT_005', '2018-04-19', 11, 2018, 550, 77450, 'Hải Châu', 'Phường Hải Châu 1', '2018-11-01'),
(47, 'Lê Nhung', 'CT_007', '2018-04-19', 6, 2018, 300, 61960, 'Cẩm Lệ', 'Phường Hòa An', '2018-06-01'),
(48, 'Lê Nhung', 'CT_007', '2018-04-19', 7, 2018, 350, 77450, 'Cẩm Lệ', 'Phường Hòa An', '2018-07-01'),
(49, 'Lê Nhung', 'CT_007', '2018-04-19', 8, 2018, 400, 77450, 'Cẩm Lệ', 'Phường Hòa An', '2018-08-01'),
(50, 'Lê Nhung', 'CT_007', '2018-04-19', 9, 2018, 450, 77450, 'Cẩm Lệ', 'Phường Hòa An', '2018-09-01'),
(56, 'Lê Hoài', 'CT_009', '2018-04-19', 6, 2018, 50, 77450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2018-06-01'),
(57, 'Lê Hoài', 'CT_009', '2018-04-19', 7, 2018, 120, 109450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2018-07-01'),
(58, 'Lê Hoài', 'CT_009', '2018-04-19', 8, 2018, 170, 77450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2018-08-01'),
(64, 'Lê Suyết', 'CT_004', '2018-04-19', 6, 2018, 300, 77450, 'Liên Chiểu', 'Phường Hòa Khánh Bắc', '2018-06-01'),
(65, 'Lê Suyết', 'CT_004', '2018-04-19', 7, 2018, 350, 77450, 'Liên Chiểu', 'Phường Hòa Khánh Bắc', '2018-07-01'),
(66, 'Lê Suyết', 'CT_004', '2018-04-19', 8, 2018, 400, 77450, 'Liên Chiểu', 'Phường Hòa Khánh Bắc', '2018-08-01'),
(72, 'Lê Nam', 'CT_006', '2018-04-19', 6, 2018, 400, 77450, 'Liên Chiểu', 'Phường Hòa Khánh Nam', '2018-06-01'),
(79, 'Lê Tuyết', 'CT_008', '2018-04-19', 6, 2018, 300, 77450, 'Ngũ Hành Sơn', 'Phường Hòa Hải', '2018-06-01'),
(80, 'Lê Tuyết', 'CT_008', '2018-04-19', 7, 2018, 350, 77450, 'Ngũ Hành Sơn', 'Phường Hòa Hải', '2018-07-01'),
(81, 'Lê Tuyết', 'CT_008', '2018-04-19', 8, 2018, 400, 77450, 'Ngũ Hành Sơn', 'Phường Hòa Hải', '2018-08-01'),
(82, 'Lê Tuyết', 'CT_008', '2018-04-19', 9, 2018, 450, 77450, 'Ngũ Hành Sơn', 'Phường Hòa Hải', '2018-09-01'),
(88, 'Lê Phương', 'CT_010', '2018-04-19', 6, 2018, 290, 61960, 'Ngũ Hành Sơn', 'Phường Hòa Hải', '2018-06-01'),
(89, 'Lê Phương', 'CT_010', '2018-04-19', 7, 2018, 340, 77450, 'Ngũ Hành Sơn', 'Phường Hòa Hải', '2018-07-01'),
(90, 'Lê Phương', 'CT_010', '2018-04-19', 8, 2018, 350, 15490, 'Ngũ Hành Sơn', 'Phường Hòa Hải', '2018-08-01'),
(91, 'Lê Phương', 'CT_010', '2018-04-19', 9, 2018, 400, 77450, 'Ngũ Hành Sơn', 'Phường Hòa Hải', '2018-09-01'),
(93, 'Lê Suyết', 'CT_004', '2018-04-17', 9, 2018, 456, 87050, 'Liên Chiểu', 'Phường Hòa Khánh Bắc', '2018-09-01'),
(94, 'Lê Suyết', 'CT_004', '2018-04-11', 10, 2018, 665, 388410, 'Liên Chiểu', 'Phường Hòa Khánh Bắc', '2018-10-01'),
(110, 'le Tuyết Tuyết', 'CT_011', '2018-04-25', 12, 2018, 70, 109450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2018-12-01'),
(111, 'le Tuyết Tuyết', 'CT_011', '2018-04-12', 1, 2019, 120, 194610, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2019-01-01'),
(112, 'le Tuyết Tuyết', 'CT_011', '2018-04-20', 2, 2019, 150, 46470, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2019-02-01'),
(115, 'le Tuyết Tuyết', 'CT_011', '2018-04-18', 3, 2019, 180, 46470, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2019-03-01'),
(116, 'Lê Hoài', 'CT_009', '2018-04-18', 9, 2018, 220, 77450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2018-09-01'),
(117, 'Lê Hoài', 'CT_009', '2018-04-24', 10, 2018, 270, 77450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2018-10-01'),
(118, 'Lê Hoài', 'CT_009', '2018-04-17', 11, 2018, 320, 77450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2018-11-01'),
(119, 'Lê Hoài', 'CT_009', '2018-04-18', 12, 2018, 370, 77450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2018-12-01'),
(120, 'Lê Hoài', 'CT_009', '2018-04-19', 1, 2019, 50, 77450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2019-01-01'),
(121, 'le Tuyết Tuyết', 'CT_011', '2018-04-23', 4, 2019, 240, 93450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2019-04-01'),
(122, 'le Tuyết Tuyết', 'CT_011', '2018-04-19', 5, 2019, 350, 176030, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2019-05-01'),
(123, 'le Tuyết Tuyết', 'CT_011', '2018-04-22', 6, 2019, 420, 109450, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2019-06-01'),
(124, 'le Tuyết Tuyết', 'CT_011', '2018-04-18', 7, 2019, 460, 61960, 'Liên Chiểu', 'Phường Hòa Hiệp Bắc', '2019-07-01'),
(125, 'Lê Hùng 3', 'CT_015', '2018-04-22', 1, 2018, 70, 109450, 'Hải Châu', 'Phường Bình Hiên', '2018-01-01'),
(126, 'Lê Hùng 3', 'CT_015', '2018-04-22', 2, 2018, 80, 61960, 'Hải Châu', 'Phường Bình Hiên', '2018-02-01'),
(127, 'Lê Hùng 3', 'CT_015', '2018-04-18', 3, 2018, 150, 109450, 'Hải Châu', 'Phường Bình Hiên', '2018-03-01'),
(128, 'Lê Hùng 3', 'CT_015', '2018-04-17', 4, 2018, 200, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-04-01'),
(129, 'Lê Hùng 3', 'CT_015', '2018-04-22', 5, 2018, 250, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-05-01'),
(130, 'Lê Hùng 3', 'CT_015', '2018-04-22', 6, 2018, 300, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-06-01'),
(131, 'Lê Hùng 3', 'CT_015', '2018-04-22', 7, 2018, 350, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-07-01'),
(132, 'Lê Hùng 3', 'CT_015', '2018-04-22', 8, 2018, 400, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-08-01'),
(133, 'Lê Hùng 3', 'CT_015', '2018-04-22', 9, 2018, 450, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-09-01'),
(134, 'Lê Hùng 3', 'CT_015', '2018-04-22', 10, 2018, 500, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-10-01'),
(135, 'Lê Hùng 3', 'CT_015', '2018-04-22', 11, 2018, 550, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-11-01'),
(136, 'Lê Hùng 3', 'CT_015', '2018-04-22', 12, 2018, 600, 77450, 'Hải Châu', 'Phường Bình Hiên', '2018-12-01'),
(137, 'Lê Hùng 3', 'CT_015', '2018-04-22', 1, 2019, 70, 109450, 'Hải Châu', 'Phường Bình Hiên', '2019-01-01'),
(138, 'Lê Hùng 3', 'CT_015', '2018-04-22', 2, 2019, 100, 46470, 'Hải Châu', 'Phường Bình Hiên', '2019-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `Customer`
--

CREATE TABLE IF NOT EXISTS `Customer` (
  `Id` int(11) unsigned NOT NULL,
  `Makh` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Phuong` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Quan` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Macongto` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Customer`
--

INSERT INTO `Customer` (`Id`, `Makh`, `Username`, `Address`, `Phuong`, `Quan`, `Phone`, `Email`, `Macongto`) VALUES
(4, 'DL_004', 'Lê Suyết', '23 Nguyễn Lương Bằng', 'Phường Hòa Khánh Bắc', 'Liên Chiểu', '01234567899', 'letuyet@gmail.com', 'CT_004'),
(5, 'DL_005', 'Lê Hùng', '75 Ngô Quyền', 'Phường Hải Châu 1', 'Hải Châu', '0123654987', 'lehung@gmail.com', 'CT_005'),
(6, 'DL_006', 'Lê Nam', '36 Tôn Đức Thắng', 'Phường Hòa Khánh Nam', 'Liên Chiểu', '0123456789', 'lqhungqt1994@gmail.com', 'CT_006'),
(7, 'DL_007', 'Lê Nhung', '32 Bà Trưng', 'Phường Hòa An', 'Cẩm Lệ', '0123456789', 'lenam@gmail.com', 'CT_007'),
(8, 'DL_008', 'Lê Tuyết', '42 Ngô Quyền', 'Phường Hòa Hải', 'Ngũ Hành Sơn', '0123334566', 'letuyet@gmail.com', 'CT_008'),
(9, 'DL_009', 'Lê Hoài', '43 Hai bà Trưng', 'Phường Hòa Hiệp Bắc', 'Liên Chiểu', '0123456789', 'lehoai@gmail.com', 'CT_009'),
(10, 'DL_010', 'Lê Phương', '32 Nguyễn tất Thành', 'Phường Hòa Hải', 'Ngũ Hành Sơn', '0123456789', 'lephuong@gmail.com', 'CT_010'),
(15, 'DL_011', 'le Tuyết Tuyết', '72 Xuân thiều', 'Phường Hòa Hiệp Bắc', 'Liên Chiểu', '0123456789', 'tuyettuyet@gmail.com', 'CT_011'),
(16, 'DL_013', 'Lê Hùng1 ', '72 Nam cao', 'Phường Hải Châu 1', 'Hải Châu', '0123456789', 'ln1@gmail.com', 'CT_013'),
(17, 'DL_014', 'Lê Hùng2', '34Nam cao', 'Phường Hải Châu 1', 'Hải Châu', '0123456789', 'lh2@gmail.com', 'CT_014'),
(72, 'DL_015', 'Lê Hùng 3', '30 đường 2 tháng 9', 'Phường Bình Hiên', 'Hải Châu', '0123456789', 'lehung3@gmail.com', 'CT_015'),
(73, 'DL_016', 'Lê Hùng 4', '31 đường 2 tháng 9', 'Phường Bình Hiên', 'Hải Châu', '0123456790', 'lh3@gmail.com', 'CT_016'),
(74, 'DL_017', 'Lê Hùng 5', '32 đường 2 tháng 9', 'Phường Bình Hiên', 'Hải Châu', '0123456791', 'lh3@gmail.com', 'CT_017'),
(75, 'DL_018', 'Lê Hùng 6', '33 đường 2 tháng 9', 'Phường Bình Hiên', 'Hải Châu', '0123456792', 'lh3@gmail.com', 'CT_018'),
(76, 'DL_019', 'Lê Hùng 7', '34 đường 2 tháng 9', 'Phường Bình Hiên', 'Hải Châu', '0123456793', 'lh3@gmail.com', 'CT_019'),
(77, 'DL_020', 'Lê Nam 8', '10 Trưng Nữ Vương', 'Phường Bình Thuận', 'Hải Châu', '0123456793', 'lh3@gmail.com', 'CT_020'),
(78, 'DL_021', 'Lê Nam 9', '11 Trưng Nữ Vương', 'Phường Bình Thuận', 'Hải Châu', '0123456793', 'lh3@gmail.com', 'CT_021'),
(79, 'DL_022', 'Lê Nam 10', '12 Trưng Nữ Vương', 'Phường Bình Thuận', 'Hải Châu', '0123456793', 'lh3@gmail.com', 'CT_022'),
(80, 'DL_023', 'Lê Nam 11', '13 Trưng Nữ Vương', 'Phường Bình Thuận', 'Hải Châu', '0123456793', 'lh3@gmail.com', 'CT_023'),
(81, 'DL_024', 'Lê Nam 12', '14 Trưng Nữ Vương', 'Phường Bình Thuận', 'Hải Châu', '0123456793', 'lh3@gmail.com', 'CT_024'),
(82, 'DL_025', 'Lê Nhung 13', '1 Đoàn Ngọc Nhạc', 'Phường Hòa An', 'Cẩm Lệ', '0123456799', 'lh3@gmail.com', 'CT_025'),
(83, 'DL_026', 'Lê Nhung 14', '2 Đoàn Ngọc Nhạc', 'Phường Hòa An', 'Cẩm Lệ', '0123456800', 'lh3@gmail.com', 'CT_026'),
(84, 'DL_027', 'Lê Nhung 15', '3 Đoàn Ngọc Nhạc', 'Phường Hòa An', 'Cẩm Lệ', '0123456801', 'lh3@gmail.com', 'CT_027'),
(85, 'DL_028', 'Lê Nhung 16', '4 Đoàn Ngọc Nhạc', 'Phường Hòa An', 'Cẩm Lệ', '0123456802', 'lh3@gmail.com', 'CT_028'),
(86, 'DL_029', 'Lê Nhung 17', '5 Đoàn Ngọc Nhạc', 'Phường Hòa An', 'Cẩm Lệ', '0123456803', 'lh3@gmail.com', 'CT_029'),
(87, 'DL_030', 'Lê Nhung 18', '6 Đoàn Ngọc Nhạc', 'Phường Hòa An', 'Cẩm Lệ', '0123456804', 'lh3@gmail.com', 'CT_030'),
(88, 'DL_031', 'Lê Tuyết 19', '2 Xuân Thiều', 'Phường Hòa Hiệp Bắc', 'Liên Chiểu', '0123456805', 'lh3@gmail.com', 'CT_031'),
(89, 'DL_032', 'Lê Tuyết 20', '3 Xuân Thiều', 'Phường Hòa Hiệp Bắc', 'Liên Chiểu', '0123456806', 'lh3@gmail.com', 'CT_032'),
(90, 'DL_033', 'Lê Tuyết 21', '4 Xuân Thiều', 'Phường Hòa Hiệp Bắc', 'Liên Chiểu', '0123456807', 'lh3@gmail.com', 'CT_033'),
(91, 'DL_034', 'Lê Tuyết 22', '5 Xuân Thiều', 'Phường Hòa Hiệp Bắc', 'Liên Chiểu', '0123456808', 'lh3@gmail.com', 'CT_034'),
(92, 'DL_035', 'Lê Tuyết 23', '6 Xuân Thiều', 'Phường Hòa Hiệp Bắc', 'Liên Chiểu', '0123456809', 'lh3@gmail.com', 'CT_035'),
(93, 'DL_036', 'Lê Phương 24', '35 Võ Chí Công', 'Phường Hòa Hải', 'Ngũ Hành Sơn', '0123456810', 'lh3@gmail.com', 'CT_036'),
(94, 'DL_037', 'Lê Phương 25', '36 Võ Chí Công', 'Phường Hòa Hải', 'Ngũ Hành Sơn', '0123456811', 'lh3@gmail.com', 'CT_037'),
(95, 'DL_038', 'Lê Phương 26', '37 Võ Chí Công', 'Phường Hòa Hải', 'Ngũ Hành Sơn', '0123456812', 'lh3@gmail.com', 'CT_038'),
(96, 'DL_039', 'Lê Phương 27', '38 Võ Chí Công', 'Phường Hòa Hải', 'Ngũ Hành Sơn', '0123456813', 'lh3@gmail.com', 'CT_039'),
(97, 'DL_040', 'Lê Phương 28', '39 Võ Chí Công', 'Phường Hòa Hải', 'Ngũ Hành Sơn', '0123456814', 'lh3@gmail.com', 'CT_040'),
(98, 'DL_041', 'Lê Phương 29', '40 Võ Chí Công', 'Phường Hòa Hải', 'Ngũ Hành Sơn', '0123456815', 'lh3@gmail.com', 'CT_041');

-- --------------------------------------------------------

--
-- Table structure for table `Phuong`
--

CREATE TABLE IF NOT EXISTS `Phuong` (
  `Id` int(10) unsigned NOT NULL,
  `Parent_id` int(10) NOT NULL,
  `Phuong` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Phuong`
--

INSERT INTO `Phuong` (`Id`, `Parent_id`, `Phuong`) VALUES
(1, 1, 'Phường Bình Hiên'),
(2, 1, 'Phường Bình Thuận'),
(3, 1, 'Phường Hải Châu 1'),
(4, 1, 'Phường Hải Châu 2'),
(5, 1, 'Phường Hòa Cường Bắc'),
(6, 1, 'Phường Hòa Cường Nam'),
(7, 1, 'Phường Hòa Thuận Đông'),
(8, 1, 'Phường Hòa Thuận Tây'),
(9, 2, 'Phường Hòa An'),
(10, 2, 'Phường Hòa Phát'),
(11, 2, 'Phường Hòa Thọ Đông'),
(12, 2, 'Phường Hòa Thọ Tây'),
(13, 2, 'Phường Hòa Xuân'),
(14, 2, 'Phường Khuê Trung'),
(15, 3, 'Phường Hòa Hiệp Bắc'),
(16, 3, 'Phường Hòa Hiệp Nam'),
(17, 3, 'Phường Hòa Khánh Bắc'),
(18, 3, 'Phường Hòa Khánh Nam'),
(20, 3, 'Phường Hòa Minh'),
(21, 4, 'Phường Hòa Hải'),
(22, 4, 'Phường Hòa Quý'),
(23, 4, 'Phường Khuê Mỹ'),
(24, 4, 'Phường Mỹ An');

-- --------------------------------------------------------

--
-- Table structure for table `Quan`
--

CREATE TABLE IF NOT EXISTS `Quan` (
  `Id` int(10) unsigned NOT NULL,
  `Quan` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Quan`
--

INSERT INTO `Quan` (`Id`, `Quan`) VALUES
(1, 'Hải Châu'),
(2, 'Cẩm Lệ'),
(3, 'Liên Chiểu'),
(4, 'Ngũ Hành Sơn');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `Id` int(10) NOT NULL,
  `Makh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Macongto` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`Id`, `Makh`, `Password`, `Macongto`) VALUES
(1, 'DL_001', 'e10adc3949ba59abbe56e057f20f883e', 'CT_001'),
(2, 'DL_002', 'e10adc3949ba59abbe56e057f20f883e', 'CT_002'),
(3, 'DL_003', 'e10adc3949ba59abbe56e057f20f883e', 'CT_003'),
(4, 'DL_004', 'e10adc3949ba59abbe56e057f20f883e', 'CT_004'),
(5, 'DL_005', 'e10adc3949ba59abbe56e057f20f883e', 'CT_005'),
(6, 'DL_006', 'e10adc3949ba59abbe56e057f20f883e', 'CT_006'),
(7, 'DL_007', 'e10adc3949ba59abbe56e057f20f883e', 'CT_007'),
(8, 'DL_008', 'e10adc3949ba59abbe56e057f20f883e', 'CT_008'),
(9, 'DL_009', 'e10adc3949ba59abbe56e057f20f883e', 'CT_009'),
(10, 'DL_010', 'e10adc3949ba59abbe56e057f20f883e', 'CT_010');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `BienLai`
--
ALTER TABLE `BienLai`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `Phuong`
--
ALTER TABLE `Phuong`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `Quan`
--
ALTER TABLE `Quan`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin`
--
ALTER TABLE `Admin`
  MODIFY `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `BienLai`
--
ALTER TABLE `BienLai`
  MODIFY `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=139;
--
-- AUTO_INCREMENT for table `Customer`
--
ALTER TABLE `Customer`
  MODIFY `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=99;
--
-- AUTO_INCREMENT for table `Phuong`
--
ALTER TABLE `Phuong`
  MODIFY `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `Quan`
--
ALTER TABLE `Quan`
  MODIFY `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
