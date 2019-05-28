create database if not exists ebookshop;
 
use ebookshop;
 
drop table if exists books;
create table books (
  id     int,
  title  varchar(50),
  author varchar(50),
  price  double,
  qty    int,
  primary key (id));
 
insert into books values (1001, 'Java for dummies', 'Tan Ah Teck', 11.11, 11);
insert into books values (1002, 'More Java for dummies', 'Tan Ah Teck', 22.22, 22);
insert into books values (1003, 'More Java for more dummies', 'Mohammad Ali', 33.33, 33);
insert into books values (1004, 'A Cup of Java', 'Kumar', 44.44, 44);
insert into books values (1005, 'A Teaspoon of Java', 'Kevin Jones', 55.55, 55);
 
drop table if exists order_records;
create table order_records (
  id          int,
  qty_ordered int,
  cust_name   varchar(30),
  cust_email  varchar(30),
  cust_phone  char(10));
 
select * from books;