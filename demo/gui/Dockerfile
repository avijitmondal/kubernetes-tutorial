# Build stage
FROM node:current-alpine3.13 AS build
LABEL maintainer="avijitmondal38@gmail.com"

# Copying source code
WORKDIR /app
ADD package.json package.json
ADD src src/

# Prepare by downloading dependencies main module
RUN npm install

# Deployment stage
FROM nginx:1.19-alpine
LABEL maintainer="avijitmondal38@gmail.com"

COPY --from=build /app/target/spring-k8s.jar /usr/local/lib/app.jar

EXPOSE 5000
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
