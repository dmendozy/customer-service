Bootcamp-project2
======================
This project is based on Spring Boot microservices using the reactive stack, read more info there https://spring.io/reactive
# Building
## Windows
1. Install [Docker Desktop](https://www.docker.com/products/docker-desktop).
1. Create an image for MongoDB using the following code
'docker pull mongo:latest'
1. Create a container for the database
'docker run -d -p 27017:27017 --name bootcamp-mongodb mongo:latest'
1. Check
'docker ps'




   

Deploy config-service docker

mvn install
docker build –f Dockerfile –t config-service .
docker run –p 8082:8082 --name config-service config-service

