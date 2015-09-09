/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50542
Source Host           : localhost:3306
Source Database       : bugms

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2015-09-09 12:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bug
-- ----------------------------
DROP TABLE IF EXISTS `bug`;
CREATE TABLE `bug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_id` int(11) NOT NULL,
  `update_time` datetime NOT NULL,
  `bug_title` varchar(30) NOT NULL,
  `bug_desc` text NOT NULL,
  `bug_level` int(11) NOT NULL,
  `assign_id` int(11) NOT NULL,
  `assign_time` datetime NOT NULL,
  `bak1` varchar(10) DEFAULT NULL,
  `bak2` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bug
-- ----------------------------

-- ----------------------------
-- Table structure for bug_log
-- ----------------------------
DROP TABLE IF EXISTS `bug_log`;
CREATE TABLE `bug_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bug_id` int(11) NOT NULL,
  `update_time` datetime NOT NULL,
  `update_id` int(11) NOT NULL,
  `operation` varchar(10) NOT NULL,
  `op_remark` varchar(200) DEFAULT NULL,
  `bak1` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bug_log
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(10) NOT NULL,
  `menu_url` varchar(25) NOT NULL,
  `menu_role` varchar(10) NOT NULL,
  `menu_status` int(1) NOT NULL,
  `bak1` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(12) NOT NULL,
  `user_pwd` varchar(30) NOT NULL,
  `user_name` varchar(12) NOT NULL,
  `user_role` varchar(10) NOT NULL,
  `user_mail` varchar(50) NOT NULL,
  `user_status` int(1) NOT NULL,
  `user_bak1` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
