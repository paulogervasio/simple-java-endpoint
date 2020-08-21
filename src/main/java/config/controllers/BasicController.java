package config.controllers;

import org.springframework.web.bind.annotation.RestController;


import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
public class BasicController { 
	
	
    private static final Logger logger = LogManager.getLogger(BasicController.class);

	
	@Autowired
	Environment environment;

	@RequestMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
	public String index() {
		
        logger.info("Info log");


		String msg = "Spring Boot\n";
		msg += InetAddress.getLoopbackAddress().getHostAddress()  + "\n";
		msg += InetAddress.getLoopbackAddress().getHostName()  + "\n";
		msg += System.currentTimeMillis() + "\n";
		
		msg += System.getenv("HOSTNAME");
		
		return msg;
	}

}