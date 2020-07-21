Bootcamp-project2
======================
This project is based on Spring Boot microservices using the reactive stack, read more info there https://spring.io/reactive
# Building
## Windows
### Docker
1. Install [Docker Desktop](https://www.docker.com/products/docker-desktop).
2. Create an image for MongoDB using the following code:
   docker pull mongo:latest
   

Deploy config-service docker

mvn install
docker build –f Dockerfile –t config-service .
docker run –p 8082:8082 --name config-service config-service

