FROM openjdk:11-jdk
ARG JAR_FILE=build/libs/Hackathon-A-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /Hackathon-A.jar

ENTRYPOINT ["java","-jar","/Hackathon-A.jar"]




