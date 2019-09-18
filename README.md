# simple-java-endpoint - Using Jaeger
A very simple java endpoint example, using spring-boot-starter.


```
docker run -ti -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 16686:16686 -p 9411:9411 jaegertracing/all-in-one
```


After clone this project execute:

```
mvn clean install
```

After run the server:

```
java -jar target/simple-java-endpoint-0.1.0.jar
```

Call the endpoint:

```
curl -v localhost:9090/
```

And run in the browser:

```
http://localhost:16686
```

Click in find traces and visualize all Traces input.



## Spring Boot

### To Build Docker image:
docker build -t paulogervasio:simple-java-endpoint

### To create and run a new container:
docker run -tid -p8089:8081 paulogervasio:simple-java-endpoint
