docker cp 容器id:/usr/share/nginx/html/ /docker/nginx
docker cp 容器id:/etc/nginx/nginx.conf /docker/nginx/conf/nginx.conf

docker run --name nginx-82 -p 82:81 -v /opt/docker/nginx/html/:/usr/share/nginx/html -v /opt/docker/nginx/conf/conf.d/default.conf:/etc/nginx/conf.d/default.conf -d nginx
