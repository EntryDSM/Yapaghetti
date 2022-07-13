FROM openjdk:11-jre-slim

ADD ./build/libs/*.jar app.jar

EXPOSE 8889

ADD practice-infrastructure/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
