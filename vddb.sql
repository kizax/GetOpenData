DROP DATABASE IF EXISTS vddb;

CREATE DATABASE vddb CHARACTER SET utf8;

USE vddb;

DROP TABLE IF EXISTS vddata;

CREATE TABLE vddata (
 deviceid VARCHAR(10),
 exchangetime VARCHAR(20),
 laneno INT,
 volume float(6,1),
 avgspeed float(7,2),
 avgoccupancy float(7,2),
 svolume float(6,1),
 mvolume float(6,1),
 lvolume float(6,1)
);


INSERT INTO vddata VALUES ('V0120C0', '2016-02-03 20:56:53', 1, 105, 66.00, 7.00, 0, 101, 4);
