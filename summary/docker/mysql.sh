#!/bin/bash
#Writerriter by ***
#docker run mysql
#2022.6.5
docker run -d --name docker-mysql-3306 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1qaz@WSX mysql:5.7.38