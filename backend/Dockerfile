FROM openjdk:17-jdk-slim

WORKDIR /app

# Instalar Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copiar el proyecto
COPY universidad .

# Compilar la aplicación
RUN mvn clean package -DskipTests

# Buscar el archivo JAR generado (selecciona automáticamente el JAR correcto)
CMD java -jar target/*.jar