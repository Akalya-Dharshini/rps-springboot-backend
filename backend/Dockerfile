
# Use an official Java image with Maven installed
FROM maven:3.8.6-openjdk-17-slim

# Set working directory
WORKDIR /app

# Copy all files
COPY . .

# Build the app
RUN ./mvnw clean install

# Expose the port the app runs on
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
