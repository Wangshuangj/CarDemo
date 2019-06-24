/*
SQLyog v10.2 
MySQL - 5.5.27 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `car` (
	`id` bigint (20),
	`number_plate` varchar (150),
	`car_owner` varchar (150),
	`car_color` int (11),
	`engine_number` varchar (150),
	`label` int (11),
	`frame_number` varchar (150),
	`car_model` varchar (150),
	`household_date` date ,
	`car_type` int (11),
	`first_registration_date` date ,
	`img_url` varchar (300),
	`creator` varchar (60),
	`updator` varchar (60),
	`create_time` date ,
	`update_time` date ,
	`password` varchar (765),
	`user_name` varchar (765)
); 
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('1','川A554243','zs','1','y3252553','2','j452534','m3543453','2019-09-09','2','2019-09-09','/src/img/aba.png','ls','jj','2019-09-09','2019-09-09',NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('2','川A1234E','大B','0','F645645','0','JJ565685','XH63654','2019-06-22','0','2019-06-22',NULL,'zs',NULL,'2019-06-23',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('3','川A1234B','coco','0','F645645','0','JJ565685','XH63654','2019-06-22','0','2019-06-22',NULL,'zs','zs','2019-06-23','2019-06-23',NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('6','川A14223243','ww','0','F452534334','0','J45346','X2352345','2019-06-17','0','2019-06-17',NULL,'zs',NULL,'2018-12-31',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('7','川B','李寻欢','1','F3255254','2','J25352532','X5435463','2019-06-19','1','2019-06-19',NULL,'zs',NULL,'2018-12-31',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('8','川C43534636534','张三丰','3','F2525245364','2','J45326436','X2532352','2019-04-04','2','2019-04-04',NULL,'zs',NULL,'2018-12-31',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('9','川sdf','sdf','0','sf','0','sdfd','fd','2019-06-01','0','2019-06-10',NULL,'zs','zs','2019-06-21','2019-06-21',NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('10','川wert','说说','1','F547','2','JJ46363','XH643564567','2019-06-01','0','2019-06-01',NULL,'null','null','2019-06-22','2019-06-22',NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('11','川Q','胡歌','0','F2345','0','J3456','X2345','2019-06-18','0','2019-06-03',NULL,'null',NULL,'2019-06-19',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('12','川S','胡歌','0','F2345','0','J3456','X3456','2019-06-18','0','2019-06-18',NULL,'zs',NULL,'2019-06-19',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('13','川O23456','oo','3','F34567','3','J456','X3456','2019-06-29','3','2019-06-29',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('14','川P2345','pp','0','F234356','2','J4567','X2345','2019-06-29','0','2019-06-29',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('15','川P2345','pp','0','F234356','2','J4567','X2345','2019-06-29','0','2019-06-29',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('17','川Aaaaaaaaaaaaa','aaaaaaa','0','FD32456','0','JJ3456','XH23456','2019-06-29','0','2019-06-29',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('18','川X435','xx','0','F23456','0','J23456','X23456','2019-06-29','0','2019-06-25',NULL,'zs',NULL,'2019-06-21',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('20','川gerger','bdfbdf','0','ndgndrng','0','bdfbdfb','bdbdfnb','2019-06-01','0','2019-06-25',NULL,'null','null','2019-06-21','2019-06-21',NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('21','川W','问问','0','F465436','0','JJ65634564','XH5467474','2019-06-01','0','2019-06-01',NULL,'null',NULL,'2019-06-22',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('22','川L4636','流量','0','F654574','0','JJ6747457','XH754745','2019-06-03','0','2019-06-03',NULL,'null',NULL,'2019-06-22',NULL,NULL,NULL);
insert into `car` (`id`, `number_plate`, `car_owner`, `car_color`, `engine_number`, `label`, `frame_number`, `car_model`, `household_date`, `car_type`, `first_registration_date`, `img_url`, `creator`, `updator`, `create_time`, `update_time`, `password`, `user_name`) values('25','川A1234A','ger','0','geg','0','hd','gdr','2019-06-01','0','2019-06-01',NULL,'zs',NULL,'2019-06-22',NULL,NULL,NULL);
