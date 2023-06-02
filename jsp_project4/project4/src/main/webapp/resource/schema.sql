--2023-05-30
create table user(
id varchar(255) not null primary key,
pw varchar(255) not null,
birth date not null,
age int not null,
reg_date datetime default now(),
last_log date default null
name varchar(255) not null
);

create table tables(
tno int auto_increment primary key,
title varchar(255) not null,
writer varchar(255) not null,
content text,
reg_date datetime default now()
);
alter table tables add img_file text;

create table comm(
cno int not null auto_increment primary key,
tno int default 0,
writer varchar(255) default 'unknown',
content varchar(255) not null,
reg_date datetime default now()
);