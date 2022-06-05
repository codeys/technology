#!/bin/bash
#Writerriter by ***
#docker run rockermq
#2022.6.5

#启动namesrv
docker run -d -p 9876:9876 --name docker-rocketmq-4.8.0 \
       -v /opt/docker/rocketmq/namesrv/logs/:/etc/rocketmq/logs -v /opt/docker/rocketmq/namesrv/store/:/etc/rocketmq/store \
       -e "MAX_POSSIBLE_HEAP=100000000" foxiswho/rocketmq:4.8.0 sh mqnamesrv

#启动broker
docker run -d --name docker-broker-4.8.0 -p 10911:10911 -p 10909:10909 --restart=always \
       -v /opt/docker/rocketmq/broker/logs/:/etc/broker/logs -v /opt/docker/rocketmq/broker/store/:/etc/broker/store -v /opt/docker/rocketmq/broker/broker.conf:/etc/broker/broker.conf \
       --link docker-rocketmq-4.8.0:namesrv -e "NAMESRV_ADDR=namesrv:9876" -e "MAX_POSSIBLE_HEAP=200000000" \
       foxiswho/rocketmq:4.8.0  mqbroker -c /etc/broker/broker.conf

#启动mq监控
docker run -d -e "JAVA_OPTS=-Drocketmq.namesrv.addr=172.16.22.191:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" \
       -p 8080:8080 -t styletang/rocketmq-console-ng
