package config.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BasicController { 
	
	@Autowired
	Environment environment;

	@RequestMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
	public String index() {

		String msg = "Spring Boot";
		msg += InetAddress.getLoopbackAddress().getHostAddress()  + "-";
		msg += InetAddress.getLoopbackAddress().getHostName()  + "----------";
		
		msg += System.getenv("HOSTNAME");
		
		return msg;
	}

}