# Build stage
FROM maven:3.8.1-jdk-11-slim AS build
MAINTAINER Avijit Mondal <avijitmondal38@gmail.com>

# Copying source code
WORKDIR /app
ADD pom.xml pom.xml
ADD src src/

# Prepare by downloading dependencies main module
RUN mvn clean package

# Deployment stage
FROM openjdk:11-jre-slim
MAINTAINER Avijit Mondal <avijitmondal38@gmail.com>

COPY --from=build /app/target/spring-k8s.jar /usr/local/lib/app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
