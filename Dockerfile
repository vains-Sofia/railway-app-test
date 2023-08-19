FROM maven:3.8.3-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre as builder
COPY --from=build /app/target/*.jar /myapp.jar
EXPOSE 5000
CMD ["java", "-jar", "/myapp.jar"]
