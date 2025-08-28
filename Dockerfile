# Etapa 1: Build do projeto com Maven
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copia somente o pom.xml primeiro para baixar dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte
COPY src ./src

# Build do JAR (skip tests para agilizar)
RUN mvn clean package -DskipTests -B

# Etapa 2: Imagem final mais leve
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o JAR da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Define a porta que a aplicação expõe
EXPOSE 9090

# Ponto de entrada: inicia a aplicação Java
# Não há dependência de um banco de dados, então não precisamos do wait-for-it
ENTRYPOINT ["java", "-jar", "app.jar"]