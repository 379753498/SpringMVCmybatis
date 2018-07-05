#!/bin/bash
cd /home
#开始构建应用
docker build -t tomcat:spring .
#批量删除 无用的镜像
docker rmi $(docker images |awk '{if($2=="<none>")  print $3}')
#删除程序包
rm -rf /home/SpringMVCmybatis.war
#删除Dockerfile
rm -rf /home/Dockerfile
#强杀容器进程
docker kill spring
#移除停止的容器
docker rm spring
#查看目前在运行的容器
docker ps
#启动新镜像的容器
docker run -d --name spring -p 8080:8080 tomcat:spring
#vim filename set ff=unix wq