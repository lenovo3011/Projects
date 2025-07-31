FROM maven:3.5.4-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /target/WeatherWiseAI-0.0.1-SNAPSHOT.jar WeatherWiseAI.jar

EXPOSE 8080
ENTRYPOINT ["java" , "-jar" , "WeatherWiseAI.jar"]