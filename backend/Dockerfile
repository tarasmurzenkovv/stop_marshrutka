FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/backend.jar backend.jar
ENTRYPOINT ["java","-jar","/backend.jar"]