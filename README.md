Bootcamp-project2
======================
This project is based on Spring Boot microservices using the reactive stack, read more info there https://spring.io/reactive
# Building
## Windows
1. Install [Docker Desktop](https://www.docker.com/products/docker-desktop).
1. Create an image for MongoDB
`docker pull mongo:latest`
1. Create a container for the database
`docker run -d -p 27017:27017 --name bootcamp-mongodb mongo:latest`
1. Check
`docker ps`
1. Clone each repository called project2-* in my profile
1. Create each image and container using the following code:
1. `mvn install`
1. `docker build -f Dockerfile -t customer-service`
1. `docker run -p 8082:8082 --name customer-service customer-service`
1. Change the name and port according to each repository, you can check it from the `config-data` directory in [project2-config](https://github.com/dmendozy/project2-config)




   

Deploy config-service docker

mvn install
docker build –f Dockerfile –t config-service .
docker run –p 8082:8082 --name config-service config-service

