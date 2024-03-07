/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.0.18-nt 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;
create database if not exists PTXT;
use PTXT;
create table `dingdan` (
	`name` varchar (150),
	`phone` varchar (90),
	`address` varchar (300),
	`shop` varchar (300),
	`item` varchar (300),
	`amount` varchar (300),
	`num` varchar (30),
	`riderid` varchar (30)
); 
insert into `dingdan` (`name`, `phone`, `address`, `shop`, `item`, `amount`, `num`, `riderid`) values('Miss Wang','123456','NFC','711','coffee','20','0','');
insert into `dingdan` (`name`, `phone`, `address`, `shop`, `item`, `amount`, `num`, `riderid`) values('Mr Li','112233','School','KFC','coke','8','0','');
insert into `dingdan` (`name`, `phone`, `address`, `shop`, `item`, `amount`, `num`, `riderid`) values('Miss Liao','45211','NFC','bookstore','book','25','0','');
