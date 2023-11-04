# Fase de construcción
FROM maven:3.6-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -DskipTests

# Fase de ejecución
FROM openjdk:17-jdk-alpine

COPY --from=build /app/target/medicare-0.0.1-SNAPSHOT.jar /app/medicare-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/medicare-0.0.1-SNAPSHOT.jar"]
