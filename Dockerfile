FROM maven:3.8.3-openjdk-17 AS build

COPY . .

RUN mvn clean package -Dmaven.test.skip

FROM openjdk:22-ea-17-jdk-oracle

COPY --from=build /app/target/*.jar  app.jar

EXPOSE 8080


ENTRYPOINT ["java","-jar","/app.jar"]
