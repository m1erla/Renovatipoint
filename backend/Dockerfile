FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -Pprod -DskipTests


FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/target/furkankarakus-0.0.1-SNAPSHOT.jar furkankarakus.jar
EXPOSE 8443
ENTRYPOINT ["java","-jar","furkankarakus.jar"]