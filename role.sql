/*
SQLyog v10.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `role` (
	`id` bigint (20),
	`name` varchar (765)
); 
insert into `role` (`id`, `name`) values('1','ADMIN');
insert into `role` (`id`, `name`) values('2','USER');
