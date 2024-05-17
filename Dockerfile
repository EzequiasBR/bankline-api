FROM maven:3.8.3-openjdk-17 AS build

COPY /src /app/src

COPY /pom.xml /app

RUN mvn clean package -Dmaven.test.skip

FROM openjdk:23-ea-17-jdk

EXPOSE 8080

COPY --from=build /app/target/*.jar  app.jar

ENTRYPOINT ["java","-jar", "app.jar"]
