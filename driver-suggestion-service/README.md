#  Driver-suggestion-service 


# Getting Started

# Overview



###  Prerequisite
- MySql Database
- Java 8
- Maven 	
- Kafka
- Zookeeper

###APIs
The following APIs were implemented as part of building this project:
Postman Collection:

#Kafka Consumer:
Project is attached to Kafka Topic consumer group: driver_location



###  Build Project
- Go to project dir
- mvn clean install


###  Run Project
- To run project use below command:
java -jar  driver-suggestion-service.jar

	

to externally pass configs, use below command;
 java -Dspring.config.location={path_to_config_file} -jar  driver-suggestion-service.jar


### Docker Image Create:
docker build -t driver-suggestion-service:1.0.0 .


### Run Project with Dependencies: Kafka, ZooKeeper, MySQL
docker-compose up