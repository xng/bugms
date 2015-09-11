/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50542
Source Host           : localhost:3306
Source Database       : bugms

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2015-09-11 18:23:33
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
  `bug_status` int(1) NOT NULL,
  `bak1` varchar(10) DEFAULT NULL,
  `bak2` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bug
-- ----------------------------
INSERT INTO `bug` VALUES ('1', '2', '2015-09-11 17:24:10', '2', '2015-09-11 17:24:10', 'dsfds是', 'fsdsdf地方', '2', '3', '2015-09-11 17:24:10', '0', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '用户管理', 'user/user.do', 'admin', '1', null);
INSERT INTO `menu` VALUES ('2', '新建Bug', 'bug/new_bug.do', 'tester', '1', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(12) NOT NULL,
  `user_pwd` varchar(50) NOT NULL,
  `user_name` varchar(12) NOT NULL,
  `user_role` varchar(10) NOT NULL,
  `user_mail` varchar(50) NOT NULL,
  `user_status` int(1) NOT NULL,
  `user_bak1` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '43442676c74ae59f219c2d87fd6bad52', '管理员', 'admin', 'admin@admin.com', '1', null);
INSERT INTO `user` VALUES ('2', 'caixiaolong', 'd89267ba6e888426c8f798a04f2fb874', '蔡小龙', 'tester', 'cc@cail.cc', '1', null);
INSERT INTO `user` VALUES ('3', 'caizhifei', 'd89267ba6e888426c8f798a04f2fb874', '蔡志飞', 'dev', 'i@cail.cc', '1', null);
