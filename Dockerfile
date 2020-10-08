FROM openjdk:16-jdk
COPY "./build/libs/ipisis-0.0.1-SNAPSHOT.jar" "ipisis.jar"
EXPOSE 9666
ENTRYPOINT ["java", "-jar", "ipisis.jar"]