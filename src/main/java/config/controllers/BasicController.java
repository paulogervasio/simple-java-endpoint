package config.controllers;

import org.springframework.web.bind.annotation.RestController;

import config.aspects.LogExecutionTime;
import config.aspects.ValidateSecurityAccess;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BasicController { 
	
	@Autowired
	Environment environment;

	@RequestMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("@securityService.hasAccess(2)")
	@ValidateSecurityAccess(roleName="teste")
	@LogExecutionTime
	public String index(String teste) {

		String msg = "Spring Boot";
		msg += InetAddress.getLoopbackAddress().getHostAddress()  + "-";
		msg += InetAddress.getLoopbackAddress().getHostName()  + "----------";
		
		msg += System.getenv("HOSTNAME");
		
		return "only logged - login info printed here:";
	}
	
	@RequestMapping(value="/private2", produces=MediaType.APPLICATION_JSON_VALUE)
	public String callPrivateEndpoint2() {
		return "private endpoint - only logged role user2";
	}	
	
	@RequestMapping(value="/public", produces=MediaType.APPLICATION_JSON_VALUE)
	public String callPublicEndpoint() {
		return "public endpoint - all can see - even not logged";
	}	

}