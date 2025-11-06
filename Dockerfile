FROM jelastic/maven:3.9.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

COPY --from=build /target/WeatherWiseAI-0.0.1-SNAPSHOT.jar WeatherWiseAI.jar

EXPOSE 8080
ENTRYPOINT ["java" , "-jar" , "WeatherWiseAI.jar"]