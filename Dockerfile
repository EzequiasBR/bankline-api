FROM maven:3.8.3-openjdk-17 AS build

COPY . /app

RUN mvn clean package -Dmaven.test.skip

FROM penjdk:22-ea-17-jdk-oracle

EXPOSE 8080

COPY --from=build /app/target/*.jar  app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
