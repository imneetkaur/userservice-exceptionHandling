FROM openjdk:11.0-jdk-stretch
ADD ./target/spring-boot-0.0.1-SNAPSHOT.jar /src/app/spring-boot-0.0.1-SNAPSHOT.jar
WORKDIR /src/app
ENTRYPOINT ["java","-jar","spring-boot-0.0.1-SNAPSHOT.jar"]
