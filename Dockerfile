#FROM ubuntu:latest
#LABEL authors="shill"
#
#ENTRYPOINT ["top", "-b"]

FROM eclipse-temurin:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]