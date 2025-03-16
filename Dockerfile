# Use a base image with Java runtime
FROM eclipse-temurin:latest

# Set the working directory in the container
WORKDIR /app

# Copy the built Spring Boot application JAR to the container
COPY build/libs/spring-boot-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]