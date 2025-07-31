# FROM jelastic/maven:3.9.5-openjdk-21 AS build
# COPY . .
# RUN mvn clean package -DskipTests

# FROM openjdk:21-slim
# COPY --from=build /target/WeatherWiseAI-0.0.1-SNAPSHOT.jar WeatherWiseAI.jar
# # COPY --from=build /Weather-App/Backend/target/WeatherWiseAI-0.0.1-SNAPSHOT.jar WeatherWiseAI.jar

# EXPOSE 8080
# ENTRYPOINT ["java" , "-jar" , "WeatherWiseAI.jar"]


# Stage 1: Build
FROM jelastic/maven:3.9.5-openjdk-21 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:21-slim
COPY --from=build /app/target/WeatherWiseAI-0.0.1-SNAPSHOT.jar WeatherWiseAI.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "WeatherWiseAI.jar"]
