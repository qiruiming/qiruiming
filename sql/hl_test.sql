/*
 Navicat Premium Data Transfer

 Source Server         : qiriming
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : hl_test

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 09/09/2023 11:50:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hl_test
-- ----------------------------
DROP TABLE IF EXISTS `hl_test`;
CREATE TABLE `hl_test`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '职工ID',
  `emp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职工姓名',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '部门名称',
  `emp_degree_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学历',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态  --0为删除 --1为未删除',
  `cr_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建时间',
  `last_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hl_test
-- ----------------------------
INSERT INTO `hl_test` VALUES (1, '张一', '男', 25, '业务部', '本科', '1', NULL, '2023-09-09 00:13:53');
INSERT INTO `hl_test` VALUES (2, '张二', '男', 26, '人事部', '带专', '1', NULL, '2023-09-09 00:14:08');
INSERT INTO `hl_test` VALUES (3, '张三', '男', 27, '后勤部', '大专', '1', NULL, '2023-09-08 20:19:51');
INSERT INTO `hl_test` VALUES (4, '张四', '女', 28, '人事部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (5, '张五', '男', 29, '后勤部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (6, '张六', '女', 29, '后勤部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (7, '张七', '男', 33, '业务部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (8, '张八', '男', 32, '业务部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (9, '张九', '女', 33, '业务部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (10, '李一', '女', 45, '业务部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (11, '李二', '女', 19, '人事部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (12, '李三', '男', 28, '业务部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (13, '李四', '女', 46, '后勤部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (14, '李五', '男', 58, '业务部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (15, '李六', '女', 22, '人事部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (16, '李七', '男', 26, '后勤部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (17, '李八', '男', 25, '人事部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (18, '李九', '女', 29, '后勤部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (19, '王一', '男', 45, '后勤部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (20, '王二', '女', 21, '业务部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (21, '王三', '男', 21, '业务部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (22, '王四', '男', 23, '业务部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (23, '王五', '女', 33, '业务部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (24, '王六', '男', 45, '人事部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (25, '王七', '男', 35, '业务部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (26, '王八', '男', 41, '后勤部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (27, '王九', '女', 25, '业务部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (28, '赵一', '男', 26, '人事部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (29, '赵二', '男', 20, '后勤部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (30, '赵三', '女', 21, '人事部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (31, '赵四', '男', 19, '后勤部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (32, '赵五', '女', 35, '后勤部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (33, '赵六', '男', 24, '业务部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (34, '赵七', '男', 29, '业务部', '大专', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (35, '赵八', '女', 33, '业务部', '研究生', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (36, '赵九', '男', 45, '业务部', '本科', '1', NULL, NULL);
INSERT INTO `hl_test` VALUES (73, 'aabbcc', '女', 26, '人事部', '带专', '1', '2023-09-08 20:25:16', '2023-09-08 20:25:16');
INSERT INTO `hl_test` VALUES (74, NULL, '1', 11, NULL, NULL, '1', '2023-09-08 23:08:50', '2023-09-08 23:08:50');
INSERT INTO `hl_test` VALUES (75, NULL, '1', 43, NULL, NULL, '1', '2023-09-08 23:10:53', '2023-09-08 23:10:53');
INSERT INTO `hl_test` VALUES (76, '423', '女', 32, '业务部', '本科', '1', '2023-09-08 23:12:12', '2023-09-08 23:12:12');
INSERT INTO `hl_test` VALUES (77, '42', '女', 3, '人事部', '本科', '0', '2023-09-08 23:21:21', '2023-09-09 00:28:16');

SET FOREIGN_KEY_CHECKS = 1;
