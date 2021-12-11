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
                        CONSTRAINT contact_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
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
                          seat_amount int,
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
                           CONSTRAINT train_go_through_id FOREIGN KEY (train_id) REFERENCES train_num(id) ON DELETE CASCADE,
                           CONSTRAINT station_go_through_id FOREIGN KEY (station_id) REFERENCES station(id) ON DELETE CASCADE
);

-- 车票
DROP TABLE IF EXISTS ticket;
create table ticket(
                       id int primary key auto_increment,
                       train_id int,
                       CONSTRAINT train_num_ticket_id FOREIGN KEY (train_id) REFERENCES train_num(id) ON DELETE CASCADE,
                       seat varchar(50),
                       trival_time datetime,
                       ticket_type varchar(50),
                       price decimal,
                       name varchar(50),
                       identity_card char(35),
                       user_id int,
                       FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- 购票
INSERT INTO `train`.`users` (`id`, `user_name`, `password`, `telephone`, `email`, `identity_card`) VALUES ('1', 'CCC', '1111', '2222', '3333', '4444');

INSERT INTO `train`.`train_num` (`id`, `seat_amount`, `sequence`) VALUES ('1', '80', 'GB11');
INSERT INTO `train`.`train_num` (`id`, `seat_amount`, `sequence`) VALUES ('2', '80', 'GB12');

