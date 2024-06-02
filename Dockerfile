FROM openjdk:17-jdk-alpine
COPY target/http-client-1.0.0.jar http-client-1.0.0.jar
ENTRYPOINT ["java","-jar","/http-client-1.0.0.jar"]