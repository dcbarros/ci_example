# Etapa de construção
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B  # Faz o download das dependências
COPY src ./src
RUN mvn clean package -DskipTests  # Compila o projeto e gera o JAR

# Etapa de execução
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
