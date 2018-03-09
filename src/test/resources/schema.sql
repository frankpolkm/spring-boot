drop table student if exists;
drop table DEPARTMENT if exists;
drop table EMPLOYEE if exists;

create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table DEPARTMENT
(
   id integer not null,
   name varchar(255) not null,
   primary key(id)
);

create table EMPLOYEE
(
   id integer not null,
   first_name varchar(255) not null,
   last_name varchar(255) not null,
   primary key(id)
);