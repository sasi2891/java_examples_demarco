create database if not exists userproduct;

use userproduct;
drop table if exists USER_ACCOUNT;
drop table if exists PRODUCT;

-- Create table
create table USER_ACCOUNT
(
ID  VARCHAR(20) not null,
USER_NAME VARCHAR(30) not null,
GENDER    VARCHAR(1) not null,
PASSWORD  VARCHAR(30) not null,
primary key (ID)
);
 
-- Create table
create table PRODUCT
(
CODE  VARCHAR(20) not null,
NAME  VARCHAR(128) not null,
PRICE FLOAT not null,
primary key (CODE)
) ;
 
-- Insert data: ---------------------------------------------------------------
 
insert into user_account (ID, USER_NAME, GENDER, PASSWORD)
values ('U1', 'tom', 'M', 'tom001');
 
insert into user_account (ID, USER_NAME, GENDER, PASSWORD)
values ('U2', 'jerry', 'M', 'jerry001');
 
insert into product (CODE, NAME, PRICE)
values ('P1', 'Java Core', 100);
 
insert into product (CODE, NAME, PRICE)
values ('P2', 'C# Core', 90);