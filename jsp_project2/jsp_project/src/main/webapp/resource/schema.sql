use mysql;

create user


create database jspdb;

-- 2023-05-12
create table member(
id varchar(255) not null primary key,
pw varchar(255) not null,
email varchar(255) not null,
age int not null,
reg_date datetime default now(),
last_login datetime default null
);

-- 2023-05-16
create table board(
bno int not null auto_increment primary key,
title varchar(255) not null,
writer varchar(255) not null,
content text,
reg_date datetime default now()
);


-- 2023-05-19
create table comment(
cno int not null auto_increment primary key,
bno int default 0,
writer varchar(255) default 'unknown',
content varchar(1000) not null,
reg_date datetime default now()
);
-- 2023-05-25
alter table board add image_file text;