-- 创建数据库
drop database if exists split_table;
create database split_table;

-- 待拆分的表
drop table if exists split_table.user;
create table split_table.user
(
	id bigint auto_increment
		primary key,
	name varchar(20) null,
	age tinyint default 0 not null
) engine=MyISAM  default charset=utf8 auto_increment=1
comment '待拆分的表';
insert into split_table.user(name, age) values ('张三', 20);
insert into split_table.user(name, age) values ('李四', 26);
insert into split_table.user(name, age) values ('王二', 18);
insert into split_table.user(name, age) values ('麻子', 23);

-- 分表1
drop table if exists split_table.user1;
create table split_table.user1(
  id bigint primary key auto_increment ,
  name varchar(20),
  age tinyint not null default 0
) engine=MyISAM  default charset=utf8 auto_increment=1
comment '分表1';

-- 分表2
drop table if exists split_table.user2;
create table split_table.user2(
  id bigint primary key auto_increment,
  name varchar(20),
  age tinyint not null default 0
) engine=MyISAM  default charset=utf8 auto_increment=1
comment '分表2';

-- 拆分数据
insert into split_table.user1(id,name,age)
select id,name,age from user where id%2=1;
insert into split_table.user2(id,name,age)
select id,name,age from user where id%2=0;

-- 创建查询主表
drop table if exists split_table.user_all;
create table split_table.user_all(
  id bigint primary key auto_increment,
  name varchar(20),
  age tinyint not null default '0'
) engine=merge union=(split_table.user1, split_table.user2) insert_method=last charset=utf8 auto_increment=1
comment '查询主表';