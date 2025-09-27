# Use a imagem oficial do OpenJDK
FROM openjdk:21-jdk-slim

# Diretório dentro do container
WORKDIR /app

# Copia o JAR gerado pelo Maven/Gradle
COPY target/gestorvendas-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
