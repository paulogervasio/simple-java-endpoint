## Simple-java-endpoint
A very simple java endpoint example, using spring-boot-starter.

	- Flushs logs in JSON format to a flat file
		- See configs in logback-spring.xml
		

### To Build Docker image:
docker build -t paulogervasio:simple-java-endpoint .

### To create and run a new container:
docker run -tid -p8089:8080 paulogervasio:simple-java-endpoint
