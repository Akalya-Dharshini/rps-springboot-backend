# Use a Java 17 JDK image
FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the Maven build output JAR file to the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
