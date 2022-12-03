FROM openjdk:11-jre-slim
ADD target/enoca7-0.0.1-SNAPSHOT.jar docker-spring-boot.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]