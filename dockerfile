# -------- Etapa de construcción --------
FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /app

# Copia los archivos del proyecto, incluyendo mvnw y el wrapper de Maven
COPY . .

# Asegúrate de que el wrapper tenga permisos de ejecución
RUN chmod +x mvnw

# Compilar el proyecto usando el wrapper de Maven
#RUN ./mvnw clean package -DskipTests
RUN ./mvnw clean package -DskipTests -s ./settings.xml && rm -rf ~/.m2/repository/*

# -------- Etapa de producción --------
#FROM eclipse-temurin:21-jre-jammy
FROM eclipse-temurin:21-jre-alpine-3.22

WORKDIR /app

# Copia el jar generado desde la etapa build
COPY --from=build /app/seg-bootstrap/target/app.jar app.jar

# Expone el puerto para la aplicación
EXPOSE 1616

# Comando de arranque para la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]