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

public class GetMethod {
	
	private String responseBody;
	
	final static Logger logger = Logger.getLogger(GetMethod.class);
	
	private String id = "2";
	
	private ResponseEntity<String> requestGet;
	
	private RestTemplate restTemplate; 
	
	@BeforeTest
	public void beforeTest() throws IOException, ParseException {
		this.restTemplate = new RestTemplate();
	}
	
	@Test
	public void getMethod() throws IOException, ParseException{
		
		String getURI = "https://reqres.in/api/users?page="+this.id;
		logger.info("Get URI : "+getURI);
		System.out.println("String GET Method is : "+getURI);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		HttpEntity<String> entity = new HttpEntity<String>(headers); 
		
		requestGet = this.restTemplate.getForEntity(getURI, String.class, entity);
		
		System.out.println("hit : " +requestGet);
		
		responseBody = requestGet.getBody().toString();
		
		System.out.println("Response GET Method : "+responseBody);
		
		Assert.assertEquals(requestGet.getStatusCode(), HttpStatus.OK);	
	}
	
	@AfterTest
	public void afterTest() {
		logger.info("clean up after execution");
		logger.info("creating restTemplate object as null");
		this.restTemplate = new RestTemplate();
	}

}
