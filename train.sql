CREATE DATABASE IF NOT EXISTS train;
use train;
DROP TABLE IF EXISTS users;
create table users(
    id int primary key auto_increment,
    user_name varchar(50) not null unique,
    password varchar(50) not null,
    telephone varchar(13),
    email varchar(50),
    identity_card char(35)
);

-- 联系人
DROP TABLE IF EXISTS contact;
create table contact(
    id int primary key auto_increment,
    user_id int not null,
    name varchar(124) not null,
    telephone varchar(124),
    identity_card char(35) not null,
    FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- -- 车站
DROP TABLE IF EXISTS station;
create table station(
    id int primary key auto_increment,
    station_name varchar(50) not null
);

-- -- 车次
DROP TABLE IF EXISTS train_num;
create table train_num(
    id int primary key auto_increment,
    sequence varchar(50)
);

-- 经停
DROP TABLE IF EXISTS go_through;
create table go_through(
    train_id int,
    station_id int,
    primary key(train_id,station_id),
    arrive_time datetime,
    leave_time datetime,
    FOREIGN KEY (train_id) REFERENCES train_num(id) ON DELETE CASCADE,
    FOREIGN KEY (station_id) REFERENCES station(id) ON DELETE CASCADE
);

-- 车票
DROP TABLE IF EXISTS ticket;
create table ticket(
	id int primary key auto_increment,
	train_id int,
	FOREIGN KEY (train_id) REFERENCES train_num(id) ON DELETE CASCADE,
	seat varchar(50),
	travel_time datetime,
	ticket_type varchar(50),
	price decimal,
	name varchar(50),
	identity_card char(35),
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- 日期座位数
DROP TABLE IF EXISTS date_seat;
create TABLE  date_seat(
    id int primary key auto_increment,
    train_id int,
    train_date date,
    seat_amount int,
    FOREIGN KEY (train_id) REFERENCES train_num(id) ON DELETE CASCADE
);
INSERT INTO `train`.`users` ( `user_name`, `password`, `telephone`, `email`, `identity_card`) VALUES ('CCC', '1111', '2222', '3333', '4444');

INSERT INTO `train`.`train_num` ( `seat_amount`, `sequence`) VALUES ('1', '80', 'GB11');
INSERT INTO `train`.`train_num` ( `seat_amount`, `sequence`) VALUES ('2', '80', 'GB12');

INSERT INTO `train`.`station` (`station_name`) VALUES ('Hong Kong');
INSERT INTO `train`.`station` (`station_name`) VALUES ('ZhengZhou');
INSERT INTO `train`.`station` (`station_name`) VALUES ('CangZhou');
INSERT INTO `train`.`station` (`station_name`) VALUES ('Bei Jing');

-- 购票
-- DROP TABLE IF EXISTS ticket_order;
-- create table ticket_order(
-- 	ticket_id int,
-- 	primary key(ticket_id),
-- 	user_id int,
-- 	FOREIGN KEY (ticket_id) REFERENCES ticket(id) ON DELETE CASCADE,
-- 	FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
-- );





