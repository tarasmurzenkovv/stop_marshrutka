FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/db_management.jar db_management.jar
ENTRYPOINT ["java","-jar","/db_management.jar"]