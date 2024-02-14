FROM openjdk:17-alpine
EXPOSE 8081
COPY target/product-service-0.0.1-SNAPSHOT.jar product-service-0.0.1-ready-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","product-service-0.0.1-ready-SNAPSHOT.jar"]