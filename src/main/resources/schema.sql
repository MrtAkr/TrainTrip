CREATE DATABASE IF NOT EXISTS `train_trip`;
USE `train_trip`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `train_trip`;
CREATE TABLE train_trip(id INT UNSIGNED NOT NULL AUTO_INCREMENT comment "電車旅ID"
, value VARCHAR(64) NOT NULL comment "名称"
, departure_date DATETIME comment "出発日"
, note TEXT NOT NULL comment "説明"
, PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment "電車旅";

DROP TABLE IF EXISTS `schedule`;
CREATE TABLE schedule(id INT UNSIGNED NOT NULL AUTO_INCREMENT comment "スケジュールID"
, train_trip_id INT UNSIGNED NOT NULL comment "電車旅ID"
, day_number INT UNSIGNED NOT NULL comment "日順"
, train_name VARCHAR(64) comment "路線名"
, action VARCHAR(64) comment "イベント名"
, PRIMARY KEY (id)
, FOREIGN KEY (train_trip_id) REFERENCES train_trip (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment "スケジュール";

DROP TABLE IF EXISTS `dep_arr_info`;
CREATE TABLE dep_arr_info(id INT UNSIGNED NOT NULL AUTO_INCREMENT comment "発着情報ID"
, schedule_id INT UNSIGNED NOT NULL comment "スケジュールID"
, dep_arr_time TIME NOT NULL comment "発着時刻"
, station_name VARCHAR(32) comment "駅名"
, dep_arr CHAR(1) comment "発着"
, PRIMARY KEY (id)
, FOREIGN KEY (schedule_id) REFERENCES schedule (id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment "発着情報";

SET FOREIGN_KEY_CHECKS = 1;