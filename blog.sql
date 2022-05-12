/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2022-05-12 17:41:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

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
  `status` int(4) NOT NULL COMMENT '启用/封禁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('1', 'gxhbj', '$2a$10$2uCTkkItMcnA.kpKhn9YsOVgzHz8HSHOqGHhToqdRewpFtozS9K8e', '环保局', '0', '13556789876', '13556789876@163.com', null, '2020-08-12 22:57:45', '2020-10-26 23:53:38', null, '1');
INSERT INTO `sys_admin` VALUES ('2', 'test', '', '测试', '0', '15769271840', '18204099093@163.com', null, '2020-08-24 09:37:46', '2020-09-14 11:20:06', null, '1');
INSERT INTO `sys_admin` VALUES ('3', 'admin', '$2a$10$aHpK2QrfWKEDukKWv7Fd9ubXaWV/aPFBtYs1VZmtIsNrWvu95k2Bq', '超级无敌小可爱', '1', '15769271840', '18204099093@163.com', '1992-09-08', '2020-04-26 00:00:00', '2022-05-12 17:16:23', '拥有至高无上的权力', '1');

-- ----------------------------
-- Table structure for sys_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin_role`;
CREATE TABLE `sys_admin_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_id` int(10) NOT NULL COMMENT '用户id',
  `role_id` int(10) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `USER_ROLE_ID` (`role_id`) USING BTREE,
  KEY `ROLE_USER_ID` (`admin_id`) USING BTREE,
  CONSTRAINT `sys_admin_role_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `sys_admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_admin_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of sys_admin_role
-- ----------------------------
INSERT INTO `sys_admin_role` VALUES ('1', '3', '1');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pId` int(10) NOT NULL COMMENT '父节点Id',
  `name` varchar(20) NOT NULL COMMENT '节点名称',
  `url` varchar(100) DEFAULT NULL COMMENT '连接',
  `sort` int(5) DEFAULT NULL COMMENT '序号',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限节点表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `sys_persistent_logins`;
CREATE TABLE `sys_persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_persistent_logins
-- ----------------------------
INSERT INTO `sys_persistent_logins` VALUES ('test', '+IJfo3q3Qmj1oL+gmi5PeQ==', '9WL1r0V0wq5RB81R5pSUnA==', '2020-09-03 17:19:49');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '+tMhrfUiKyuF694LX9xWHg==', 'a7GciK91PfOU/qKHU2T/Zw==', '2021-05-21 20:58:58');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '27+bs9GD9DR9HO2WqhZgOA==', 'CisBsm7OflGJjIqF7MzzXg==', '2021-07-28 17:28:09');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '7yB/K+OCtUSfnb2j/errvw==', '251EcXkQSw+qNM6gcWcS+Q==', '2021-06-01 09:45:29');
INSERT INTO `sys_persistent_logins` VALUES ('admin', '9xNIiAQRLAsypYCtgUIzHQ==', 'Nygyrh2VwDF5cI3glqrn6w==', '2021-07-29 12:46:56');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'CpfwdMHF/UBp/f3Qp44FSA==', 'Z9+KdIH0pp9Tj7yB3/wiXw==', '2021-06-02 11:08:29');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'cVrfVpOxh2v9/ufGFDWINA==', 'tTmtQs9Xdlaim5V40xFr6w==', '2021-07-29 11:18:22');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'e8BI1XldlXCkxBmNKDBwuA==', 'X1SfTW050fYQTzLoR9+6RQ==', '2021-05-21 11:28:33');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'EyREuLCuR/lAD4+JH1tuYA==', 'Hr/OuH6y1l4zlU/Ht8AX4A==', '2021-08-03 16:46:25');
INSERT INTO `sys_persistent_logins` VALUES ('test', 'HPhI5xcOZ1Iu7LkQt3oIzQ==', 'l0DHFNqwTcloc0lj5tDJrw==', '2020-08-25 12:01:40');
INSERT INTO `sys_persistent_logins` VALUES ('test', 'IWUdprFN/j6LxgduTrx7aA==', 'Y9S4Ktz5IyOCkJSx85b88w==', '2021-01-19 11:15:27');
INSERT INTO `sys_persistent_logins` VALUES ('test', 'lNdpJqj56wnWdkIBcTYcEA==', '8eESyi5ClCn1JdWdawbmBg==', '2020-09-14 11:20:06');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'NEfS/voIsu2VKU0IO976wA==', 'Y3y+f12M0IVyTuyPGz+qsw==', '2021-05-24 11:46:12');
INSERT INTO `sys_persistent_logins` VALUES ('test', 'nUQ7M9r7fWxxJKifipPX9g==', 'iDAfGom0n+DOQUi72QqKCA==', '2020-08-26 10:51:39');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'OEx8v36+9D8uIuOQItNlbA==', 'BkdZt9ewQ+wAyX+7wU0gJQ==', '2021-07-29 16:44:07');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'PCetd5oELq+8oMVcUSCVyw==', '0Opwufb/98Rzm8uebJafIw==', '2021-05-25 22:39:04');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'q0SvPE3qbYycvHRQm2y+SQ==', 'vLLPU+VZ5JpaE8EilEYOcQ==', '2021-05-21 11:25:12');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'qBUL31Eimg3Ort9qYNZo1g==', 's+qiQNAqdvHfBU9MmcDTeA==', '2021-05-22 23:22:23');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'qd9HvbaqG1qYx8TmnFOasg==', 'SsJqt5+QSDuMdV7q2OZ1tw==', '2021-06-01 22:19:23');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'RaekiHW7vENei7uYlmPWjA==', 'MuFrk/CFVnQWWM4F2/khCA==', '2021-05-21 15:18:22');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'RS8AryKTDvknV9cfmwka9w==', 'Jy33vrRvnsHYieq0pXnwiw==', '2021-06-07 10:11:36');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'sNQKWAvCraNzSiejsdhyGA==', 'fN015Jki3cPPQVFpfn6kTw==', '2021-06-07 11:26:20');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'sYDHdFukHNUhkv5GXeaQsw==', 'jgaqEPg5s0i3xm/VuA+Y3w==', '2021-08-03 11:20:00');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'TBt+JmExaDnMuv4wHBd+8A==', 'mge0bufo5Us9WYkKnfIjhA==', '2021-06-01 16:08:02');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'uygQBhfZqHDuxH0OTHMfaw==', '3zSDQ0+uFBRS+skPa5ooDA==', '2021-05-21 15:38:57');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'V8Bc6FVQtia8OR4xbYuCdA==', 'vbV4HHD01b7oaIpnQJRAgg==', '2021-05-21 11:27:15');
INSERT INTO `sys_persistent_logins` VALUES ('test', 'XakQJHlgdnLYrvB1nuvX4w==', 'Uc3qlhC7Aa2z0ZqQ727d/w==', '2020-08-25 15:22:33');
INSERT INTO `sys_persistent_logins` VALUES ('admin', 'YxoRTByMdWkSjHe2bAMwrw==', 'wbjllgB36OSLm4fDRtq0Tg==', '2021-07-29 13:52:02');

-- ----------------------------
-- Table structure for sys_rental_strategy
-- ----------------------------
DROP TABLE IF EXISTS `sys_rental_strategy`;
CREATE TABLE `sys_rental_strategy` (
  `id` varchar(64) NOT NULL,
  `numbering` varchar(20) NOT NULL COMMENT '策略编号',
  `name` varchar(10) NOT NULL COMMENT '策略名称',
  `remarks` varchar(100) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组策策略表';

-- ----------------------------
-- Records of sys_rental_strategy
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '角色名',
  `flag` varchar(10) NOT NULL COMMENT '角色标志',
  `description` varchar(10) NOT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'ROLE_ADMIN', '拥有至高无上的权利');
INSERT INTO `sys_role` VALUES ('2', '用户', 'ROLE_GXHBJ', '一般用户');
INSERT INTO `sys_role` VALUES ('3', '高新环保分局', 'ROLE_USER', '一般权限');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) NOT NULL COMMENT '角色id',
  `permission_id` int(10) NOT NULL COMMENT '权限节点id',
  PRIMARY KEY (`id`),
  KEY `ROLE_PERMISSION_ID` (`role_id`) USING BTREE,
  KEY `PERMISSION_ROLE_ID` (`permission_id`) USING BTREE,
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
