/*
SQLyog v10.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `user_role` (
	`user_id` bigint (20),
	`role_id` bigint (20)
); 
insert into `user_role` (`user_id`, `role_id`) values('1','1');
insert into `user_role` (`user_id`, `role_id`) values('2','2');
insert into `user_role` (`user_id`, `role_id`) values('3','1');
