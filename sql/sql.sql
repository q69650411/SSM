/*
SQLyog Ultimate v11.11 (32 bit)
MySQL - 5.0.27-community-nt : Database - how2java
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`how2java` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `how2java`;

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(32) NOT NULL COMMENT '商品名称',
  `price` float(10,1) NOT NULL COMMENT '商品定价',
  `detail` text COMMENT '商品描述',
  `pic` varchar(64) default NULL COMMENT '商品图片',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `items` */

insert  into `items`(`id`,`name`,`price`,`detail`,`pic`,`createtime`) values (1,'台式机',5000.0,'该电脑质量非常好！！！！',NULL,'2015-02-03 13:22:53'),(2,'笔记本',3000.0,'I7处理器+1080TI',NULL,'2015-02-09 13:22:57'),(3,'背包',250.0,'名牌背包，容量大质量好！！！！',NULL,'2015-02-06 13:23:02'),(10,'电动牙刷',500.0,'Oral-B牙刷',NULL,'2017-08-17 15:53:50'),(11,'Iphone',6088.0,'Iphone7',NULL,'2017-08-17 15:53:50'),(12,'空气净化器',5300.0,'三星空气净化器',NULL,'2017-08-17 15:53:50');

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `orderid` int(11) NOT NULL auto_increment,
  `UserID` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY  (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

insert  into `orderitem`(`orderid`,`UserID`,`id`,`num`) values (2,9,3,17),(3,9,10,14),(5,9,2,9),(6,9,11,3);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UserID` int(11) NOT NULL auto_increment,
  `UserName` varchar(255) default NULL,
  `RealName` varchar(255) default NULL,
  `PASSWORD` varchar(255) default NULL,
  `IsAdmin` tinyint(1) default '0',
  `create_time` timestamp NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`UserID`),
  UNIQUE KEY `UserName` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`UserID`,`UserName`,`RealName`,`PASSWORD`,`IsAdmin`,`create_time`) values (9,'zar',NULL,'123',0,'2017-08-18 18:55:04');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
