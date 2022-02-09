FROM openjdk:11
ADD target/ofg-users-ms-1.0.0.jar ofg-users-ms-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ofg-users-ms-1.0.0.jar"]
