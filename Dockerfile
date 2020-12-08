FROM adoptopenjdk:11-jre-hotspot

RUN mkdir /opt/app

COPY target/travel-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/travel-0.0.1-SNAPSHOT.jar"]