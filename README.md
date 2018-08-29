# simple-java-endpoint
A very simple java endpoint example, using spring-boot-starter.


### To Build Docker image:
docker build -t paulogervasio:simple-java-endpoint

### To create and run a new container:
docker run -tid -p8089:8081 paulogervasio:simple-java-endpoint
