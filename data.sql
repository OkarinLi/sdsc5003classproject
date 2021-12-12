INSERT into station(station_name) values('Hong Kong');
INSERT into station(station_name) values('WuHan');
INSERT into station(station_name) values('HeNan');
INSERT into station(station_name) values('HaErBin');


INSERT into train_num(sequence) values('G101');
INSERT into train_num(sequence) values('G1011');
INSERT into train_num(sequence) values('G104');
INSERT into train_num(sequence) values('G1052');

INSERT into date_seat(train_id,train_date,seat_amount) values(1,'2021-12-11',111);
INSERT into date_seat(train_id,train_date,seat_amount) values(1,'2021-12-12',112);
INSERT into date_seat(train_id,train_date,seat_amount) values(1,'2021-12-13',113);
INSERT into date_seat(train_id,train_date,seat_amount) values(2,'2021-12-11',221);
INSERT into date_seat(train_id,train_date,seat_amount) values(2,'2021-12-12',222);
INSERT into date_seat(train_id,train_date,seat_amount) values(2,'2021-12-13',223);
INSERT into date_seat(train_id,train_date,seat_amount) values(3,'2021-12-11',331);
INSERT into date_seat(train_id,train_date,seat_amount) values(3,'2021-12-12',332);
INSERT into date_seat(train_id,train_date,seat_amount) values(3,'2021-12-13',333);
INSERT into date_seat(train_id,train_date,seat_amount) values(4,'2021-12-11',441);
INSERT into date_seat(train_id,train_date,seat_amount) values(4,'2021-12-12',442);
INSERT into date_seat(train_id,train_date,seat_amount) values(4,'2021-12-13',443);



INSERT into go_through(train_id,station_id,arrive_time,leave_time) values('1','1','2021-12-11 12:32:00','2021-12-11 12:40:00');
INSERT into go_through(train_id,station_id,arrive_time,leave_time) values('1','2','2021-12-11 12:32:00','2021-12-11 12:40:00');
INSERT into go_through(train_id,station_id,arrive_time,leave_time) values('1','3','2021-12-11 12:32:00','2021-12-11 12:40:00');
INSERT into go_through(train_id,station_id,arrive_time,leave_time) values('1','4','2021-12-11 12:32:00','2021-12-11 12:40:00');

INSERT into go_through(train_id,station_id,arrive_time,leave_time) values('2','1','2021-12-11 12:32:00','2021-12-11 12:40:00');
INSERT into go_through(train_id,station_id,arrive_time,leave_time) values('2','3','2021-12-11 12:32:00','2021-12-11 12:40:00');



-- 通过起始站和终点站查询车票
SELECT * 
FROM train_num
WHERE 
train_num.id IN
(SELECT DISTINCT train_num.id 
FROM train_num
WHERE train_num.id IN (
    select G1.train_id
	from go_through as G1, station as S1
	where G1.station_id=S1.id and S1.station_name='Hong Kong'
) AND train_num.id IN (
    select G2.train_id
		from go_through as G2, station as S2
		where G2.station_id=S2.id and S2.station_name='HaErBin'
))
