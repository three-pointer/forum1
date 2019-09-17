/*
 Navicat Premium Data Transfer

 Source Server         : 39.96.169.6
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 39.96.169.6:3306
 Source Schema         : user

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 17/09/2019 12:30:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gmt_creat` bigint(100) NULL DEFAULT NULL,
  `gmt_modified` bigint(100) NULL DEFAULT NULL,
  `creator` int(100) NULL DEFAULT NULL,
  `comment_count` int(100) NULL DEFAULT NULL,
  `view_count` int(100) NULL DEFAULT NULL,
  `like_count` int(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_Id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `token` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gmt_Creat` bigint(19) NULL DEFAULT NULL,
  `gmt_Modified` bigint(19) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10, '55015208', '周聪', 'f644c06b-f58a-4137-bf9a-e91ce2417fb7', 1568641087699, 1568641087699);
INSERT INTO `user` VALUES (11, '55015208', '周聪', '329d4421-8537-4cfe-acf9-ce5619d0a4ff', 1568683845001, 1568683845001);

SET FOREIGN_KEY_CHECKS = 1;
