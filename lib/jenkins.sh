
cd /home
docker build -t tomcat:spring .
docker kill spring
docker rm spring
docker ps
docker run -d --name spring -p 8080:8080 tomcat:spring