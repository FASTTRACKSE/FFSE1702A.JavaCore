-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 23, 2018 lúc 02:36 PM
-- Phiên bản máy phục vụ: 10.1.29-MariaDB
-- Phiên bản PHP: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `county`
--

CREATE TABLE `county` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `county`
--

INSERT INTO `county` (`id`, `name`) VALUES
(1, 'Hải Châu'),
(2, 'Thanh Khê'),
(3, 'Sơn Trà'),
(4, 'Ngũ Hành Sơn'),
(5, 'Liên Chiểu'),
(6, 'Hòa Vang'),
(7, 'Cẩm Lệ'),
(8, 'Hoàng Sa');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `countyID` tinyint(4) NOT NULL,
  `wardID` tinyint(4) NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `meterID` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `fullname`, `address`, `countyID`, `wardID`, `phone`, `email`, `meterID`) VALUES
(1, 'hoainam', 'q', 3, 40, '0123456789', 'x@gmail.com', '5'),
(2, 'viet', 'qq', 2, 47, '0123456789', 'l@gmail.com', '2'),
(3, 'long', 'nn', 2, 48, '0123456789', 'g@gmail.com', '7'),
(4, 'z', 'a', 1, 7, '0123456789', 'a@gmail.com', '3');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `meterID` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dateAdded` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cycle` date NOT NULL,
  `meterIndex` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `invoice`
--

INSERT INTO `invoice` (`id`, `meterID`, `dateAdded`, `cycle`, `meterIndex`, `amount`) VALUES
(7, '2', '2018-04-19', '2018-01-01', 2, 3098),
(16, '2', '2018-04-19', '2018-01-01', 3, 1549),
(17, '2', '2018-04-19', '2018-01-01', 7, 4647),
(18, '3', '2018-04-19', '2018-01-01', 2, 3098),
(19, '5', '2018-04-23', '2018-04-01', 5, 7745),
(20, '5', '2018-04-23', '2018-04-01', 8, 4647);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ward`
--

CREATE TABLE `ward` (
  `id` int(11) NOT NULL,
  `county` tinyint(4) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ward`
--

INSERT INTO `ward` (`id`, `county`, `name`) VALUES
(1, 7, 'Hòa An'),
(2, 7, 'Hòa Phát'),
(3, 7, 'Hòa Thọ Đông'),
(4, 7, 'Hòa Thọ Tây'),
(5, 7, 'Hòa Xuân'),
(6, 7, 'Khuê Trung'),
(7, 1, 'Bình Hiên'),
(8, 1, 'Bình Thuận'),
(9, 1, 'Hải Châu I'),
(10, 1, 'Hải Châu II'),
(11, 1, 'Hòa Cường Bắc'),
(12, 1, 'Hòa Cường Nam'),
(13, 1, 'Hòa Thuận Đông'),
(14, 1, 'Hòa Thuận Tây'),
(15, 1, 'Nam Dương'),
(16, 1, 'Phước Ninh'),
(17, 1, 'Thạch Thang'),
(18, 1, 'Thanh Bình'),
(19, 1, 'Thuận Phước'),
(20, 6, 'Hòa Bắc'),
(21, 6, 'Hòa Châu'),
(22, 6, 'Hòa Khương'),
(23, 6, 'Hòa Liên'),
(24, 6, 'Hòa Nhơn'),
(25, 6, 'Hòa Ninh'),
(26, 6, 'Hòa Phong'),
(27, 6, 'Hòa Phú'),
(28, 6, 'Hòa Phước'),
(29, 6, 'Hòa Sơn'),
(30, 6, 'Hòa Tiến'),
(31, 5, 'Hòa Hiệp Bắc'),
(32, 5, 'Hòa Hiệp Nam'),
(33, 5, 'Hòa Khánh Bắc'),
(34, 5, 'Hòa Khánh Nam'),
(35, 5, 'Hòa Minh'),
(36, 4, 'Hòa Hải'),
(37, 4, 'Hòa Quý'),
(38, 4, 'Khuê Mỹ'),
(39, 4, 'Mỹ An'),
(40, 3, 'An Hải Bắc'),
(41, 3, 'An Hải Đông'),
(42, 3, 'An Hải Tây'),
(43, 3, 'Mân Thái'),
(44, 3, 'Nại Hiên Đông'),
(45, 3, 'Phước Mỹ'),
(46, 3, 'Thọ Quang'),
(47, 2, 'An Khê'),
(48, 2, 'Chính Gián'),
(49, 2, 'Hòa Khê'),
(50, 2, 'Tam Thuận'),
(51, 2, 'Tân Chính'),
(52, 2, 'Thạc Gián'),
(53, 2, 'Thanh Khê Đông'),
(54, 2, 'Thanh Khê Tây'),
(55, 2, 'Vĩnh Trung'),
(56, 2, 'Xuân Hà');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `county`
--
ALTER TABLE `county`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `ward`
--
ALTER TABLE `ward`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `county`
--
ALTER TABLE `county`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `ward`
--
ALTER TABLE `ward`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
