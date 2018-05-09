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
-- Cấu trúc bảng cho bảng `diemsinhvien`
--

CREATE TABLE `diemsinhvien` (
  `id` int(11) NOT NULL,
  `mssv1` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hocki` varchar(11111) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL,
  `monhoc` varchar(111) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `diem` varchar(111) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `diemsinhvien`
--

INSERT INTO `diemsinhvien` (`id`, `mssv1`, `hocki`, `monhoc`, `diem`) VALUES
(680, 'FFSE1702024', 'HK1', 'LP#1', ''),
(681, 'FFSE1702024', 'HK1', 'LP#2', ''),
(682, 'FFSE1702024', 'HK1', 'LP#3', ''),
(683, 'FFSE1702024', 'HK2', 'LP#4', ''),
(684, 'FFSE1702024', 'HK2', 'LP#5', ''),
(685, 'FFSE1702024', 'HK2', 'LP#6', ''),
(686, 'FFSE1702024', 'HK1', 'ELC', ''),
(687, 'FFSE1702024', 'HK2', 'E4IT', ''),
(896, 'null', 'HK1', 'LP#1', ''),
(897, 'null', 'HK1', 'LP#2', ''),
(898, 'null', 'HK1', 'LP#3', ''),
(899, 'null', 'HK2', 'LP#4', ''),
(900, 'null', 'HK2', 'LP#5', ''),
(901, 'null', 'HK2', 'LP#6', ''),
(902, 'null', 'HK1', 'ELC', ''),
(903, 'null', 'HK2', 'E4IT', ''),
(904, 'null', 'HK1', 'LP#1', ''),
(905, 'null', 'HK1', 'LP#2', ''),
(906, 'null', 'HK1', 'LP#3', ''),
(907, 'null', 'HK2', 'LP#4', ''),
(908, 'null', 'HK2', 'LP#5', ''),
(909, 'null', 'HK2', 'LP#6', ''),
(910, 'null', 'HK1', 'ELC', ''),
(911, 'null', 'HK2', 'E4IT', ''),
(912, 'null', 'HK1', 'LP#1', ''),
(913, 'null', 'HK1', 'LP#2', ''),
(914, 'null', 'HK1', 'LP#3', ''),
(915, 'null', 'HK2', 'LP#4', ''),
(916, 'null', 'HK2', 'LP#5', ''),
(917, 'null', 'HK2', 'LP#6', ''),
(918, 'null', 'HK1', 'ELC', ''),
(919, 'null', 'HK2', 'E4IT', ''),
(920, '1', 'HK1', 'LP#1', ''),
(921, '1', 'HK1', 'LP#2', ''),
(922, '1', 'HK1', 'LP#3', ''),
(923, '1', 'HK2', 'LP#4', ''),
(924, '1', 'HK2', 'LP#5', ''),
(925, '1', 'HK2', 'LP#6', ''),
(926, '1', 'HK1', 'ELC', ''),
(927, '1', 'HK2', 'E4IT', '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `diemsinhvien`
--
ALTER TABLE `diemsinhvien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `diemsinhvien`
--
ALTER TABLE `diemsinhvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=928;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
