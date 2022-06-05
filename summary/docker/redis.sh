#!/bin/bash
#Writerriter by ***
#docker run redis
#2022.6.5
docker run -d --name docker-redis-6379 -p 6379:6379 -v /opt/docker/redis/data:/etc/redis/data -v /opt/docker/redis/redis.conf:/etc/redis/redis.conf \
       redis:6.2 redis-server /etc/redis/redis.conf