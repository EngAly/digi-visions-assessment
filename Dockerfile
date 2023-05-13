FROM openjdk:8-jre-alpine3.9
COPY target/digi-visions-assessment.war digi-visions-assessment.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","digi-visions-assessment.war"]