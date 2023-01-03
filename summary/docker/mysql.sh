#!/bin/bash
#Writerriter by ***
#docker run mysql
#2022.6.5
docker run -d --name docker-mysql-3306 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1qaz@WSX mysql:5.7.38 --lower_case_table_names=1 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

docker run -d --name docker-mariadb-10.3.35 -p 3308:3306 -e MYSQL_ROOT_PASSWORD=1qaz@WSX --privileged=true -v /opt/docker/mysql/data:/var/lib/mysql  \
 -v /opt/docker/mysql/my.cnf:/etc/mysql/my.cnf  \
 mariadb:10.3.35

use mysql;
ALTER USER 'root'@'%' IDENTIFIED BY '1qaz@WSX' PASSWORD EXPIRE NEVER;
	ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '1qaz@WSX';
	FLUSH PRIVILEGES;

[mysqld]
skip-name-resolve
character_set_server=utf8
datadir=/var/lib/mysql
server-id=1000
lower_case_table_names =1
[mysql]
default-character-set = utf8
[mysql.server]
default-character-set = utf8
[mysqld_safe]
default-character-set = utf8
[client]
default-character-set = utf8
