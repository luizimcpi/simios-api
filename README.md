# simian-api
JAVA 8 and Spring Boot API

# Run in Terminal
** IMPORTANT: You should install Docker and docker compose
** JDK 8
** Run all the commands bellow inside the root directory of this project



## LOCAL INSTRUCTIONS

*Execute tests*
```
./gradlew test
```

*Run*
```
./gradlew bootRun
```


## DOCKER INSTRUCTIONS

Build
```
./gradlew build
```

Generate Docker Application Image:
```
docker build -t simianapi .
```

Now start all enviroment:
```
**docker-compose rm (case exists old builds, you need remove)
docker-compose up
```

### LOCAL ENDPOINTS
CHECK HEALTH STATUS EXAMPLE:

```
GET
http://localhost:8080/actuator/health
```

CREATE NEW DNA HEALTH STATUS EXAMPLE:

```
POST
http://localhost:8080/simian
```

GET STATS EXAMPLE:

```
GET
http://localhost:8080/stats
```

### HEROKU ENDPOINTS

CHECK HEALTH STATUS EXAMPLE:

```
GET
https://simios-api.herokuapp.com/actuator/health
```

CREATE NEW DNA HEALTH STATUS EXAMPLE:

```
POST
https://simios-api.herokuapp.com/simian
```

GET STATS EXAMPLE:

```
GET
https://simios-api.herokuapp.com/stats
```
