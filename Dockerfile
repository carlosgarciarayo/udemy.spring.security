# Etapa 1: Build
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia archivos de Maven/Gradle
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Descarga dependencias (se cachea si no cambian)
RUN ./mvnw dependency:go-offline -B

# Copia el código fuente
COPY src ./src

# Construye la aplicación
RUN ./mvnw clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia el JAR desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]