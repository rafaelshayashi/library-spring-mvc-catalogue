# The base image
FROM openjdk:11-jre-slim

# Creating a spring user
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring

ARG JAR_FILE=build/libs/catalogue-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]