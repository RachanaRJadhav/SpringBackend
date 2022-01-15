create database Freshers_recruitment;
use Freshers_recruitment;
create table student(std_id int primary key auto_increment,sname varchar(50) not null,semail varchar(50) not null unique,smob varchar(20) not null unique,clg varchar(50) not null,cgpa double,T_skills varchar(250)) auto_increment=1;
insert into student values(1,'Snehal Deshmukh','snehald@gmil.com','9887766554','engineering college pune',8.8,'Java full stack, Agile');
insert into student values(null,'Adom Smith','Adom@gmil.com','7898676545','IIT Bombay',9.8,'Cloud computing, Machine learning');
insert into student values(null,'Rockey Pandey','rockey@gmil.com','8798789876','RMD Sinhgad institute',7.8,'java,html,php,css');
insert into student values(null,'Tanmay Kulkarni','tamayk99@gmil.com','9653705427','College of engineering and research Awsari',9.3,'AI developement and cloud computing');
insert into student values(null,'Tom Samuel','tom12@gmil.com','8653705827','engineering and research bombay',9.6,'.net full stack and cloud computing');
select * from student;

create table company(comp_id int primary key auto_increment,cname varchar(50) not null unique,cemail varchar(50) not null unique,cmob varchar(50)not null unique,JD varchar(250))auto_increment=1;
insert into company values(1,'Persistent Systems Ptv.ltd','persistent_systems@persistent.com','202034567','Post: Software Engineer, Technical skills: java full stack developer');
insert into company values(null,'TCS ptv.Ltd','tcs@gmail.com','12122567','Post: Junior Software Engineer, Technical skills: c,c++,html,php');
insert into company values(null,'philips services','philips@yahoo.com','9875634567','Post: cloud Engineer, Technical skills: AI ,cloud computing, ML developer');
insert into company values(null,'Oracle world wide','oracle_ww@gmail.com','4568765487','Post: AI and full stack Developer, Technical skills: AI,ML,Cloud');
insert into company values(null,'Microsoft','micro@gmail.com','8768765487','Post: senior full stack Developer, Technical skills: .net,sql,java');
select * from company;

create table selection(stud_sel_id int primary key auto_increment,std_id int,comp_id int ,is_select tinyint(1),is_applied tinyint(1))auto_increment=1;
alter table selection add constraint fc foreign key(comp_id)  references  company(comp_id);
alter table selection add constraint fc4 foreign key(std_id)  references  student(std_id);
desc selection;
insert into selection values (null,1,1,1,1);
insert into selection values (null,1,2,0,1);
insert into selection values (null,2,1,0,1);
insert into selection values (null,2,2,1,1);
insert into selection values (null,3,1,0,0);
insert into selection values (null,3,2,1,1);
insert into selection values (null,4,1,0,0);
insert into selection values (null,4,2,0,1);
select * from selection ;


