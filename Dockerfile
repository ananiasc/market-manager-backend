# Etapa de construção
FROM maven:3.8.6-openjdk-8 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn install -DskipTests

# Etapa de execução
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=build /app/target/MarketBackend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]