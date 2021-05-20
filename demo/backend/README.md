## app-backend deployment

Run backend application on local system

import backend repository as a maven project on any IDE then use ide tools to run backend application

or

```shell
cd backend
mvn spring-boot:run
```

or 

create run as a standalone jar

```shell
cd backend
mvn clean build
java -jar target/app-backend.jar
```

application exposed two endpoints

1. Details - provide details of the system(IP, Port, Hostname) where it is running
2. UserDetails - provide details of the user for provided details

