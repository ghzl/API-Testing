package com.testng.api.sample;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class PutMethod {
	
	private String responseBody;
	
	final static Logger logger = Logger.getLogger(PutMethod.class);
	
	private String id = "2";
	
	private RestTemplate restTemplate;
	
	private ResponseEntity<String> requestPut;
	
	@BeforeTest
	public void beforeTest() throws IOException, ParseException {
		
		this.restTemplate = new RestTemplate();
	}
	
	@Test
	public void putMethod() throws IOException, ParseException{
		
		String putURI = "http://reqres.in/api/users/"+this.id;
		logger.info("PUT URI : "+putURI);
		System.out.println("PUT URI is : "+putURI);
		
		//add http headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		//build json body
		String name = "Ghozali";
		String job = "QA Engineer";
		String jsonBody = "{\"name\" : \"" +name+ "\",\"job\":\"" +job+ "\"}";
		System.out.println("PUT Request --> " + jsonBody);
		
		//send PUT request
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		
		requestPut = this.restTemplate.put(putURI, entity);
			
		//get body response		
		responseBody = requestPut.getBody().toString();
		System.out.println("Response Body id : "+responseBody);
		
		//assert response		
		Assert.assertEquals(requestPut.getStatusCode(), HttpStatus.OK);	
	}
	
	@AfterTest
	public void afterTest() {
		logger.info("clean up after execution");
		logger.info("creating RestTemplate object as null");
		this.restTemplate = new RestTemplate();
	}
	

}
