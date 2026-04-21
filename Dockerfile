# 🔥 Etapa 1: build (compila el proyecto)
FROM gradle:8.5-jdk21 AS build

WORKDIR /app

COPY . .

RUN gradle build --no-daemon

# 🔥 Etapa 2: runtime (ejecuta el .jar)
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]