FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR /src/api
COPY target/*.jar api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Djava.awt.headless=true","export DISPLAY=localhost:20.0","-Dspring.profiles.active=prd","-XX:+UseSerialGC","-XX:+TieredCompilation","-XX:TieredStopAtLevel=1","-jar","api.jar"]