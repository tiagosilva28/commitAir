# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /commitAir

# Copy the pom.xml file and download the dependencies
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the application code
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Expose port 8080
EXPOSE 8080

# Set environment variables for MySQL and Redis
ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/commmit-air-db \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=commitAir12345 \
    SPRING_REDIS_HOST=localhost \
    SPRING_REDIS_PORT=6379

# Start the application
CMD ["java", "-jar", "target/commitAir-0.0.1-SNAPSHOT.jar"]