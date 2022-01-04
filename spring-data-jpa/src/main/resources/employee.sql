use 'java-learner';

-- auto-generated definition
create table employee
(
    id       int auto_increment
        primary key,
    name     varchar(32) null,
    age      int         null,
    birthday timestamp   null,
    constraint employee_id_uindex
        unique (id)
)
    comment '员工表';

-- insert some data.
INSERT INTO `java-learner`.employee (id, name, age, birthday) VALUES (1, 'test1', 22, '2000-01-04 17:53:19');
INSERT INTO `java-learner`.employee (id, name, age, birthday) VALUES (2, 'test2', 19, '2003-11-26 02:02:02');
INSERT INTO `java-learner`.employee (id, name, age, birthday) VALUES (3, 'test3', 20, '2002-05-11 12:23:14');
INSERT INTO `java-learner`.employee (id, name, age, birthday) VALUES (4, 'test4', 20, '2002-11-09 05:23:45');
INSERT INTO `java-learner`.employee (id, name, age, birthday) VALUES (5, 'test5', 21, '2001-03-08 09:43:22');
INSERT INTO `java-learner`.employee (id, name, age, birthday) VALUES (6, 'test6', 22, '2000-10-04 22:30:01');
INSERT INTO `java-learner`.employee (id, name, age, birthday) VALUES (7, 'test16', 19, '2003-06-30 22:40:20');

