FROM openjdk:8
EXPOSE 8080
ADD target/banking-loan-0.0.1-SNAPSHOT.jar banking-loan-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/banking-loan-0.0.1-SNAPSHOT.jar"]