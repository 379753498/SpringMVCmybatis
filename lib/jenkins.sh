#!/bin/bash
#dockerFile 文件所在路径 例如/home（必填）
DockerFileDIR=
#创建镜像的名称（必填）
ImageName=
#运行时容器名称
RUNINGIMAGENAME=
#映射的端口
PORT=
cd $DockerFileDIR
#开始构建应用
docker build -t $ImageName .
#批量删除 无用的镜像
docker rmi $(docker images |awk '{if($2=="<none>")  print $3}')
#删除程序包
rm -rf /home/SpringMVCmybatis.war
#删除Dockerfile
rm -rf /home/Dockerfile
#强杀容器进程
docker kill $RUNINGIMAGENAME
#移除停止的容器
docker rm $RUNINGIMAGENAME
#查看目前在运行的容器
docker ps
#启动新镜像的容器
docker run -d --name $RUNINGIMAGENAME  -p $PORT:$PORT $ImageName


