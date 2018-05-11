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
-- Cấu trúc bảng cho bảng `sinhvien`
--

CREATE TABLE `sinhvien` (
  `id` int(10) NOT NULL,
  `maSV` varchar(220) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tenSV` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tuoiSV` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `lop` varchar(120) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nha` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dienthoai` varchar(110) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tinh` varchar(111) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `huyen` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `xa` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `sinhvien`
--

INSERT INTO `sinhvien` (`id`, `maSV`, `tenSV`, `tuoiSV`, `lop`, `nha`, `email`, `dienthoai`, `tinh`, `huyen`, `xa`) VALUES
(1, 'cz', 'aacxz', 'aaadsasad', 'FFSE1703', '11/6 luu quang thuandsaasdas', '1999naadsadasas', 'aaadsadasd', 'Tỉnh Bắc Kạn', 'Huyện Chợ Đồn', 'Xã Bản Thi'),
(52, '3', '3', '3', 'FFSE1702-A', '3', '3', '3', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(53, '1', '1', '1', 'FFSE1702-A', '1', '1', '1', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(54, '3', '3', '3', 'FFSE1702-A', '3', '3', '3', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(55, '4', '4', '4', 'FFSE1702-A', '4', '4', '4', 'Tỉnh Bắc Kạn', 'Huyện Na Rì', 'Xã Văn Học'),
(56, '2ádas', '2', '2', 'FFSE1702-A', '2', '2', '2', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(57, '1', '1', '1', 'FFSE1702-A', '1', '1', '11', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(58, '1702', 'NGUYEN CONG QUANG', '19', 'FFSE1702-A', '11/6', '1999nguyencongquang@gmail.com', '0919587800', 'Thành phố Đà Nẵng', 'Quận Ngũ Hành Sơn', 'Phường Phúc Xá'),
(59, '1702023', 'Cao Quang Thuận', '19', 'FFSE1702-A', '11/6 LUU QUANG THUAN,mm', 'thuanoccho@gmail.com', '0123456789', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(60, 'ffse1702025', 'vũ', '1', 'FFSE1702-A', '1', '1', '1', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(61, '1703001', 'ti', '1', 'FFSE1702-A', '1', '1', '1', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(62, 'ffse1801001', '1', '11', 'FFSE1702-A', '1', '1', '1', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(63, 'ffse1801002', '1', '1', 'FFSE1702-A', '1', '1', '1', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(64, 'FFSE1702056', 'Cao Quang Thuận', '19', 'FFSE1702-A', '11 Trần Duy Hưng', 'thuanoccho@gmail.com', '0123456789', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Liễu Giai'),
(65, 'FFSE1702045', 'Nguyễn Anh Vũ ', '21', 'FFSE1702-A', '11  Nguyễn Công Quang', 'xeng@gmail.com', '0123456789', 'Tỉnh Lai Châu', 'Huyện Tân Uyên', 'Xã Hố Mít'),
(66, 'ffse1702024', 'nguyen van a', '20', 'FFSE1703', '34', '111111', '123456789', 'Tỉnh Cao Bằng', 'Huyện Trà Lĩnh', 'Xã Lưu Ngọc'),
(67, 'ffse12321', '121', '2', 'FFSE1702-A', '2', '21', '212', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(68, '12121', '21', '212', 'FFSE1702-A', '2', '2', '2', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(69, '12121', '21', '21222', 'FFSE1702-A', '2', '221', '2212', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(70, 'ffse1703056', 'Nguyễn Văn A', '30', 'FFSE1702-A', '33', 'qqqqq', '0123456789', 'Thành phố Hà Nội', 'Quận Ba Đình', 'Phường Phúc Xá'),
(71, '1702', 'NGUYEN CONG QUANG', '19', 'FFSE1702-A', '11/6', '1999nguyencongquang@gmail.com', '0919587800', 'Thành phố Đà Nẵng', 'Quận Ngũ Hành Sơn', 'Phường Phúc Xá');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `sinhvien`
--
ALTER TABLE `sinhvien`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
