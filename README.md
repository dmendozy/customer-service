Bootcamp-project2
======================

Deploy config-service docker

mvn install
docker build –f Dockerfile –t config-service .
docker run –p 8082:8082 --name config-service config-service

