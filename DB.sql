CREATE DATABASE HOTEL;
USE HOTEL;
CREATE TABLE BEDDETAIL(
ID INT PRIMARY KEY auto_increment,
BEDDETAILTEXT VARCHAR(100)
);
CREATE TABLE STAFFTYPE(
ID INT PRIMARY KEY auto_increment,
STAFFTYPETEXT VARCHAR(100)
);
CREATE TABLE STAFF 
(
ID INT PRIMARY KEY AUTO_INCREMENT,
CITIZENID VARCHAR(100),
NAME VARCHAR(100),
PHONE VARCHAR(100),
EMAIL VARCHAR(100),
DOB DATE,
GENDER VARCHAR(100), 
ADDRESS VARCHAR(100),
CREATEDDATE DATE,
STAFFTYPEID INT,
FOREIGN KEY (STAFFTYPEID) REFERENCES STAFFTYPE(ID)
);
CREATE TABLE ROOMTYPE 
(
ID INT PRIMARY KEY auto_increment,
ROOMTYPETEXT VARCHAR(100),
SIZE INT, 
PRICE INT,
BEDDETAILID INT,
FOREIGN KEY (BEDDETAILID) REFERENCES BEDDETAIL(ID)
);
CREATE TABLE ROOM 
(
ID INT PRIMARY KEY auto_increment,
ROOMNUMBER VARCHAR(100),
FLOOR INT,
STATE INT,
ROOMTYPEID INT,
FOREIGN KEY (ROOMTYPEID) REFERENCES ROOMTYPE(ID)
);
CREATE TABLE GUEST(
ID INT PRIMARY KEY auto_increment,
CITIZENID VARCHAR(100),
NAME VARCHAR(100),
PHONE VARCHAR(100),
EMAIL VARCHAR(100),
DOB DATE,
GENDER VARCHAR(100), 
ADDRESS VARCHAR(100)
);
CREATE TABLE BOOKING 
(
ID INT PRIMARY KEY auto_increment,
ROOMID INT,
FOREIGN KEY (ROOMID) REFERENCES ROOM(ID),
GUESTID INT,
FOREIGN KEY (GUESTID) REFERENCES GUEST(ID),
STAFFID INT,
FOREIGN KEY ( STAFFID) REFERENCES STAFF(ID),
CHECKINDATE DATE,
CHECKOUTDATE DATE,
ISPAID BOOLEAN,
TOTALPRICE int)
