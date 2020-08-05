FROM openjdk:8
ADD target/customer-service.jar customer-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","customer-service.jar"]

