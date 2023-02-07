package com.testng.api.sample;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class GetMethod {
	
	private String responseBody;
	
	final static Logger logger = Logger.getLogger(GetMethod.class);
	
	private String id = "2";
	
	private ResponseEntity<String> requestGet;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	void getMethod() throws IOException, ParseException{
		
		String getURI = "https://reqres.in/api/users?page="+this.id;
		logger.info("Get URI : "+getURI);
		System.out.println("String GET Method is : "+getURI);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		HttpEntity<String> entity = new HttpEntity<String>(headers); 
		
		requestGet = this.restTemplate.getForEntity(getURI, String.class, entity);
		
		responseBody = requestGet.getBody().toString();
		
		System.out.println("Response GET Method : "+responseBody);
		
		
		
	}

}
