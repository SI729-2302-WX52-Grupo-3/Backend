# Fase de construcción
FROM maven:3.6-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package -DskipTests

# Fase de ejecución
FROM openjdk:17-jdk-alpine

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://isabelle.db.elephantsql.com:5432/wgxcljka
ENV SPRING_DATASOURCE_USERNAME=wgxcljka
ENV SPRING_DATASOURCE_PASSWORD=LLjePcznucyM-_4-6F4GGDjgZDA2UgQo
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

COPY --from=build /app/target/medicare-0.0.1-SNAPSHOT.jar /app/medicare-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/medicare-0.0.1-SNAPSHOT.jar"]
