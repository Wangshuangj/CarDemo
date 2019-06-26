/*
SQLyog v10.2 
MySQL - 5.5.27 : Database - car
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`car` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `car`;

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number_plate` varchar(50) NOT NULL,
  `car_owner` varchar(50) NOT NULL,
  `car_color` int(11) NOT NULL,
  `engine_number` varchar(50) NOT NULL,
  `label` int(11) NOT NULL,
  `frame_number` varchar(50) NOT NULL,
  `car_model` varchar(50) NOT NULL,
  `household_date` date NOT NULL,
  `car_type` int(11) NOT NULL,
  `first_registration_date` date NOT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  `creator` varchar(20) NOT NULL,
  `updator` varchar(20) DEFAULT NULL,
  `create_time` date NOT NULL,
  `update_time` date DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `car` */

insert  into `car`(`id`,`number_plate`,`car_owner`,`car_color`,`engine_number`,`label`,`frame_number`,`car_model`,`household_date`,`car_type`,`first_registration_date`,`img_url`,`creator`,`updator`,`create_time`,`update_time`,`password`,`user_name`) values (1,'川A554243','zs',1,'y3252553',2,'j452534','m3543453','2019-09-09',2,'2019-09-09','/src/img/aba.png','ls','jj','2019-09-09','2019-09-09',NULL,NULL),(2,'川A1234G','大B',0,'F645645',0,'JJ565685','XH63654','2019-06-23',0,'2019-06-23',NULL,'zs','zs','2019-06-24','2019-06-24',NULL,NULL),(3,'川A1234B','coco',0,'F645645',0,'JJ565685','XH63654','2019-06-22',0,'2019-06-22',NULL,'zs','zs','2019-06-23','2019-06-23',NULL,NULL),(7,'川B','李寻欢',1,'F3255254',2,'J25352532','X5435463','2019-06-19',1,'2019-06-19',NULL,'zs',NULL,'2018-12-31',NULL,NULL,NULL),(9,'川sdf','sdf',0,'sf',0,'sdfd','fd','2019-06-01',0,'2019-06-10',NULL,'zs','zs','2019-06-21','2019-06-21',NULL,NULL),(10,'川wert','说说',1,'F547',2,'JJ46363','XH643564567','2019-06-01',0,'2019-06-01',NULL,'null','null','2019-06-22','2019-06-22',NULL,NULL),(11,'川Q','胡歌',0,'F2345',0,'J3456','X2345','2019-06-18',0,'2019-06-03',NULL,'null',NULL,'2019-06-19',NULL,NULL,NULL),(12,'川S','胡歌',0,'F2345',0,'J3456','X3456','2019-06-18',0,'2019-06-18',NULL,'zs',NULL,'2019-06-19',NULL,NULL,NULL),(13,'川O23456','oo',3,'F34567',3,'J456','X3456','2019-06-29',3,'2019-06-29',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL),(14,'川P2345','pp',0,'F234356',2,'J4567','X2345','2019-06-29',0,'2019-06-29',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL),(15,'川P2345','pp',0,'F234356',2,'J4567','X2345','2019-06-29',0,'2019-06-29',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL),(18,'川X435','xx',0,'F23456',0,'J23456','X23456','2019-06-29',0,'2019-06-25',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL),(20,'川gerger','bdfbdf',0,'ndgndrng',0,'bdfbdfb','bdbdfnb','2019-06-01',0,'2019-06-25',NULL,'null','null','2019-06-21','2019-06-21',NULL,NULL),(21,'川W','问问',0,'F465436',0,'JJ65634564','XH5467474','2019-06-01',0,'2019-06-01',NULL,'null',NULL,'2019-06-22',NULL,NULL,NULL),(22,'川L4636','流量',0,'F654574',0,'JJ6747457','XH754745','2019-06-03',0,'2019-06-03',NULL,'null',NULL,'2019-06-22',NULL,NULL,NULL),(25,'川A1234A','ger',0,'geg',0,'hd','gdr','2019-06-01',0,'2019-06-01',NULL,'zs',NULL,'2019-06-22',NULL,NULL,NULL);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'ROLE_ADMIN'),(2,'ROLE_USER');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user_name`,`password`) values (1,'zs','123456'),(2,'ls','000000'),(3,'ww','123123');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`user_id`,`role_id`) values (1,1,1),(2,2,2),(3,3,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
