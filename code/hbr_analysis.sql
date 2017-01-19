/*
 Navicat Premium Data Transfer

 Source Server         : oracle-linux-r5-mysql
 Source Server Type    : MySQL
 Source Server Version : 50095
 Source Host           : 10.211.55.6
 Source Database       : hbr_analysis

 Target Server Type    : MySQL
 Target Server Version : 50095
 File Encoding         : utf-8

 Date: 01/10/2017 02:11:56 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `patient`
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `gender` char(1) default NULL,
  `position` varchar(255) default NULL COMMENT '床位',
  `doctor_login_name` varchar(11) default NULL COMMENT '负责医生的username',
  `heart_identifier` varchar(30) default NULL COMMENT '病人的数据标识',
  `sd1` double default NULL,
  `sd2` double default NULL,
  `health_status` varchar(255) default NULL COMMENT '健康： healthy   不健康： unhealthy',
  `treat_status` varchar(255) default NULL COMMENT '状态： 治疗中 - treating  出院 - finished',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `patient`
-- ----------------------------
BEGIN;
INSERT INTO `patient` VALUES ('1', '张xxx', '男', '6床', 'baiyanan', '1', null, null, null, 'treating'), ('2', '吴xxds', '男', '7床', 'baiyanan', '2', null, null, null, 'treating');
COMMIT;

-- ----------------------------
--  Table structure for `patient_result`
-- ----------------------------
DROP TABLE IF EXISTS `patient_result`;
CREATE TABLE `patient_result` (
  `id` int(11) NOT NULL auto_increment,
  `patient_id` int(11) default NULL,
  `sd1` double default NULL,
  `sd2` double default NULL,
  `health_status` varchar(255) default NULL COMMENT 'healthy,    unhealthy',
  `log_time` datetime default NULL COMMENT '记录时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `patient_result`
-- ----------------------------
BEGIN;
INSERT INTO `patient_result` VALUES ('1', '1', '0.396408249157355', '0.604868580767757', '1', '2017-01-09 22:56:10'), ('2', '2', '123', '123', 'healthy', null);
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(40) default NULL,
  `gender` char(1) default NULL COMMENT '男：M,  女：F',
  `role` varchar(20) default NULL COMMENT '角色：医生： doctor,  管理员： admin, 普通用户：common',
  `pwd_salt` varchar(10) default NULL COMMENT '密码盐',
  `status` varchar(10) default NULL COMMENT 'active, not_active',
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('baiyanan', '白亚楠', '123456', 'F', 'doctor', null, 'active'), ('lpxiang', '李鹏翔', '123456', 'M', 'admin', 'n!er3rw', 'active'), ('wangchang', '王畅', '123456', 'M', 'common', null, 'active'), ('xxiang', 'XXXiang', '123456', 'M', 'common', null, 'active');
COMMIT;

-- ----------------------------
--  Table structure for `user_result`
-- ----------------------------
DROP TABLE IF EXISTS `user_result`;
CREATE TABLE `user_result` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL COMMENT 'common user的username',
  `sd1` double default NULL,
  `sd2` double default NULL,
  `health_status` varchar(255) default NULL COMMENT 'unhealthy,  healthy',
  `log_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_result`
-- ----------------------------
BEGIN;
INSERT INTO `user_result` VALUES ('1', '123', '123', '123', 'healthy', '2015-05-06 00:00:00'), ('2', '123', '123', '123', 'healthy', '2017-01-09 20:59:36'), ('3', 'zh', '0.106723227428369', '0.163437246648267', 'unhealthy', '2017-01-08 21:18:03'), ('4', 'zh', '0.106723227428369', '0.163437246648267', 'unhealthy', '2017-01-08 21:19:49'), ('5', 'zh', '0.106723227428369', '0.163437246648267', 'unhealthy', '2017-01-09 10:51:30'), ('6', 'zh', '0.106723227428369', '0.163437246648267', 'unhealthy', '2017-01-09 10:52:51'), ('7', 'zh', '0.106723227428369', '0.163437246648267', 'unhealthy', '2017-01-09 13:22:13');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
