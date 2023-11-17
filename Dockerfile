FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp
COPY target/*.jar master.jar
ENTRYPOINT ["java", "-jar", "/master.jar"]
EXPOSE 8080
