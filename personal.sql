/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : personal

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-05-13 12:27:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept_inf`
-- ----------------------------
DROP TABLE IF EXISTS `dept_inf`;
CREATE TABLE `dept_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `emp_id` int(20) DEFAULT NULL,
  `localpay` int(50) DEFAULT NULL COMMENT '基本工资',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept_inf
-- ----------------------------
INSERT INTO `dept_inf` VALUES ('3', '研发线', null, null, null);
INSERT INTO `dept_inf` VALUES ('4', '测试线', null, null, null);
INSERT INTO `dept_inf` VALUES ('5', '职能线', null, null, null);
INSERT INTO `dept_inf` VALUES ('1', '产品线', null, null, null);
INSERT INTO `dept_inf` VALUES ('2', '实施线', null, null, null);

-- ----------------------------
-- Table structure for `document_inf`
-- ----------------------------
DROP TABLE IF EXISTS `document_inf`;
CREATE TABLE `document_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `filename` varchar(300) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of document_inf
-- ----------------------------
INSERT INTO `document_inf` VALUES ('1', '2,2', '01.jpg', null, null, null);
INSERT INTO `document_inf` VALUES ('2', '2,2', '01.jpg', null, null, null);
INSERT INTO `document_inf` VALUES ('3', '4', '2.jpg', '4', null, null);
INSERT INTO `document_inf` VALUES ('4', '1', '1.jpg', '1', null, null);
INSERT INTO `document_inf` VALUES ('5', '2', '1.jpg', '2', null, null);
INSERT INTO `document_inf` VALUES ('6', '2', '1.jpg', '2', null, null);
INSERT INTO `document_inf` VALUES ('7', '3', '5.jpg', '3', null, null);
INSERT INTO `document_inf` VALUES ('8', '2', '5.jpg', '2', null, null);

-- ----------------------------
-- Table structure for `employee_inf`
-- ----------------------------
DROP TABLE IF EXISTS `employee_inf`;
CREATE TABLE `employee_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '姓名',
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(11) DEFAULT NULL COMMENT '性别',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `polic` varchar(255) DEFAULT NULL COMMENT '政治面貌',
  `born` varchar(255) DEFAULT NULL COMMENT '出生日期',
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `education` varchar(50) DEFAULT NULL,
  `card_id` varchar(100) DEFAULT NULL,
  `createdate` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=201911 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_inf
-- ----------------------------
INSERT INTO `employee_inf` VALUES ('201901', '张三', '男', null, null, null, '12345', '123@qq.com', '本科', '1234567809', '2019-4-27');
INSERT INTO `employee_inf` VALUES ('201902', '赵七', '女', null, null, null, '8888', '1443037346@qq.com', '本科', '11', '2019-05-09');
INSERT INTO `employee_inf` VALUES ('201910', '赵七', '男', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for `job_inf`
-- ----------------------------
DROP TABLE IF EXISTS `job_inf`;
CREATE TABLE `job_inf` (
  `id` int(11) DEFAULT NULL COMMENT '与部门id相同',
  `name` varchar(50) DEFAULT NULL COMMENT '岗位名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '岗位描述',
  `emp_id` int(20) DEFAULT NULL,
  `jobpay` int(50) DEFAULT NULL COMMENT '岗位薪资',
  `dept_id` int(11) DEFAULT NULL COMMENT '与部门表的job_id相对应'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_inf
-- ----------------------------
INSERT INTO `job_inf` VALUES ('1', '产品经理', '', null, null, null);
INSERT INTO `job_inf` VALUES ('1', '产品设计师', null, null, null, null);
INSERT INTO `job_inf` VALUES ('2', '实施工程师', null, null, null, null);
INSERT INTO `job_inf` VALUES ('3', '研发工程师', null, null, null, null);
INSERT INTO `job_inf` VALUES ('4', '测试工程师', null, null, null, null);

-- ----------------------------
-- Table structure for `notice_inf`
-- ----------------------------
DROP TABLE IF EXISTS `notice_inf`;
CREATE TABLE `notice_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `create_date` char(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice_inf
-- ----------------------------
INSERT INTO `notice_inf` VALUES ('1', '1112', '132323', null, null);
INSERT INTO `notice_inf` VALUES ('2', '444', '4444', null, null);

-- ----------------------------
-- Table structure for `user_inf`
-- ----------------------------
DROP TABLE IF EXISTS `user_inf`;
CREATE TABLE `user_inf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `createdate` char(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_inf
-- ----------------------------
INSERT INTO `user_inf` VALUES ('59', '111', '1', '2019-05-28', '张三');
INSERT INTO `user_inf` VALUES ('65', '222', '2', '2019-05-09', '李四');
INSERT INTO `user_inf` VALUES ('66', '333', '3', '2019-05-09', '王五');
