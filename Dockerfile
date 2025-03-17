# Etapa de construção
FROM maven:3.8.6-openjdk-8 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

# Renomear o JAR para um nome fixo
RUN cp target/*.jar target/app.jar

# Etapa de execução
FROM openjdk:8-jdk-alpine
VOLUME /tmp

COPY --from=build /app/target/app.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
