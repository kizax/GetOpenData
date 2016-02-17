DROP DATABASE IF EXISTS vddb;

CREATE DATABASE vddb CHARACTER SET utf8;

USE vddb;

DROP TABLE IF EXISTS vddata;

CREATE TABLE vddata (
 ID int NOT NULL AUTO_INCREMENT,
 deviceid VARCHAR(10),
 exchangetime datetime,
 laneno INT,
 volume float(6,1),
 avgspeed float(7,2),
 avgoccupancy float(7,2),
 svolume float(6,1),
 mvolume float(6,1),
 lvolume float(6,1),
 PRIMARY KEY (ID)
)ENGINE = MyISAM ;


INSERT INTO vddata (deviceid,exchangetime,laneno,volume,avgspeed,avgoccupancy,svolume,mvolume,lvolume) VALUES ('V0120C0', '2016-02-03 20:56:53', 1, 105, 66.00, 7.00, 0, 101, 4);
