drop database if exists practice;

create database if not exists practice;

use practice;

create table student (
    maSinhVien varchar(50) primary key,
    Ten nvarchar(100),
    DiaChi nvarchar(100),
    DienThoai varchar(50) check ( Phone REGEXP '[0-9]{8,15}')
);

insert into student values ('B010110', 'Nguyen Tuan Anh', 'Ha Noi', '0904818238'),
                           ('B10394', 'Nguyen Hoang Hai', 'Hai Duong', '0494949494');

select * from student;