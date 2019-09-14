# simian-api
JAVA 8 and Spring Boot API

# Run in Terminal
** IMPORTANT: You should install Docker and docker compose
** JDK 8
** Run all the commands bellow inside the root directory of this project


First Time Configuration:

Build
```
./gradlew build
```

Generate Docker Application Image:
```
docker build -t musicapi .
```

Now start all enviroment:
```
**docker-compose rm (case exists old builds, you need remove)
docker-compose up
```

CHECK HEALTH STATUS EXAMPLE(LOCAL):

```
GET
http://localhost:8080/actuator/health
```

CREATE NEW DNA HEALTH STATUS EXAMPLE (LOCAL):

```
POST
http://localhost:8080/simian
```

GET STATS EXAMPLE (LOCAL):

```
POST
http://localhost:8080/stats
```

*HEROKU ENDPOINTS*

CHECK HEALTH STATUS EXAMPLE(LOCAL):

```
GET
https://simios-api.herokuapp.com/actuator/health
```

CREATE NEW DNA HEALTH STATUS EXAMPLE (LOCAL):

```
POST
https://simios-api.herokuapp.com/simian
```

GET STATS EXAMPLE (LOCAL):

```
POST
https://simios-api.herokuapp.com/stats
```
