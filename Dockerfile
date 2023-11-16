FROM eclipse-temurin:17-jdk-alpine

# Use build arguments to pass secrets during the build
ARG DATABASE_URL

# Set environment variables using build arguments
ENV DATABASE_URL=$DATABASE_URL

VOLUME /tmp
COPY target/*.jar app.jar
COPY src/main/resources/application.properties /config/application.properties

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080