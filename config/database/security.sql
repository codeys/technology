CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- 密码：123
insert into users(username,password) values('admin','$2a$10$onNtpOIhtMf.4IVyecahWOGD9/1phA/I1lT4LdU9lMQrUbTyyH3n2');-- id = 1
insert into users(username,password) values('luy','$2a$10$MVQfFUNDNTGtZQYeV1aD/el3nZ2Fq.puiDR0B8FMCe1wBYtIYJbGS');-- id = 2

create table role(
id bigint primary key auto_increment,
name varchar(20)
);

insert into role values(1,'管理员');
insert into role values(2,'普通用户');

create table role_user(
uid bigint,
rid bigint
);
insert into role_user values(1,1);
insert into role_user values(2,2);

create table menu(
id bigint primary key auto_increment,
name varchar(20),
url varchar(100),
parentid bigint,
permission varchar(20)
);

insert into menu values(1,'系统管理','',0,'menu:system');
insert into menu values(2,'用户管理','',0,'menu:user');

create table role_menu(
mid bigint,
rid bigint
);
insert into role_menu values(1,1);

insert into role_menu values(2,1);
insert into role_menu values(2,2);