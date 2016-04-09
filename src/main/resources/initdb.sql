create database simpledb default character set utf8 collate utf8_general_ci;
use simpledb;
create table t_user (
  id bigint(20) not null primary key auto_increment,
  name varchar(255),
  password varchar(255)
);

create database testdb default character set utf8 collate utf8_general_ci;
use testdb;
create table t_user (
  id bigint(20) not null primary key auto_increment,
  name varchar(255),
  password varchar(255)
);
