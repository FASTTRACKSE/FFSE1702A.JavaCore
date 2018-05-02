/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : db_atm

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-05-02 11:38:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `provinceid` varchar(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`provinceid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('01', 'Hà Nội', 'Thành Phố');
INSERT INTO `province` VALUES ('02', 'Hà Giang', 'Tỉnh');
INSERT INTO `province` VALUES ('04', 'Cao Bằng', 'Tỉnh');
INSERT INTO `province` VALUES ('06', 'Bắc Kạn', 'Tỉnh');
INSERT INTO `province` VALUES ('08', 'Tuyên Quang', 'Tỉnh');
INSERT INTO `province` VALUES ('10', 'Lào Cai', 'Tỉnh');
INSERT INTO `province` VALUES ('11', 'Điện Biên', 'Tỉnh');
INSERT INTO `province` VALUES ('12', 'Lai Châu', 'Tỉnh');
INSERT INTO `province` VALUES ('14', 'Sơn La', 'Tỉnh');
INSERT INTO `province` VALUES ('15', 'Yên Bái', 'Tỉnh');
INSERT INTO `province` VALUES ('17', 'Hòa Bình', 'Tỉnh');
INSERT INTO `province` VALUES ('19', 'Thái Nguyên', 'Tỉnh');
INSERT INTO `province` VALUES ('20', 'Lạng Sơn', 'Tỉnh');
INSERT INTO `province` VALUES ('22', 'Quảng Ninh', 'Tỉnh');
INSERT INTO `province` VALUES ('24', 'Bắc Giang', 'Tỉnh');
INSERT INTO `province` VALUES ('25', 'Phú Thọ', 'Tỉnh');
INSERT INTO `province` VALUES ('26', 'Vĩnh Phúc', 'Tỉnh');
INSERT INTO `province` VALUES ('27', 'Bắc Ninh', 'Tỉnh');
INSERT INTO `province` VALUES ('30', 'Hải Dương', 'Tỉnh');
INSERT INTO `province` VALUES ('31', 'Hải Phòng', 'Thành Phố');
INSERT INTO `province` VALUES ('33', 'Hưng Yên', 'Tỉnh');
INSERT INTO `province` VALUES ('34', 'Thái Bình', 'Tỉnh');
INSERT INTO `province` VALUES ('35', 'Hà Nam', 'Tỉnh');
INSERT INTO `province` VALUES ('36', 'Nam Định', 'Tỉnh');
INSERT INTO `province` VALUES ('37', 'Ninh Bình', 'Tỉnh');
INSERT INTO `province` VALUES ('38', 'Thanh Hóa', 'Tỉnh');
INSERT INTO `province` VALUES ('40', 'Nghệ An', 'Tỉnh');
INSERT INTO `province` VALUES ('42', 'Hà Tĩnh', 'Tỉnh');
INSERT INTO `province` VALUES ('44', 'Quảng Bình', 'Tỉnh');
INSERT INTO `province` VALUES ('45', 'Quảng Trị', 'Tỉnh');
INSERT INTO `province` VALUES ('46', 'Thừa Thiên Huế', 'Tỉnh');
INSERT INTO `province` VALUES ('48', 'Đà Nẵng', 'Thành Phố');
INSERT INTO `province` VALUES ('49', 'Quảng Nam', 'Tỉnh');
INSERT INTO `province` VALUES ('51', 'Quảng Ngãi', 'Tỉnh');
INSERT INTO `province` VALUES ('52', 'Bình Định', 'Tỉnh');
INSERT INTO `province` VALUES ('54', 'Phú Yên', 'Tỉnh');
INSERT INTO `province` VALUES ('56', 'Khánh Hòa', 'Tỉnh');
INSERT INTO `province` VALUES ('58', 'Ninh Thuận', 'Tỉnh');
INSERT INTO `province` VALUES ('60', 'Bình Thuận', 'Tỉnh');
INSERT INTO `province` VALUES ('62', 'Kon Tum', 'Tỉnh');
INSERT INTO `province` VALUES ('64', 'Gia Lai', 'Tỉnh');
INSERT INTO `province` VALUES ('66', 'Đắk Lắk', 'Tỉnh');
INSERT INTO `province` VALUES ('67', 'Đắk Nông', 'Tỉnh');
INSERT INTO `province` VALUES ('68', 'Lâm Đồng', 'Tỉnh');
INSERT INTO `province` VALUES ('70', 'Bình Phước', 'Tỉnh');
INSERT INTO `province` VALUES ('72', 'Tây Ninh', 'Tỉnh');
INSERT INTO `province` VALUES ('74', 'Bình Dương', 'Tỉnh');
INSERT INTO `province` VALUES ('75', 'Đồng Nai', 'Tỉnh');
INSERT INTO `province` VALUES ('77', 'Bà Rịa - Vũng Tàu', 'Tỉnh');
INSERT INTO `province` VALUES ('79', 'Hồ Chí Minh', 'Thành Phố');
INSERT INTO `province` VALUES ('80', 'Long An', 'Tỉnh');
INSERT INTO `province` VALUES ('82', 'Tiền Giang', 'Tỉnh');
INSERT INTO `province` VALUES ('83', 'Bến Tre', 'Tỉnh');
INSERT INTO `province` VALUES ('84', 'Trà Vinh', 'Tỉnh');
INSERT INTO `province` VALUES ('86', 'Vĩnh Long', 'Tỉnh');
INSERT INTO `province` VALUES ('87', 'Đồng Tháp', 'Tỉnh');
INSERT INTO `province` VALUES ('89', 'An Giang', 'Tỉnh');
INSERT INTO `province` VALUES ('91', 'Kiên Giang', 'Tỉnh');
INSERT INTO `province` VALUES ('92', 'Cần Thơ', 'Thành Phố');
INSERT INTO `province` VALUES ('93', 'Hậu Giang', 'Tỉnh');
INSERT INTO `province` VALUES ('94', 'Sóc Trăng', 'Tỉnh');
INSERT INTO `province` VALUES ('95', 'Bạc Liêu', 'Tỉnh');
INSERT INTO `province` VALUES ('96', 'Cà Mau', 'Tỉnh');

-- ----------------------------
-- Table structure for tbl_atm
-- ----------------------------
DROP TABLE IF EXISTS `tbl_atm`;
CREATE TABLE `tbl_atm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thanhpho` int(11) DEFAULT NULL,
  `quan` int(11) DEFAULT NULL,
  `phuong` int(11) DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total` int(50) DEFAULT NULL,
  `isactive` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tbl_atm
-- ----------------------------
INSERT INTO `tbl_atm` VALUES ('1', 'ATM0001', '48', '3', '21', '115 Nguyễn Tri Phương 123', '50000000', '1');
INSERT INTO `tbl_atm` VALUES ('2', 'ATM0002', '48', '2', '10', '28 Duy Tân', '50000000', '1');
INSERT INTO `tbl_atm` VALUES ('3', 'ATM0003', '48', '2', '10', '300 Duy Tân', '100000000', '1');
INSERT INTO `tbl_atm` VALUES ('4', 'ATM0004', '48', '1', '3', '10 Nguyễn Nhàn', '20000000', '1');
INSERT INTO `tbl_atm` VALUES ('5', 'ATM0005', '48', '4', '28', '300 Ngũ Hành Sơn', '100000000', '1');
INSERT INTO `tbl_atm` VALUES ('6', 'ATM0006', '48', '4', '28', '200 Ngũ Hành Sơn', '60000000', '1');

-- ----------------------------
-- Table structure for tbl_customer
-- ----------------------------
DROP TABLE IF EXISTS `tbl_customer`;
CREATE TABLE `tbl_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `thanhpho` int(11) DEFAULT NULL,
  `quan` int(11) DEFAULT NULL,
  `phuong` int(11) DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `sn_card` varchar(50) DEFAULT NULL,
  `soTKNH` varchar(50) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `isactive` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_customer
-- ----------------------------
INSERT INTO `tbl_customer` VALUES ('1', '123456', 'Trần Viết Hiệp', '48', '1', '6', '28 Nguyễn Trọng Nghĩa', '0969549903', 'tranviethiepdz@gmail.com', '123456', '123456', '0', '1');
INSERT INTO `tbl_customer` VALUES ('2', '78945613', 'Nguyễn Văn A', '48', '2', '7', '30 Hà Huy Tập', '0123456789', 'tradaviahe2017@gmail.com', '111111', '111111', '5000000', '1');
INSERT INTO `tbl_customer` VALUES ('3', '056677456', 'Trần Xuân Kỳ', '48', '1', '1', '28 Nguyễn Trọng Nghĩa', '0969549903', 'kybody@gmail.com', '222222', '222222', '1000000', '1');
INSERT INTO `tbl_customer` VALUES ('5', '051522246', 'Đặng Văn Quân', '48', '4', '28', '30 Hà Thị Thân', '0123456789', 'dangvanquan@gmail.com', '333333', '333333', '50000000', '1');
INSERT INTO `tbl_customer` VALUES ('7', '444444', 'Thái Gia Bảo', '48', '1', '1', '4 Lê Duẩn', '0966866668', 'daigiadn@gmail.com', '666666', '666666', '100000000', '1');
INSERT INTO `tbl_customer` VALUES ('8', '051151186', 'Nguyễn Quốc Khánh', '48', '6', '42', '28 Thanh Khê', '0125555555', 'khanhnq@gmail.com', '555555', '555555', '20000000', '1');

-- ----------------------------
-- Table structure for tbl_district
-- ----------------------------
DROP TABLE IF EXISTS `tbl_district`;
CREATE TABLE `tbl_district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tbl_district
-- ----------------------------
INSERT INTO `tbl_district` VALUES ('1', null, 'Cẩm lệ', 'Quận', '1');
INSERT INTO `tbl_district` VALUES ('2', null, 'Hải Châu', 'Quận', '1');
INSERT INTO `tbl_district` VALUES ('3', null, 'Liên Chiểu', 'Quận', '1');
INSERT INTO `tbl_district` VALUES ('4', null, 'Ngũ Hành Sơn', 'Quận', '1');
INSERT INTO `tbl_district` VALUES ('5', null, 'Sơn Trà', 'Quận', '1');
INSERT INTO `tbl_district` VALUES ('6', null, 'Thanh Khê', 'Quận', '1');
INSERT INTO `tbl_district` VALUES ('7', null, 'Hòa Vang', 'Quận', '1');
INSERT INTO `tbl_district` VALUES ('8', null, 'Hoàng Sa', 'Quận', '1');

-- ----------------------------
-- Table structure for tbl_transaction
-- ----------------------------
DROP TABLE IF EXISTS `tbl_transaction`;
CREATE TABLE `tbl_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `atm_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sn_card` int(50) DEFAULT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  `number` int(50) DEFAULT NULL,
  `isactive` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tbl_transaction
-- ----------------------------
INSERT INTO `tbl_transaction` VALUES ('4', '6fabd3d8-a2d7-462c-9937-573ae68a2d2e', 'ATM0001', '666666', '2018-04-27 11:42:59', '100000', '1');
INSERT INTO `tbl_transaction` VALUES ('5', '0d49698d-c3d0-4811-9d52-f21d43d473a7', 'ATM0001', '444444', '2018-04-27 11:44:21', '2000000', '1');
INSERT INTO `tbl_transaction` VALUES ('6', '4161988d-881a-4ab4-a176-0cb47f30aad1', 'ATM0001', '123456', '2018-04-27 11:46:06', '2000000', '1');
INSERT INTO `tbl_transaction` VALUES ('7', 'bbe60dc7-44cb-422f-9939-783c519d1ac1', 'ATM0001', '123456', '2018-04-27 11:48:42', '3000000', '1');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` tinyint(1) DEFAULT '0',
  `isactive` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', 'admin', '123456', '1', '1');

-- ----------------------------
-- Table structure for tbl_ward
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ward`;
CREATE TABLE `tbl_ward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `district_id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isactive` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tbl_ward
-- ----------------------------
INSERT INTO `tbl_ward` VALUES ('1', '1', 'Hòa An', null, '1');
INSERT INTO `tbl_ward` VALUES ('2', '1', 'Hòa Phát', null, '1');
INSERT INTO `tbl_ward` VALUES ('3', '1', 'Hòa Thọ Đông', null, '1');
INSERT INTO `tbl_ward` VALUES ('4', '1', 'Hòa Thọ Tây', null, '1');
INSERT INTO `tbl_ward` VALUES ('5', '1', 'Hòa Xuân', null, '1');
INSERT INTO `tbl_ward` VALUES ('6', '1', 'Khuê Trung', null, '1');
INSERT INTO `tbl_ward` VALUES ('7', '2', 'Thanh Bình', null, '1');
INSERT INTO `tbl_ward` VALUES ('8', '2', 'Thuận Phước', null, '1');
INSERT INTO `tbl_ward` VALUES ('9', '2', 'Thạch Thang', null, '1');
INSERT INTO `tbl_ward` VALUES ('10', '2', 'Hải Châu 1', null, '1');
INSERT INTO `tbl_ward` VALUES ('11', '2', 'Hải Châu 2', null, '1');
INSERT INTO `tbl_ward` VALUES ('12', '2', 'Phước Ninh', null, '1');
INSERT INTO `tbl_ward` VALUES ('13', '2', 'Hòa Thuận Tây', null, '1');
INSERT INTO `tbl_ward` VALUES ('14', '2', 'Hòa Thuận Đông', null, '1');
INSERT INTO `tbl_ward` VALUES ('15', '2', 'Nam Dương', null, '1');
INSERT INTO `tbl_ward` VALUES ('16', '2', 'Bình Hiên', null, '1');
INSERT INTO `tbl_ward` VALUES ('17', '2', 'Bình Thuận', null, '1');
INSERT INTO `tbl_ward` VALUES ('18', '2', 'Hòa Cường Bắc', null, '1');
INSERT INTO `tbl_ward` VALUES ('19', '2', 'Hòa Cường Nam', null, '1');
INSERT INTO `tbl_ward` VALUES ('20', '3', 'Hòa Minh', null, '1');
INSERT INTO `tbl_ward` VALUES ('21', '3', 'Hòa Khánh Nam', null, '1');
INSERT INTO `tbl_ward` VALUES ('22', '3', 'Hòa Khánh Bắc', null, '1');
INSERT INTO `tbl_ward` VALUES ('23', '3', 'Hòa Hiệp Nam', null, '1');
INSERT INTO `tbl_ward` VALUES ('24', '3', 'Hòa Hiệp Bắc', null, '1');
INSERT INTO `tbl_ward` VALUES ('25', '4', 'Hòa Hải', null, '1');
INSERT INTO `tbl_ward` VALUES ('26', '4', 'Hòa Quý', null, '1');
INSERT INTO `tbl_ward` VALUES ('27', '4', 'Khuê Mỹ', null, '1');
INSERT INTO `tbl_ward` VALUES ('28', '4', 'Mỹ An', null, '1');
INSERT INTO `tbl_ward` VALUES ('29', '5', 'An Hải Bắc', null, '1');
INSERT INTO `tbl_ward` VALUES ('30', '5', 'An Hải Đông', null, '1');
INSERT INTO `tbl_ward` VALUES ('31', '5', 'An Hải Tây', null, '1');
INSERT INTO `tbl_ward` VALUES ('32', '5', 'Mân Thái', null, '1');
INSERT INTO `tbl_ward` VALUES ('33', '5', 'Nại Hiên Đông', null, '1');
INSERT INTO `tbl_ward` VALUES ('34', '5', 'Phước Mỹ', null, '1');
INSERT INTO `tbl_ward` VALUES ('35', '5', 'Thọ Quang', null, '1');
INSERT INTO `tbl_ward` VALUES ('36', '6', 'An Khê', null, '1');
INSERT INTO `tbl_ward` VALUES ('37', '6', 'Chính Gián', null, '1');
INSERT INTO `tbl_ward` VALUES ('38', '6', 'Hòa Khê', null, '1');
INSERT INTO `tbl_ward` VALUES ('39', '6', 'Tam Thuận', null, '1');
INSERT INTO `tbl_ward` VALUES ('40', '6', 'Tân Chính', null, '1');
INSERT INTO `tbl_ward` VALUES ('41', '6', 'Thạc Gián', null, '1');
INSERT INTO `tbl_ward` VALUES ('42', '6', 'Thanh Khê Đông', null, '1');
INSERT INTO `tbl_ward` VALUES ('43', '6', 'Thanh Khê Tây', null, '1');
INSERT INTO `tbl_ward` VALUES ('44', '6', 'Vĩnh Trung', null, '1');
INSERT INTO `tbl_ward` VALUES ('45', '6', 'Xuân Hà', null, '1');
INSERT INTO `tbl_ward` VALUES ('46', '7', 'Hòa Bắc', null, '1');
INSERT INTO `tbl_ward` VALUES ('47', '7', 'Hòa Châu', null, '1');
INSERT INTO `tbl_ward` VALUES ('48', '7', 'Hòa Khương', null, '1');
INSERT INTO `tbl_ward` VALUES ('49', '7', 'Hòa Liên', null, '1');
INSERT INTO `tbl_ward` VALUES ('50', '7', 'Hòa Nhơn', null, '1');
INSERT INTO `tbl_ward` VALUES ('51', '7', 'Hòa Ninh', null, '1');
INSERT INTO `tbl_ward` VALUES ('52', '7', 'Hòa Phong', null, '1');
INSERT INTO `tbl_ward` VALUES ('53', '7', 'Hòa Phú', null, '1');
INSERT INTO `tbl_ward` VALUES ('54', '7', 'Hòa Phước', null, '1');
INSERT INTO `tbl_ward` VALUES ('55', '7', 'Hòa Sơn', null, '1');
INSERT INTO `tbl_ward` VALUES ('56', '7', 'Hòa Tiến', null, '1');
INSERT INTO `tbl_ward` VALUES ('57', '8', 'đảo Hoàng Sa', null, '1');
INSERT INTO `tbl_ward` VALUES ('58', '8', 'đảo Đá Bắc', null, '1');
INSERT INTO `tbl_ward` VALUES ('59', '8', 'đảo Hữu Nhật', null, '1');
INSERT INTO `tbl_ward` VALUES ('60', '8', 'đả Đá Lồi', null, '1');
INSERT INTO `tbl_ward` VALUES ('61', '8', 'đảo Bạch Quy', null, '1');
INSERT INTO `tbl_ward` VALUES ('62', '8', 'đảo Tri Tôn', null, '1');
INSERT INTO `tbl_ward` VALUES ('63', '8', 'đảo Cây', null, '1');
INSERT INTO `tbl_ward` VALUES ('64', '8', 'đảo Bắc', null, '1');
INSERT INTO `tbl_ward` VALUES ('65', '8', 'đảo Giữa', null, '1');
INSERT INTO `tbl_ward` VALUES ('66', '8', 'đảo Nam', null, '1');
INSERT INTO `tbl_ward` VALUES ('67', '8', 'đảo Phú Lâm', null, '1');
INSERT INTO `tbl_ward` VALUES ('68', '8', 'đảo Linh Côn', null, '1');
INSERT INTO `tbl_ward` VALUES ('69', '8', 'đảo Quang Hòa', null, '1');
INSERT INTO `tbl_ward` VALUES ('70', '8', 'cồn Bông Bay', null, '1');
INSERT INTO `tbl_ward` VALUES ('71', '8', 'cồn Quan Sát', null, '1');
INSERT INTO `tbl_ward` VALUES ('72', '8', 'cồn Cát Tây', null, '1');
INSERT INTO `tbl_ward` VALUES ('73', '8', 'đá Chim Yến', null, '1');
INSERT INTO `tbl_ward` VALUES ('74', '8', 'đá Tháp', null, '1');
