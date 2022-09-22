# Java Backend Assessment (SpringBoot)
## Prerequisites
- Docker Desktop: https://www.docker.com/products/docker-desktop/
- Java 17
- Maven 
- IDE (e.g. IntelliJ)
- Postman (REST client)
- DB-Tool (e.g DBeaver)

### Demo Project
The provided SpringBoot demo application is part of the bootcamp assessment. 
Please have look at it and try to get it running and to understand how everything fits together.

- fork the [GIT repo](https://github.com/msedd/mms-demo-app) into your own public space on GitHub
- clone this fork locally
- provide at the end of your assessment your code in your own fork

### Postgres Database 
* start the docker db container
```
 docker compose -f db/docker-compose.yml up -d
```

* stop the docker db container
```
 docker compose -f db/docker-compose.yml stop
```

* stop and delete the docker db container
```
 docker compose -f db/docker-compose.yml down
```


### Build and Start the Application

* build the application
```
 mvn clean install
```
* start the application
```
 java -jar target/demo-app-0.0.1-SNAPSHOT.jar
```
* test the application http://localhost:8080/api/v1.0/user
