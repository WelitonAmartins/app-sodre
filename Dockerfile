FROM openjdk:8-jdk-alpine
ENV DISPLAY 18.212.14.212:0
VOLUME /tmp
WORKDIR /src/api
COPY target/*.jar api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Djava.awt.headless=false","-Dspring.profiles.active=prd","-XX:+UseSerialGC","-XX:+TieredCompilation","-XX:TieredStopAtLevel=1","-jar","api.jar"]