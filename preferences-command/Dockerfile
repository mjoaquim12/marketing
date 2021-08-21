FROM gradle:jdk16-hotspot AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:16-jdk-buster
COPY --from=build /home/gradle/src/preferences-command/build/libs/preferences-command-0.0.1-SNAPSHOT.jar preferences-command-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "preferences-command-0.0.1-SNAPSHOT.jar"]