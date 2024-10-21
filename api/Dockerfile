# Use the official Kotlin image
FROM gradle:7.6.0-jdk17 as build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files to the working directory
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

# Build the project
RUN gradle --no-daemon installDist

# Use a lightweight JDK image for the final stage
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built application from the previous stage
COPY --from=build /app/build/install/api /app

# Expose the port the application will run on
EXPOSE 8080

# Run the application
CMD ["/app/bin/api"]
