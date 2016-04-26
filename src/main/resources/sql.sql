/*
SQLyog v10.2 
MySQL - 5.5.20 : Database - easyreport
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easyreport` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easyreport`;

/*Table structure for table `bs_resource` */

DROP TABLE IF EXISTS `bs_resource`;

CREATE TABLE `bs_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父资源id',
  `name` varchar(100) DEFAULT NULL COMMENT '资源名称',
  `code` varchar(200) DEFAULT NULL COMMENT '资源码',
  `type` tinyint(20) DEFAULT '0' COMMENT '资源类型(系统、菜单、页面)',
  `url` varchar(1000) DEFAULT NULL COMMENT '资源url',
  `seq` int(11) DEFAULT '0' COMMENT '资源排序',
  `description` varchar(500) DEFAULT NULL COMMENT '资源描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `yn` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `version` tinyint(4) DEFAULT '0' COMMENT '版本号',
  `reserve1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserve2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `test` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为测试数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8 COMMENT='资源';

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dept_code` varchar(50) DEFAULT NULL COMMENT '部门代码',
  `dept_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `description` varchar(500) DEFAULT NULL COMMENT '部门描述',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `yn` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `version` tinyint(4) DEFAULT '0' COMMENT '版本号',
  `reserve1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserve2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `test` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为测试数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='部门表';

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色代码',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(500) DEFAULT NULL COMMENT '资源描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `yn` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `version` tinyint(4) DEFAULT '0' COMMENT '版本号',
  `reserve1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserve2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `test` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为测试数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Table structure for table `role_resource_rel` */

DROP TABLE IF EXISTS `role_resource_rel`;

CREATE TABLE `role_resource_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `yn` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `version` tinyint(4) DEFAULT '0' COMMENT '版本号',
  `reserve1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserve2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `test` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为测试数据',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id` (`role_id`,`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=456 DEFAULT CHARSET=utf8 COMMENT='角色资源关联';

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(50) DEFAULT NULL COMMENT '用户代码',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `description` varchar(500) DEFAULT NULL COMMENT '资源描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `yn` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `version` tinyint(4) DEFAULT '0' COMMENT '版本号',
  `reserve1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserve2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `test` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为测试数据',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Table structure for table `user_dept` */

DROP TABLE IF EXISTS `user_dept`;

CREATE TABLE `user_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_no` varchar(100) DEFAULT NULL COMMENT '用户帐号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `dept_code` varchar(50) DEFAULT NULL COMMENT '部门编号',
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `yn` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `version` tinyint(4) DEFAULT '0' COMMENT '版本号',
  `reserve1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserve2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `test` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为测试数据',
  `admin` tinyint(4) DEFAULT NULL COMMENT '是否为管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8 COMMENT='用户部门表';

/*Table structure for table `user_role_rel` */

DROP TABLE IF EXISTS `user_role_rel`;

CREATE TABLE `user_role_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(50) DEFAULT NULL COMMENT '更新人',
  `yn` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志',
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `version` tinyint(4) DEFAULT '0' COMMENT '版本号',
  `reserve1` varchar(100) DEFAULT NULL COMMENT '预留字段1',
  `reserve2` varchar(100) DEFAULT NULL COMMENT '预留字段2',
  `test` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为测试数据',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
