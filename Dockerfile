FROM openjdk:8-jdk-alpine
CMD ./gradlew clean build
CMD ["chmod", "+x", "build/libs/AuthServer-0.0.1-SNAPSHOT.jar"]
ADD build/libs/AuthServer-0.0.1-SNAPSHOT.jar AuthServ.jar
CMD ["chmod", "+x", "/AuthServSB.jar"]
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/AuthServ.jar"]