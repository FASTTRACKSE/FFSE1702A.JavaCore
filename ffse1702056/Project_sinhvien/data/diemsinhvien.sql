-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 27, 2018 lúc 04:10 PM
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
(3, 'FFSE1702045', '', '', ''),
(4, 'ffse1702024', '', '', ''),
(5, '12121', '', '', ''),
(8, '1', '1', '1', '1'),
(9, 'ffse1702024', 'HK1', 'LP1', '6'),
(10, 'FFSE1702056', 'HK1', 'LP#0', '5'),
(11, 'ffse1702024', 'HK1', 'LP#3', '9'),
(12, '', 'HK1', 'LP#1', ''),
(13, '', 'HK2', 'LP#5', '12'),
(14, 'ffse1702056', 'HK2', 'LP#5', '12');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
