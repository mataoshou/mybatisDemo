/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.31 : Database - sweet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sweet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sweet`;

/*Table structure for table `sweet_program` */

DROP TABLE IF EXISTS `sweet_program`;

CREATE TABLE `sweet_program` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `programName` varchar(64) DEFAULT NULL COMMENT '栏目名称',
  `parent` int(10) DEFAULT NULL COMMENT '父级编码',
  `timeCreate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `sweet_program` */

insert  into `sweet_program`(`id`,`programName`,`parent`,`timeCreate`) values (1,'左侧',2,'2017-07-27 09:44:56'),(2,'左侧569193396',0,'2017-07-27 09:54:06'),(3,'左侧727333344',0,'2017-08-01 14:08:56');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
