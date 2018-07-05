# This my first tomcat Dockerfile
# Version 1.0

# Base images 基础镜像
FROM tomcat

#MAINTAINER 维护者信息
MAINTAINER 379753498@qq.com

#ENV 设置环境变量
ENV LANG C.UTF-8
ENV LC_ALL C.UTF-8

#ADD  文件放在当前目录下，拷过去会自动解压
ADD SpringMVCmybatis.war ./webapps/SpringMVCmybatis.war


#RUN 执行以下命令
#RUN rpm -ivh /usr/local/epel-release-latest-7.noarch.rpm


#WORKDIR 相当于cd
#WORKDIR /usr/local/nginx-1.8.0

#EXPOSE 映射端口
#EXPOSE 80

#CMD 运行以下命令
#CMD ["nginx"]