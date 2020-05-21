/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : dept

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/05/2020 19:10:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) DEFAULT NULL,
  `loc` varchar(255) DEFAULT NULL,
  `deleted` int DEFAULT '0',
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` VALUES (1, '哈哈哈121123', '我在河南呀', 0);
INSERT INTO `dept` VALUES (2, '人事部11', '北京', 0);
INSERT INTO `dept` VALUES (3, '开发部', '上海', 0);
INSERT INTO `dept` VALUES (4, '是我i吗', '我么明年一起', 0);
INSERT INTO `dept` VALUES (5, '5是是是', '5委屈委屈', 0);
INSERT INTO `dept` VALUES (6, '6666', '6666', 0);
INSERT INTO `dept` VALUES (8, '8', '8', 0);
INSERT INTO `dept` VALUES (9, '9', '9', 1);
INSERT INTO `dept` VALUES (10, '10shishi', '实验', 0);
INSERT INTO `dept` VALUES (12, '哈哈哈', '我在河南呀', 0);
INSERT INTO `dept` VALUES (13, '哈哈哈', '我在河南呀', 0);
INSERT INTO `dept` VALUES (14, '河南省', '周口市', 0);
INSERT INTO `dept` VALUES (15, '河南省', '周口市', 1);
INSERT INTO `dept` VALUES (16, '111', '111', 1);
INSERT INTO `dept` VALUES (17, '12被删了还能看？', '123', 1);
INSERT INTO `dept` VALUES (18, '哈哈哈123', '我在河南呀', 0);
INSERT INTO `dept` VALUES (19, '哈哈哈123', '我在河南呀', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
