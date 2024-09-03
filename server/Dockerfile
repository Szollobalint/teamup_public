# Stage 1: Build the project using Maven
FROM maven:3.9.8-eclipse-temurin-21-alpine AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and other Maven-related files to the container
COPY pom.xml ./

# Download the dependencies
RUN mvn dependency:go-offline

# Copy the entire project to the container
COPY src ./src

# Build the project
RUN mvn clean install

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application's port (if applicable)
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
