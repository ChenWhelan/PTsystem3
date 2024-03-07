/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.0.18-nt 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;
create database if not exists PTXT;
use PTXT;
create table `custom` (
	`id` bigint (20),
	`name` varchar (150),
	`Num` varchar (90),
	`pwd` varchar (60)
); 
insert into `custom` (`id`, `name`, `Num`, `pwd`) values('20001','20001','20001','20001');
insert into `custom` (`id`, `name`, `Num`, `pwd`) values('20002','20002','20002','20002');
insert into `custom` (`id`, `name`, `Num`, `pwd`) values('20003','20003','20003','20003');
