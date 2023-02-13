package com.testng.api.sample;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class DeleteMethod {
	
	private int responseBody;
	
	private RestTemplate restTemplate;
	
	private ResponseEntity<String> requestDelete;
	
	final static Logger logger = Logger.getLogger(DeleteMethod.class);
	
	@BeforeTest
	public void beforeTest() throws IOException, ParseException{
		
		this.restTemplate = new RestTemplate();
		
	}
	
	@Test
	public void deleteMethod() throws IOException, ParseException {
		
		String deleteURI = "https://reqres.in/api/users/2";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		//build delete request
		requestDelete = this.restTemplate.exchange(deleteURI,HttpMethod.DELETE,entity,String.class);
		
		//received response from Delete Request
		responseBody = requestDelete.getStatusCodeValue();
		System.out.println("Delete Method Response is : " +responseBody);
		
		//Assert Delete Response
		Assert.assertEquals(requestDelete.getStatusCode(), HttpStatus.valueOf(204));
		
	}
	
	@AfterTest
	public void afterTest() throws IOException, ParseException{
		logger.info("clean up after execution");
		logger.info("creating rest template object as null");
		this.restTemplate = new RestTemplate();
	}
	
	

}
