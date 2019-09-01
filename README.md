# simple-java-endpoint - Using Keycloack
A very simple java endpoint example, using spring-boot-starter.

## Keycloack
### To run keycloack
docker run -p 8180:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=123456 jboss/keycloak


### Access:
http://localhost:8180

### and create:
realm=springbootrealm
client=login-app
role=user

and users to assign to the role created.






## Spring Boot

### To Build Docker image:
docker build -t paulogervasio:simple-java-endpoint

### To create and run a new container:
docker run -tid -p8089:8081 paulogervasio:simple-java-endpoint
