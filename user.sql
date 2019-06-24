/*
SQLyog v10.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user` (
	`id` int (11),
	`user_name` varchar (60),
	`password` varchar (60)
); 
insert into `user` (`id`, `user_name`, `password`) values('1','zs','123456');
insert into `user` (`id`, `user_name`, `password`) values('2','ls','000000');
insert into `user` (`id`, `user_name`, `password`) values('3','ww','123123');
