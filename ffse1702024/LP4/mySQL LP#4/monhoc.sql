-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 09, 2018 lúc 05:15 PM
-- Phiên bản máy phục vụ: 10.1.28-MariaDB
-- Phiên bản PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quangnc1`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

CREATE TABLE `monhoc` (
  `id` int(11) NOT NULL,
  `maMH` varchar(111) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hocki` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenMH` varchar(111) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `soTC` varchar(111) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `TGhoc` varchar(111) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`id`, `maMH`, `hocki`, `tenMH`, `soTC`, `TGhoc`) VALUES
(1, 'LP#0', 'HK1', 'Living in a digital world', '0', '20'),
(2, 'LP#1', 'HK1', 'CSI by visual programming with Scratch', '12', '30'),
(3, 'LP#2', 'HK1', 'Web programming with html, css, javascript, boostrap', '20', '50'),
(4, 'LP#3', 'HK1', 'Web-based application development (php, ajax, mysql)', '20', '100'),
(5, 'LP#4', 'HK2', 'Object-oriented programming with Java (basics)', '30', '100'),
(6, 'LP#5', 'HK2', 'Web-based application development with Java', '30', '100'),
(7, 'LP#6', 'HK2', 'Industry trendy projects', '0', '100'),
(9, 'ELC', 'HK1', 'English camp', '30', '100'),
(10, 'E4IT', 'HK2', 'Requirement understanding', '30', '100');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
