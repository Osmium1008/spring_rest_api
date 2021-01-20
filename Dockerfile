FROM openjdk:11
COPY ./build/libs/rest_api-0.0.1-SNAPSHOT.jar /tmp/rest_api.jar
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "rest_api.jar"]