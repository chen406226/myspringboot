/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : votes

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-11-05 15:37:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `candidates`
-- ----------------------------
DROP TABLE IF EXISTS `candidates`;
CREATE TABLE `candidates` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `info` varchar(100) NOT NULL,
  `uname` varchar(100) DEFAULT NULL,
  `checkkey` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of candidates
-- ----------------------------
INSERT INTO `candidates` VALUES ('1', '陈坤', '中华民国大总统；就', 'sdf', 'sdf');

-- ----------------------------
-- Table structure for `votes`
-- ----------------------------
DROP TABLE IF EXISTS `votes`;
CREATE TABLE `votes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `candidates_id` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `money` double(16,2) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_code` (`code`),
  KEY `fk_candidatesId` (`candidates_id`),
  CONSTRAINT `fk_candidatesId` FOREIGN KEY (`candidates_id`) REFERENCES `candidates` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of votes
-- ----------------------------
INSERT INTO `votes` VALUES ('7', '1', '23434343234334', '0000000000022.34');
INSERT INTO `votes` VALUES ('9', '1', '23434343234334x', '0000000000022.34');
INSERT INTO `votes` VALUES ('10', '1', '88888888888888888', '0000000000014.00');
INSERT INTO `votes` VALUES ('11', '1', '54333333333333331', '0000000000048.00');
INSERT INTO `votes` VALUES ('12', '1', '437445635646546534', '0000000000002.00');
