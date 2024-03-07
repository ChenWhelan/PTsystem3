/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.0.18-nt 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;
create database if not exists PTXT;
use PTXT;
create table `rider` (
	`ID` bigint (20),
	`name` varchar (150),
	`password` varchar (60),
	`credit` int (10),
	`dingdan` int (30),
	`income` int (20)
); 
insert into `rider` (`ID`, `name`, `password`, `credit`, `dingdan`, `income`) values('10001','10001','10001','64','3','105');
insert into `rider` (`ID`, `name`, `password`, `credit`, `dingdan`, `income`) values('10002','10002','10002','70','6','0');
insert into `rider` (`ID`, `name`, `password`, `credit`, `dingdan`, `income`) values('10003','10003','10003','70','0','0');
insert into `rider` (`ID`, `name`, `password`, `credit`, `dingdan`, `income`) values('10004','10004','10004','70','0','0');
