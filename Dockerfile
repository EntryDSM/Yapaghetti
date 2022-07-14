FROM openjdk:11-jre-slim

ADD yapaghetti-infrastructure/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
