FROM openjdk:8-jdk-alpine
ENV TIME_ZONE GMT+7
EXPOSE 8080
ADD /target/*.jar app.jar
ENTRYPOINT java -Duser.timezone=${TIME_ZONE} -jar /app.jar
