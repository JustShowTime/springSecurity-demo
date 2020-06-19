/*
Navicat MySQL Data Transfer

Source Server         : 192.168.100.253-cms
Source Server Version : 50729
Source Host           : 192.168.100.253:3306
Source Database       : czq_security

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-06-19 18:03:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enable` tinyint(4) DEFAULT NULL COMMENT '用户是否可用',
  `roles` text COMMENT '用户角色，多个用户角色之间用逗号隔开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123', '1', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `users` VALUES ('2', 'user', '123', '1', 'ROLE_USER');
