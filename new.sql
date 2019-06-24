use car;
create table car(id bigint auto_increment,
primary key (id),
number_plate varchar(50) not null,
car_owner varchar(50) not null,
car_color int(11) not null,
engine_number varchar(50) not null,
label int(11) not null,
frame_number varchar(50) not null,
car_model varchar (50) not null,
household_date DATE not null,
car_type int(11) not null,
first_registration_date DATE not null,
img_url varchar(100),
creator varchar (20) not null,
updator varchar (20),
create_time DATE not null ,
update_time DATE )charset utf8;

insert into car(number_plate,car_owner,car_color,engine_number,label,
frame_number,car_model,household_date,car_type,first_registration_date,img_url,
creator,updator,create_time,update_time)
 values
  ('川A554243','ls',1,'y3252553',2,'j452534','m3543453','2019-9-9 00:00:00',
2,'2019-9-9 00:00:00','/src/img/aba.png','ls','jj',
'2019-9-9 00:00:00','2019-9-9 00:00:00');

-- id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT
-- primary key auto_increment