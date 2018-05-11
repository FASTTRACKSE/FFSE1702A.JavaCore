-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2018 at 04:02 PM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlytiendien`
--

-- --------------------------------------------------------

--
-- Table structure for table `ffse004_admin`
--

CREATE TABLE IF NOT EXISTS `ffse004_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse004_admin`
--

INSERT INTO `ffse004_admin` (`id`, `username`, `password`) VALUES
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `ffse004_bienlai`
--

CREATE TABLE IF NOT EXISTS `ffse004_bienlai` (
  `id` int(10) NOT NULL,
  `macongto` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ngaynhap` varchar(30) NOT NULL,
  `month` int(2) NOT NULL,
  `year` int(4) NOT NULL,
  `chisocongto` int(100) NOT NULL,
  `tinh_tien` double DEFAULT NULL,
  `chuky` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse004_bienlai`
--

INSERT INTO `ffse004_bienlai` (`id`, `macongto`, `ngaynhap`, `month`, `year`, `chisocongto`, `tinh_tien`, `chuky`) VALUES
(19, 'ct1', '1/1/2018', 1, 2018, 0, 0, '201801'),
(20, 'ct1', '2/2/2018', 2, 2018, 50, 77450, '201802'),
(21, 'ct1', '3/3/2018', 3, 2018, 100, 77450, '201803'),
(22, 'ct1', '3/4/2018', 4, 2018, 251, 280558, '201804'),
(23, 'ct2', '1/1/2108', 1, 2018, 0, 0, '201801'),
(24, 'ct2', '1/2/2108', 2, 2018, 51, 81600, '201802'),
(25, 'ct2', '4/3/2018', 3, 2018, 300, 582660, '201803');

-- --------------------------------------------------------

--
-- Table structure for table `ffse004_customer`
--

CREATE TABLE IF NOT EXISTS `ffse004_customer` (
  `id` int(10) NOT NULL,
  `maKH` varchar(20) NOT NULL,
  `hoten` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `quan` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phuong` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dienthoai` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `macongto` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse004_customer`
--

INSERT INTO `ffse004_customer` (`id`, `maKH`, `hoten`, `diachi`, `quan`, `phuong`, `dienthoai`, `email`, `macongto`) VALUES
(42, 'kh2', 'Nguyễn Mạnh Dũng', '07 lê duẩn', 'Liên Chiểu', 'Hòa Minh', '0123456', 'manh_dung@gmail.com', 'ct2'),
(46, 'kh1', 'Đặng Anh Dũng', '09 Đỗ Anh Hàn', 'Sơn Trà', 'An Hải Bắc', '0929082808', 'dung@gmail.com', 'ct1'),
(48, 'kh5', 'nguyễn văn sỹ', '07 Hà Huy Tập', 'Thanh Khê', ' Thanh Khê ', '016512212', 'sy@gmail.com', 'ct5');

-- --------------------------------------------------------

--
-- Table structure for table `ffse004_phuong`
--

CREATE TABLE IF NOT EXISTS `ffse004_phuong` (
  `id` int(10) NOT NULL,
  `tenphuong` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `maquan` int(10) NOT NULL,
  `maphuong` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse004_phuong`
--

INSERT INTO `ffse004_phuong` (`id`, `tenphuong`, `maquan`, `maphuong`) VALUES
(1, 'An Hải Bắc', 1, 1),
(2, 'An Hải Đông', 1, 2),
(3, 'An Hải Tây', 1, 3),
(4, 'Mân Thái', 1, 4),
(5, 'Phước Mỹ', 1, 5),
(6, 'Hòa Minh', 2, 6),
(7, 'Hòa Hiệp Bắc', 2, 7),
(8, 'An Khê', 3, 8),
(9, ' Xuân Hà', 3, 9),
(10, ' Thanh Khê ', 3, 10);

-- --------------------------------------------------------

--
-- Table structure for table `ffse004_quan`
--

CREATE TABLE IF NOT EXISTS `ffse004_quan` (
  `id` int(10) NOT NULL,
  `tenquan` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `maphuong` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse004_quan`
--

INSERT INTO `ffse004_quan` (`id`, `tenquan`, `maphuong`) VALUES
(1, 'Sơn Trà', 1),
(2, 'Liên Chiểu', 2),
(3, 'Thanh Khê', 3);

-- --------------------------------------------------------

--
-- Table structure for table `ffse004_used`
--

CREATE TABLE IF NOT EXISTS `ffse004_used` (
  `id` int(10) NOT NULL,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `passWord` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ffse004_used`
--

INSERT INTO `ffse004_used` (`id`, `username`, `passWord`) VALUES
(25, 'kh1', '12345678'),
(28, 'kh2', '12345678'),
(31, 'kh5', '12345678');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ffse004_admin`
--
ALTER TABLE `ffse004_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ffse004_bienlai`
--
ALTER TABLE `ffse004_bienlai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ffse004_customer`
--
ALTER TABLE `ffse004_customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ffse004_phuong`
--
ALTER TABLE `ffse004_phuong`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ffse004_quan`
--
ALTER TABLE `ffse004_quan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ffse004_used`
--
ALTER TABLE `ffse004_used`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ffse004_admin`
--
ALTER TABLE `ffse004_admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `ffse004_bienlai`
--
ALTER TABLE `ffse004_bienlai`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `ffse004_customer`
--
ALTER TABLE `ffse004_customer`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `ffse004_phuong`
--
ALTER TABLE `ffse004_phuong`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `ffse004_quan`
--
ALTER TABLE `ffse004_quan`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `ffse004_used`
--
ALTER TABLE `ffse004_used`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=32;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
