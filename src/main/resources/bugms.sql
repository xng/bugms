/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50542
Source Host           : 127.0.0.1:3306
Source Database       : bugms

Target Server Type    : MYSQL
Target Server Version : 50542
File Encoding         : 65001

Date: 2015-09-13 21:32:38
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
  `bug_desc` varchar(200) NOT NULL,
  `bug_level` int(11) NOT NULL,
  `assign_id` int(11) NOT NULL,
  `assign_time` datetime NOT NULL,
  `bug_status` int(1) NOT NULL,
  `bak1` varchar(10) DEFAULT NULL,
  `bak2` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bug
-- ----------------------------
INSERT INTO `bug` VALUES ('1', '2', '2015-09-13 17:17:34', '2', '2015-09-13 21:15:01', 'dsfds是sd', 'fsdsdf地方s', '2', '3', '2015-09-11 17:24:10', '2', null, null);
INSERT INTO `bug` VALUES ('2', '2', '2015-09-11 23:32:49', '2', '2015-09-11 23:32:49', 'ewrwer22', '32423sd', '1', '3', '2015-09-11 20:41:06', '0', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bug_log
-- ----------------------------
INSERT INTO `bug_log` VALUES ('1', '1', '2015-09-13 20:51:51', '3', '不予处理', '不会', null);
INSERT INTO `bug_log` VALUES ('2', '1', '2015-09-13 20:53:43', '3', '不予处理', 'sdfs的', null);
INSERT INTO `bug_log` VALUES ('3', '1', '2015-09-13 21:14:30', '2', '未解决', '明明没解决', null);
INSERT INTO `bug_log` VALUES ('4', '1', '2015-09-13 21:14:46', '3', '已修正', '这次真的改了', null);
INSERT INTO `bug_log` VALUES ('5', '1', '2015-09-13 21:15:01', '2', '关闭', '可以了', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '用户管理', 'user/user.do', 'admin', '1', null);
INSERT INTO `menu` VALUES ('2', '新建Bug', 'bug/new_bug.do', 'tester', '1', null);
INSERT INTO `menu` VALUES ('3', 'Bug列表', 'bug/bugs.do', 'tester', '1', null);
INSERT INTO `menu` VALUES ('4', 'Bug列表', 'bug/bugs.do', 'dev', '1', null);
INSERT INTO `menu` VALUES ('5', 'Bug统计', 'bug/bug_count.do', 'man', '1', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '43442676c74ae59f219c2d87fd6bad52', '管理员', 'admin', 'admin@admin.com', '1', null);
INSERT INTO `user` VALUES ('2', 'caixiaolong', 'd89267ba6e888426c8f798a04f2fb874', '蔡小龙', 'tester', 'cc@cail.cc', '1', null);
INSERT INTO `user` VALUES ('3', 'caizhifei', 'd89267ba6e888426c8f798a04f2fb874', '蔡志飞', 'dev', 'i@cail.cc', '1', null);
INSERT INTO `user` VALUES ('4', 'man', 'd89267ba6e888426c8f798a04f2fb874', 'cail.cc', 'man', 'm@cail.cc', '1', null);
