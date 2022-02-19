FROM adoptopenjdk/openjdk11:jre-11.0.13_8-alpine

#VOLUME /tmp
EXPOSE 43215

#WORKDIR myAppDir
COPY target/task02_Rest-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]