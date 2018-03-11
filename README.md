# reactive-microservices

Comparison between traditional REST api using synchronous and blocking response versus reactive and non-blocking model.

## How to run the tests

1. Start payment-service microservice:
```
cd payment-service
mvn spring-boot:run
```

2. Start either traditional or reactive microservice:
```
cd payment-rest-api
mvn spring-boot:run
```
or
```
cd payment-rest-reactive-api
mvn spring-boot:run
```

3. Start gatling load test
```
cd gatling-load-test
mvn -DSIM_USERS=1000 gatling:execute
```

_SIM\_USERS_ is an environment variable to specify how many concurrent users shoud be loaded.

4. `wrk` is also available to measure throughput. Check `wrk/run.sh` script with some samples.