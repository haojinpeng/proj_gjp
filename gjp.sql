/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.56 : Database - gjp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gjp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gjp`;

/*Table structure for table `bill_type` */

DROP TABLE IF EXISTS `bill_type`;

CREATE TABLE `bill_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `bill_type` */

insert  into `bill_type`(`id`,`name`) values (1,'支出'),(2,'收入'),(3,'借出'),(4,'还入'),(5,'借入'),(6,'还出'),(7,'不限');

/*Table structure for table `bills` */

DROP TABLE IF EXISTS `bills`;

CREATE TABLE `bills` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `bill_time` date NOT NULL,
  `type_id` int(10) NOT NULL,
  `price` int(10) NOT NULL,
  `explain` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bills` (`type_id`),
  CONSTRAINT `bills_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `bill_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3426 DEFAULT CHARSET=utf8;

/*Data for the table `bills` */

insert  into `bills`(`id`,`user`,`title`,`bill_time`,`type_id`,`price`,`explain`) values (31,'范德萨发','范德萨','2020-03-03',1,31,'富士达'),(78,'爱国','放大','2020-03-12',1,546,'大发大'),(121,'小王','放大','2020-12-11',3,234,'发'),(125,'及格','2','2020-12-12',1,2,'2'),(126,'及','3','2020-12-12',1,3,'3'),(3423,'放大到底','发放','2020-11-11',5,24,'发文'),(3424,'测试','买东西','2020-12-12',1,123,'无'),(3425,'张三','购物','2020-09-12',1,100,'无');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
