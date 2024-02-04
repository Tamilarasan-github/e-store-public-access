# Use a base image with OpenJDK
FROM openjdk:22-ea-17-jdk-bullseye
# Set the working directory inside the container
WORKDIR /app
# Copy the JAR file into the container at /app
COPY target/e-store-public-access-0.0.1-SNAPSHOT.jar /app/
# Expose the port that your Spring Boot application will run on
EXPOSE 8081
# Specify the command to run your application
CMD ["java", "-jar", "e-store-public-access-0.0.1-SNAPSHOT.jar"]