FROM openjdk:17-jdk-alpine

# Create user to run application
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy the jar file to the container
COPY target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]