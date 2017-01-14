/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2016-09-08 17:28:55
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for `demouser`
-- ----------------------------
DROP TABLE IF EXISTS `demouser`;
CREATE TABLE `demouser` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `lastUpdate` timestamp NULL DEFAULT NULL,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



