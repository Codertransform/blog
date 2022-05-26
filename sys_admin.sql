/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2022-05-26 21:15:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `sex` char(2) NOT NULL COMMENT '性别',
  `phone` varchar(18) NOT NULL COMMENT '电话',
  `email` varchar(25) NOT NULL COMMENT '邮箱',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `signature` text COMMENT '个性签名',
  `enable` tinyint(1) NOT NULL COMMENT '账号是否可用(''0''-启用,''1''-停用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('1', 'gxhbj', '$10$2uCTkkItMcnA.kpKhn9YsOVgzHz8HSHOqGHhToqdRewpFtozS9K8e', 'echoMikes', '0', '15769271840', '18204099093@163.com', null, '2022-05-26 21:12:16', null, null, '1');
INSERT INTO `sys_admin` VALUES ('2', 'test', ' ', '123', '0', '15769271840', '18204099093@163.com', null, '2022-05-26 21:12:46', null, null, '1');
INSERT INTO `sys_admin` VALUES ('3', 'admin', '$2a$10$aHpK2QrfWKEDukKWv7Fd9ubXaWV/aPFBtYs1VZmtIsNrWvu95k2Bq', '超级无敌小可爱', '1', '15769271840', '18204099093@163.com', '1992-09-08', '2020-04-26 00:00:00', '2022-05-26 21:04:26', '拥有至高无上的权力', '0');
