FROM eclipse-temurin:21

WORKDIR /app

COPY target/teamup-test-0.0.1-SNAPSHOT.jar application.jar

EXPOSE 8080

CMD ["java", "-jar", "application.jar"]

//2stage needs to be implemented
//1st stage with maven jdk