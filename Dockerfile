FROM openjdk:17-jdk-alpine
MAINTAINER 4softwaredevelopers.com
RUN addgroup -5 spring && adduser - spring -G spring
USER spring:spring

ARG JAR_FILE=target/*.jar