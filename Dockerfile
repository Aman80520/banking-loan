FROM openjdk:8
EXPOSE 8080
ADD target/banking-loan.jar banking-loan.jar
ENTRYPOINT ["java", "-jar", "/banking-loan.jar"]