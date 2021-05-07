/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : campus

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 07/05/2021 09:42:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员id，自增，唯一',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号，唯一',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号密码',
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '管理员姓名',
  `sex` bit(1) NOT NULL DEFAULT b'0' COMMENT '性别，0为男生，1为女生',
  `registry_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '账号注册时间',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `state` int(0) NULL DEFAULT 0 COMMENT '管理员权限，便于后续开发',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `account`(`account`(20)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'dougMagic', 'h8519522', 'Darby Jones', b'0', '2021-05-04 09:22:03', '18756106453', '962339285@qq.com', '1220753556', 4);

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  FULLTEXT INDEX `content`(`content`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('                就是用于测试，公告是否可以修改，应该是可以修改的，我很调皮');

-- ----------------------------
-- Table structure for class_place
-- ----------------------------
DROP TABLE IF EXISTS `class_place`;
CREATE TABLE `class_place`  (
  `experiment_place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `college_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`experiment_place`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_place
-- ----------------------------
INSERT INTO `class_place` VALUES ('A418', '物理学院');
INSERT INTO `class_place` VALUES ('A420', '物理学院');
INSERT INTO `class_place` VALUES ('B401', '物理学院');
INSERT INTO `class_place` VALUES ('B402', '物理学院');
INSERT INTO `class_place` VALUES ('B403', '物理学院');
INSERT INTO `class_place` VALUES ('B404', '物理学院');
INSERT INTO `class_place` VALUES ('B405', '物理学院');
INSERT INTO `class_place` VALUES ('B406', '物理学院');
INSERT INTO `class_place` VALUES ('B408', '物理学院');
INSERT INTO `class_place` VALUES ('B409', '物理学院');
INSERT INTO `class_place` VALUES ('B410', '物理学院');
INSERT INTO `class_place` VALUES ('B411', '物理学院');
INSERT INTO `class_place` VALUES ('B412', '物理学院');
INSERT INTO `class_place` VALUES ('B413', '物理学院');
INSERT INTO `class_place` VALUES ('B414', '物理学院');
INSERT INTO `class_place` VALUES ('B415', '物理学院');
INSERT INTO `class_place` VALUES ('B416', '物理学院');
INSERT INTO `class_place` VALUES ('B417', '物理学院');
INSERT INTO `class_place` VALUES ('B418', '物理学院');
INSERT INTO `class_place` VALUES ('B419', '物理学院');
INSERT INTO `class_place` VALUES ('B420', '物理学院');
INSERT INTO `class_place` VALUES ('B421', '物理学院');
INSERT INTO `class_place` VALUES ('B422', '物理学院');
INSERT INTO `class_place` VALUES ('B428', '物理学院');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `college_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `college_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学院名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '学院描述',
  PRIMARY KEY (`college_id`) USING BTREE,
  UNIQUE INDEX `college_name`(`college_name`(10)) USING BTREE,
  FULLTEXT INDEX `description`(`description`)
) ENGINE = InnoDB AUTO_INCREMENT = 100117 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (100101, '矿业学院', '矿业学院描述');
INSERT INTO `college` VALUES (100102, '安全学院', '安全学院描述');
INSERT INTO `college` VALUES (100103, '机电工程学院', '机电工程学院描述');
INSERT INTO `college` VALUES (100104, '计算机科学学院', '计算机科学学院描述');
INSERT INTO `college` VALUES (100105, '软件工程学院', '软件工程学院描述');
INSERT INTO `college` VALUES (100106, '力学与建筑设计学院', '力学与建筑设计学院描述');
INSERT INTO `college` VALUES (100107, '土木工程学院', '土木工程学院描述');
INSERT INTO `college` VALUES (100108, '艺术与设计学院', '艺术与设计学院描述');
INSERT INTO `college` VALUES (100109, '管理学院', '管理学院描述');
INSERT INTO `college` VALUES (100110, '文法学院', '文法学院描述');
INSERT INTO `college` VALUES (100111, '国际学院', '国际学院描述');
INSERT INTO `college` VALUES (100112, '化工学院', '化工学院描述');
INSERT INTO `college` VALUES (100113, '电力学院', '电力学院描述');
INSERT INTO `college` VALUES (100114, '材料学院', '材料学院描述');
INSERT INTO `college` VALUES (100115, '物理学院', '物理学院描述');
INSERT INTO `college` VALUES (100116, '马克思主义学院', '马克思主义学院描述');

-- ----------------------------
-- Table structure for experiment
-- ----------------------------
DROP TABLE IF EXISTS `experiment`;
CREATE TABLE `experiment`  (
  `experiment_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '每个物理实验唯一标识符',
  `experiment_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '物理实验名称',
  `experiment_time` timestamp(0) NOT NULL COMMENT '实验上课时间',
  `week_day` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '星期几',
  `experiment_place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实验地点',
  `teacher_id` int(0) NOT NULL COMMENT '上物理实验教师id',
  `capacity` int(0) NOT NULL COMMENT '物理实验可选容量',
  `selected_number` int(0) NULL DEFAULT 0 COMMENT '物理实验已选容量',
  `allowSelected` bit(1) NOT NULL DEFAULT b'1' COMMENT '实验是否可选标识，默认为1(true)，可选',
  `finished` bit(1) NOT NULL DEFAULT b'0' COMMENT '实验是否结课标识，默认为0(false)，尚未结课',
  `state` int(0) NULL DEFAULT 0 COMMENT '实验的权限，便于后续开发',
  PRIMARY KEY (`experiment_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `allowSelected`(`allowSelected`) USING BTREE,
  INDEX `finished`(`finished`) USING BTREE,
  INDEX `experiment_name_2`(`experiment_name`) USING BTREE,
  FULLTEXT INDEX `experiment_name`(`experiment_name`),
  FULLTEXT INDEX `experiment_place`(`experiment_place`),
  FULLTEXT INDEX `week_day`(`week_day`),
  CONSTRAINT `experiment_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `experiment_ibfk_2` FOREIGN KEY (`experiment_name`) REFERENCES `experiment_list` (`experiment_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1050 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experiment
-- ----------------------------
INSERT INTO `experiment` VALUES (1039, '示波器实验', '2021-05-09 10:30:00', '星期日', 'B410', 10011506, 10000, 0, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1040, '用扭摆法测定物体转动惯量', '2021-05-14 20:46:00', '星期五', 'B402', 10011505, 3, 3, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1041, '用电势差计测电动势', '2021-05-13 09:56:00', '星期四', 'B404', 10011503, 4, 4, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1042, '磁阻尼和动摩擦因数的测定', '2021-05-15 00:25:00', '星期六', 'B403', 10011510, 6, 3, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1043, '非线性电阻元件伏安特性曲线的测量', '2021-05-08 22:26:00', '星期六', 'B402', 10011509, 5, 2, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1044, '用拉伸法测金属丝的杨氏模量', '2021-05-23 22:28:00', '星期日', 'B412', 10011503, 5, 5, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1045, '互感系数的测量实验', '2021-05-10 11:28:00', '星期一', 'B411', 10011504, 3, 3, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1046, 'RC和RL串联电路特性研究', '2021-05-11 15:29:00', '星期二', 'B420', 10011502, 4, 4, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1047, '用模拟法测绘静电场', '2021-05-10 14:30:00', '星期一', 'B413', 10011507, 4, 3, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1048, '双臂电桥测低电阻', '2021-05-12 16:56:00', '星期三', 'B412', 10011506, 4, 4, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1049, '示波器实验', '2021-05-08 22:28:00', '星期六', 'B402', 10011508, 6, 4, b'1', b'0', 0);
INSERT INTO `experiment` VALUES (1050, '等厚干涉--牛顿环和劈尖', '2021-05-09 22:29:00', '星期日', 'B405', 10011501, 5, 5, b'1', b'0', 0);

-- ----------------------------
-- Table structure for experiment_limit
-- ----------------------------
DROP TABLE IF EXISTS `experiment_limit`;
CREATE TABLE `experiment_limit`  (
  `condition_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '限制条件唯一标识符',
  `experiment_id` int(0) NOT NULL COMMENT '具有限制条件的实验',
  `college_id` int(0) NOT NULL COMMENT '能选该实验的学院id',
  PRIMARY KEY (`condition_id`) USING BTREE,
  INDEX `experiment_id`(`experiment_id`) USING BTREE,
  INDEX `college_id`(`college_id`) USING BTREE,
  CONSTRAINT `experiment_limit_ibfk_1` FOREIGN KEY (`experiment_id`) REFERENCES `experiment` (`experiment_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `experiment_limit_ibfk_2` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for experiment_list
-- ----------------------------
DROP TABLE IF EXISTS `experiment_list`;
CREATE TABLE `experiment_list`  (
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experiment_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`experiment_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experiment_list
-- ----------------------------
INSERT INTO `experiment_list` VALUES ('20150015', 'pn结正向特性的研究和应用');
INSERT INTO `experiment_list` VALUES ('20150018', 'RC和RL串联电路特性研究');
INSERT INTO `experiment_list` VALUES ('20150028', '互感系数的测量实验');
INSERT INTO `experiment_list` VALUES ('20150026', '交流电桥实验');
INSERT INTO `experiment_list` VALUES ('20210004', '凯特摆测量重力加速度');
INSERT INTO `experiment_list` VALUES ('20150020', '双棱镜干涉实验');
INSERT INTO `experiment_list` VALUES ('20150025', '双臂电桥测低电阻');
INSERT INTO `experiment_list` VALUES ('20210003', '液体比热容的测量');
INSERT INTO `experiment_list` VALUES ('20150033', '用扭摆法测定物体转动惯量');
INSERT INTO `experiment_list` VALUES ('20150019', '用拉伸法测金属丝的杨氏模量');
INSERT INTO `experiment_list` VALUES ('20150027', '用模拟法测绘静电场');
INSERT INTO `experiment_list` VALUES ('20150021', '用电势差计测电动势');
INSERT INTO `experiment_list` VALUES ('20150022', '用电磁感应法测交变磁场');
INSERT INTO `experiment_list` VALUES ('20150023', '电子在电场、磁场中运动规律的研究');
INSERT INTO `experiment_list` VALUES ('20210001', '磁阻尼和动摩擦因数的测定');
INSERT INTO `experiment_list` VALUES ('20210005', '示波器实验');
INSERT INTO `experiment_list` VALUES ('20150011', '等厚干涉--牛顿环和劈尖');
INSERT INTO `experiment_list` VALUES ('20210002', '铁磁材料的居里温度测量');
INSERT INTO `experiment_list` VALUES ('20150014', '霍尔效应');
INSERT INTO `experiment_list` VALUES ('20150024', '非线性电阻元件伏安特性曲线的测量');

-- ----------------------------
-- Table structure for experiment_selected
-- ----------------------------
DROP TABLE IF EXISTS `experiment_selected`;
CREATE TABLE `experiment_selected`  (
  `serial_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '学生选择实验后的流水号，唯一标识符',
  `experiment_id` int(0) NOT NULL COMMENT '学生选择实验的id',
  `student_id` int(0) NOT NULL COMMENT '学生学号',
  `score` int(0) NULL DEFAULT 0 COMMENT '学生实验分数',
  `allowModified` bit(1) NULL DEFAULT b'1' COMMENT '只允许教师修改一次分数，提交后教师不可再更改，默认为1，表示可以修改',
  PRIMARY KEY (`serial_id`) USING BTREE,
  INDEX `experiment_id`(`experiment_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `experiment_selected_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `experiment_selected_ibfk_2` FOREIGN KEY (`experiment_id`) REFERENCES `experiment` (`experiment_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5444 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experiment_selected
-- ----------------------------
INSERT INTO `experiment_selected` VALUES (59145, 1050, 1001011012, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59146, 1046, 1001011012, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59147, 1044, 1001011012, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59148, 1045, 1001011012, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59149, 1050, 1001011013, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59150, 1044, 1001011013, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59151, 1041, 1001011013, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59152, 1046, 1001011013, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59153, 1044, 1001011015, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59154, 1041, 1001011015, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59155, 1046, 1001011015, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59156, 1044, 1001031122, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59157, 1041, 1001031122, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59158, 1044, 1001011014, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59159, 1041, 1001011014, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59160, 1046, 1001031124, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59161, 1045, 1001031124, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59162, 1040, 1001011012, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59163, 1045, 1001011013, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59164, 1049, 1001011015, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59165, 1048, 1001011015, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59166, 1050, 1001011014, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59167, 1040, 1001011014, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59168, 1048, 1001011014, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59169, 1049, 1001031122, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59170, 1047, 1001031122, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59171, 1048, 1001031122, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59172, 1048, 1001031123, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59173, 1047, 1001031123, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59174, 1049, 1001031123, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59175, 1040, 1001031123, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59176, 1042, 1001031123, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59177, 1050, 1001031124, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59178, 1047, 1001031124, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59179, 1049, 1001031124, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59182, 1050, 1001151173, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59183, 1043, 1001151173, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59184, 1042, 1001151173, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59185, 1042, 1001151172, 0, b'1');
INSERT INTO `experiment_selected` VALUES (59186, 1043, 1001151172, 0, b'1');

-- ----------------------------
-- Table structure for experiment_temp
-- ----------------------------
DROP TABLE IF EXISTS `experiment_temp`;
CREATE TABLE `experiment_temp`  (
  `temp_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '流水号，自动递增，唯一',
  `experiment_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experiment_time` timestamp(0) NOT NULL,
  `week_day` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `experiment_place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_id` int(0) NOT NULL,
  `submit_teacher_id` int(0) NULL DEFAULT NULL COMMENT '提交新实验安排的教师工号',
  `capacity` int(0) NOT NULL,
  `state` int(0) NOT NULL DEFAULT 0 COMMENT '0表示审核中，1表示审核不通过，2表示审核通过，默认为0',
  `audit_admin_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核的管理员账号',
  PRIMARY KEY (`temp_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `state`(`state`) USING BTREE,
  INDEX `submit_teacher_id`(`submit_teacher_id`) USING BTREE,
  INDEX `audit_admin_account`(`audit_admin_account`) USING BTREE,
  CONSTRAINT `experiment_temp_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '该表用于教师创建实验时提交给管理员进行审核，审核完毕后，该表中的实验信息进入实验表，学生才可进行选课' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experiment_temp
-- ----------------------------
INSERT INTO `experiment_temp` VALUES (16, '用拉伸法测金属丝的杨氏模量', '2021-05-07 13:30:00', '星期五', 'B401', 10011508, 10011502, 4, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (17, '用电磁感应法测交变磁场', '2021-05-06 12:00:00', '星期四', 'B405', 10011509, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (18, '用模拟法测绘静电场', '2021-05-06 11:50:00', '星期四', 'B411', 10011504, 10011502, 4, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (19, '交流电桥实验', '2021-05-06 11:53:00', '星期四', 'B412', 10011502, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (20, '铁磁材料的居里温度测量', '2021-05-06 11:50:00', '星期四', 'B412', 10011505, 10011504, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (21, '液体比热容的测量', '2021-05-06 11:53:00', '星期四', 'B414', 10011501, 10011504, 4, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (22, 'pn结正向特性的研究和应用', '2021-05-08 09:45:00', '星期六', 'A418', 10011501, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (23, 'RC和RL串联电路特性研究', '2021-05-09 20:45:00', '星期日', 'A420', 10011502, 10011502, 4, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (24, 'RC和RL串联电路特性研究', '2021-05-10 20:45:00', '星期一', 'B401', 10011503, 10011502, 3, 1, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (25, '交流电桥实验', '2021-05-10 10:45:00', '星期一', 'B402', 10011503, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (26, '双臂电桥测低电阻', '2021-05-12 16:46:00', '星期三', 'B404', 10011504, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (27, '用扭摆法测定物体转动惯量', '2021-05-14 20:46:00', '星期五', 'B402', 10011505, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (28, '用电势差计测电动势', '2021-05-14 12:47:00', '星期五', 'B409', 10011507, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (29, '电子在电场、磁场中运动规律的研究', '2021-05-15 20:47:00', '星期六', 'B410', 10011508, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (30, '铁磁材料的居里温度测量', '2021-05-16 20:47:00', '星期日', 'B414', 10011510, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (31, '霍尔效应', '2021-05-16 20:55:00', '星期日', 'B413', 10011507, 10011501, 4, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (32, '用电势差计测电动势', '2021-05-13 09:56:00', '星期四', 'B404', 10011503, 10011501, 4, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (33, '双臂电桥测低电阻', '2021-05-12 16:56:00', '星期三', 'B412', 10011506, 10011501, 4, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (34, '示波器实验', '2021-05-09 10:30:00', '星期日', 'B410', 10011506, 10011501, 10000, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (35, '磁阻尼和动摩擦因数的测定', '2021-05-15 00:25:00', '星期六', 'B403', 10011510, 10011502, 6, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (36, '非线性电阻元件伏安特性曲线的测量', '2021-05-08 22:26:00', '星期六', 'B402', 10011509, 10011502, 5, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (37, '示波器实验', '2021-05-08 22:28:00', '星期六', 'B402', 10011508, 10011502, 6, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (38, '等厚干涉--牛顿环和劈尖', '2021-05-09 22:29:00', '星期日', 'B405', 10011501, 10011502, 5, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (39, '铁磁材料的居里温度测量', '2021-05-10 00:27:00', '星期一', 'B405', 10011507, 10011502, 5, 0, NULL);
INSERT INTO `experiment_temp` VALUES (40, '磁阻尼和动摩擦因数的测定', '2021-05-10 00:27:00', '星期一', 'B408', 10011506, 10011502, 5, 0, NULL);
INSERT INTO `experiment_temp` VALUES (41, '双棱镜干涉实验', '2021-05-11 07:28:00', '星期二', 'B411', 10011505, 10011502, 6, 0, NULL);
INSERT INTO `experiment_temp` VALUES (42, '用拉伸法测金属丝的杨氏模量', '2021-05-23 22:28:00', '星期日', 'B412', 10011503, 10011502, 5, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (43, '液体比热容的测量', '2021-05-12 10:28:00', '星期三', 'B406', 10011504, 10011502, 4, 0, NULL);
INSERT INTO `experiment_temp` VALUES (44, '互感系数的测量实验', '2021-05-10 11:28:00', '星期一', 'B411', 10011504, 10011502, 3, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (45, 'RC和RL串联电路特性研究', '2021-05-11 15:29:00', '星期二', 'B420', 10011502, 10011502, 4, 2, 'dougMagic');
INSERT INTO `experiment_temp` VALUES (46, '双臂电桥测低电阻', '2021-05-12 10:29:00', '星期三', 'B428', 10011501, 10011502, 3, 0, NULL);
INSERT INTO `experiment_temp` VALUES (47, '交流电桥实验', '2021-05-13 22:29:00', '星期四', 'B410', 10011501, 10011502, 4, 0, NULL);
INSERT INTO `experiment_temp` VALUES (48, 'pn结正向特性的研究和应用', '2021-05-14 22:30:00', '星期五', 'B408', 10011502, 10011502, 5, 0, NULL);
INSERT INTO `experiment_temp` VALUES (49, '用模拟法测绘静电场', '2021-05-10 14:30:00', '星期一', 'B413', 10011507, 10011502, 4, 2, 'dougMagic');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(0) NOT NULL COMMENT '学生学号，也是账号',
  `student_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生登录密码',
  `college_id` int(0) NULL DEFAULT NULL COMMENT '学生所在学院id',
  `class_info` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生的年级班级',
  `sex` bit(1) NOT NULL DEFAULT b'0' COMMENT '学生性别，女为1，男为0',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq',
  `state` int(0) NULL DEFAULT 0 COMMENT '学生账号状态，便于后续开发',
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `college_id`(`college_id`) USING BTREE,
  FULLTEXT INDEX `student_name`(`student_name`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1001011012, '张鹏', '1001011012', 100101, '矿业15级8班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001011013, '李荣省', '1001011013', 100101, '矿业15级8班', b'0', '13306002932', '962339285@qq.com', '1220353556', 0);
INSERT INTO `student` VALUES (1001011014, '胡国庆', '1001011014', 100101, '矿业15级9班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001011015, '刘方圆', '1001011015', 100101, '矿业15级9班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001031122, '潘旭东', '1001031122', 100103, '机械15级8班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001031123, '祁存龙', '1001031123', 100103, '机械15级8班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001031124, '孙亮', '1001031124', 100103, '机械15级8班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001031125, '冉家伟', '1001031125', 100103, '机械15级8班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001041144, '辛武', '1001041144', 100104, '计算机15级2班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001041145, '徐思朗', '1001041145', 100104, '计算机15级2班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001041146, '杨贵城', '1001041146', 100104, '计算机15级3班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001151171, '付国通', '1001151171', 100115, '物理15级6班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001151172, '冯帅', '1001151172', 100115, '物理15级6班', b'0', '11223344556', 'example@place.com', '1234567890', 0);
INSERT INTO `student` VALUES (1001151173, '陈富水', '1001151173', 100115, '物理15级7班', b'0', '11223344556', 'example@place.com', '1234567890', 0);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` int(0) NOT NULL COMMENT '教师工号',
  `teacher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名',
  `college_id` int(0) NULL DEFAULT NULL COMMENT '教师所属学院',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `sex` bit(1) NOT NULL DEFAULT b'0' COMMENT '性别，默认为0，男',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'qq号',
  `state` int(0) NULL DEFAULT 0 COMMENT '教师权限，便于后续开发',
  PRIMARY KEY (`teacher_id`) USING BTREE,
  INDEX `teacher_name`(`teacher_name`(8)) USING BTREE,
  INDEX `college_id`(`college_id`) USING BTREE,
  CONSTRAINT `college_id` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (10011501, '张伦', 100115, '10011501', b'1', '13306002932', 'zhanglun@cumt.com', '1441827627', 0);
INSERT INTO `teacher` VALUES (10011502, '秦丽霞', 100115, '10011502', b'1', '11223344556', 'example@place.com', '0123456789', 0);
INSERT INTO `teacher` VALUES (10011503, '李艳', 100115, '10011503', b'1', '11223344556', 'example@place.com', '0123456789', 0);
INSERT INTO `teacher` VALUES (10011504, '石礼伟', 100115, '10011504', b'0', '11223344556', 'example@place.com', '0123456789', 0);
INSERT INTO `teacher` VALUES (10011505, '彭娟', 100115, '10011505', b'1', '11223344556', 'example@place.com', '0123456789', 0);
INSERT INTO `teacher` VALUES (10011506, '张悬', 100115, '10011506', b'1', '11223344556', 'example@place.com', '0123456789', 0);
INSERT INTO `teacher` VALUES (10011507, '王鹏', 100115, '10011507', b'0', '11223344556', 'example@place.com', '0123456789', 0);
INSERT INTO `teacher` VALUES (10011508, '腾淑华', 100115, '10011508', b'1', '11223344556', 'example@place.com', '0123456789', 0);
INSERT INTO `teacher` VALUES (10011509, '邢烨', 100115, '10011509', b'0', '11223344556', 'example@place.com', '0123456789', 0);
INSERT INTO `teacher` VALUES (10011510, '孔丹', 100115, '10011510', b'1', '11223344556', 'example@place.com', '0123456789', 0);

SET FOREIGN_KEY_CHECKS = 1;
