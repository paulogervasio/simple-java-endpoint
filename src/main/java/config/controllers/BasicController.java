package config.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BasicController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String hello() {
		return "Hello from Spring Boot!";
	}

	@RequestMapping("/chaining")
	public String chaining() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/", String.class);
		return "Chaining + " + response.getBody();
	}
}