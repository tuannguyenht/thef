# Build stage
FROM gradle:8.6-jdk AS build
LABEL maintainer="tuannat.com"
WORKDIR /
COPY . /
RUN gradle clean bootJar

# Package stage
FROM amazoncorretto:20-alpine
COPY --from=build /target/libs/*.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","app.jar"]