FROM openjdk:8-jre-alpine
WORKDIR /app
COPY target/driver-suggestion-service.jar /app
CMD chmod +774 driver-suggestion-service.jar
EXPOSE 9080
CMD sleep 20 && java -jar driver-suggestion-service.jar
