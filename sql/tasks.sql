/*
 Navicat Premium Data Transfer

 Source Server         : MySql数据库
 Source Server Type    : MySQL
 Source Server Version : 50549
 Source Host           : 192.168.152.135:3306
 Source Schema         : tasks

 Target Server Type    : MySQL
 Target Server Version : 50549
 File Encoding         : 65001

 Date: 03/08/2019 12:27:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` tinyint(255) NULL DEFAULT NULL,
  `is_habit` tinyint(4) NULL DEFAULT NULL,
  `is_complete` tinyint(255) NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `delete_time` datetime NULL DEFAULT NULL,
  `is_delete` tinyint(255) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES (2, '写1000字作文', '我是描述', 1, 0, 0, '2019-07-15 21:40:40', '2019-07-19 01:26:35', NULL, 0);
INSERT INTO `t_task` VALUES (3, '吃西瓜', '222', 4, 1, 1, '2019-07-15 21:40:40', NULL, NULL, 1);
INSERT INTO `t_task` VALUES (4, '写500字作文', '33', 2, 0, 0, '2019-07-15 21:40:40', '2019-07-19 01:45:42', NULL, 0);
INSERT INTO `t_task` VALUES (5, '吃午饭', NULL, 1, 1, 1, '2019-07-15 21:40:40', NULL, NULL, 0);
INSERT INTO `t_task` VALUES (6, '午睡', NULL, 1, 1, 0, '2019-07-15 21:40:40', NULL, NULL, 0);
INSERT INTO `t_task` VALUES (7, '看电视', '晚上要看电视', 4, 1, 0, NULL, NULL, NULL, 0);
INSERT INTO `t_task` VALUES (8, '继续看电视', '看完电视还要看电视', 1, 1, 1, '2019-07-21 21:40:40', NULL, NULL, 0);
INSERT INTO `t_task` VALUES (9, '喂公子吃饼', '喂两位公子吃饼', 1, 0, 0, '2019-07-22 17:25:26', '2019-07-25 20:28:29', NULL, 0);
INSERT INTO `t_task` VALUES (10, '??', '????????', 1, 1, 0, '2019-08-03 00:19:48', NULL, NULL, 0);
INSERT INTO `t_task` VALUES (11, '??', '????????', 1, 1, 0, '2019-08-03 00:21:14', NULL, NULL, 0);
INSERT INTO `t_task` VALUES (12, '??', '????????', 1, 1, 0, '2019-08-03 00:27:20', NULL, NULL, 0);
INSERT INTO `t_task` VALUES (13, '??', '????????', 1, 1, 0, '2019-08-03 00:28:44', NULL, NULL, 0);
INSERT INTO `t_task` VALUES (14, '??', '????????', 1, 1, 0, '2019-08-03 00:33:10', NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_time_actual
-- ----------------------------
DROP TABLE IF EXISTS `t_time_actual`;
CREATE TABLE `t_time_actual`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NULL DEFAULT NULL,
  `begin_time_actual` datetime NULL DEFAULT NULL,
  `end_time_actual` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_time_actual
-- ----------------------------
INSERT INTO `t_time_actual` VALUES (1, 2, '2019-07-17 09:00:00', '2019-07-17 10:00:00');
INSERT INTO `t_time_actual` VALUES (2, 2, '2019-07-17 11:00:00', '2019-07-17 12:00:00');
INSERT INTO `t_time_actual` VALUES (3, 3, '2019-07-17 11:00:00', '2019-07-17 11:10:00');
INSERT INTO `t_time_actual` VALUES (4, 4, '2019-07-17 13:00:00', '2019-07-17 13:30:00');
INSERT INTO `t_time_actual` VALUES (5, 4, '2019-07-17 13:50:00', '2019-07-17 14:30:00');
INSERT INTO `t_time_actual` VALUES (6, 5, '2019-08-02 11:30:00', '2019-08-02 11:50:00');
INSERT INTO `t_time_actual` VALUES (7, 6, '2019-07-17 12:10:00', '2019-07-22 16:42:47');
INSERT INTO `t_time_actual` VALUES (8, 8, '2019-07-16 18:00:09', '2019-07-22 17:00:13');
INSERT INTO `t_time_actual` VALUES (9, 7, '2019-08-02 19:29:51', '2019-08-02 20:29:58');
INSERT INTO `t_time_actual` VALUES (10, 7, '2019-08-02 21:30:12', NULL);
INSERT INTO `t_time_actual` VALUES (11, 1, NULL, NULL);
INSERT INTO `t_time_actual` VALUES (12, 1, NULL, NULL);
INSERT INTO `t_time_actual` VALUES (13, 1, NULL, NULL);
INSERT INTO `t_time_actual` VALUES (14, 1, NULL, NULL);

-- ----------------------------
-- Table structure for t_time_expected
-- ----------------------------
DROP TABLE IF EXISTS `t_time_expected`;
CREATE TABLE `t_time_expected`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NULL DEFAULT NULL,
  `begin_time_expected` datetime NULL DEFAULT NULL,
  `end_time_expected` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_time_expected
-- ----------------------------
INSERT INTO `t_time_expected` VALUES (1, 2, '2019-08-02 09:00:00', '2019-08-02 11:00:00');
INSERT INTO `t_time_expected` VALUES (2, 3, '2019-08-02 11:00:00', '2019-08-02 11:10:00');
INSERT INTO `t_time_expected` VALUES (3, 4, '2019-08-02 13:00:00', '2019-08-02 14:00:00');
INSERT INTO `t_time_expected` VALUES (4, 5, '2019-07-15 11:30:00', '2019-07-15 12:00:00');
INSERT INTO `t_time_expected` VALUES (5, 6, '2019-08-02 12:20:00', '2019-08-02 12:50:00');
INSERT INTO `t_time_expected` VALUES (6, 2, '2019-07-20 01:45:38', '2019-07-20 21:45:43');
INSERT INTO `t_time_expected` VALUES (7, 3, '2019-07-21 13:42:28', '2019-07-21 13:50:33');
INSERT INTO `t_time_expected` VALUES (8, 4, '2019-07-20 14:42:46', '2019-07-20 17:42:55');
INSERT INTO `t_time_expected` VALUES (9, 5, '2019-07-21 15:43:05', '2019-07-21 19:43:25');
INSERT INTO `t_time_expected` VALUES (10, 6, '2019-07-22 13:43:36', '2019-07-22 19:43:40');
INSERT INTO `t_time_expected` VALUES (11, 8, '2019-07-22 11:15:14', '2019-07-22 16:15:23');
INSERT INTO `t_time_expected` VALUES (12, 7, '2019-08-02 21:38:07', '2019-08-02 21:38:14');
INSERT INTO `t_time_expected` VALUES (15, 9, '2019-08-02 20:00:00', '2019-08-02 21:00:00');
INSERT INTO `t_time_expected` VALUES (16, 9, '2019-08-02 20:00:00', '2019-08-02 21:00:00');
INSERT INTO `t_time_expected` VALUES (17, 8, '2019-07-22 21:37:00', '2019-07-23 22:00:00');
INSERT INTO `t_time_expected` VALUES (18, 1, '2019-07-25 23:00:00', '2019-07-25 23:50:00');
INSERT INTO `t_time_expected` VALUES (19, 1, '2019-07-25 23:00:00', '2019-07-25 23:50:00');
INSERT INTO `t_time_expected` VALUES (20, 1, '2019-07-25 23:00:00', '2019-07-25 23:50:00');
INSERT INTO `t_time_expected` VALUES (21, 1, '2019-07-25 23:00:00', '2019-07-25 23:50:00');

SET FOREIGN_KEY_CHECKS = 1;
