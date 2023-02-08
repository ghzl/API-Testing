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
		
		String putURI = "https://reqres.in/api/users/"+this.id;
		logger.info("PUT URI : "+putURI);
		System.out.println("PUT URI is : "+putURI);
		
		//add http headers
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		//build json body
		String sendName = "Ghozali";
		String sendJob = "QA Engineer";
		String jsonBody = "{\"name\" : \"" +sendName+ "\",\"job\":\"" +sendJob+ "\"}";
		System.out.println("PUT Request --> " + jsonBody);
		
		//send PUT request
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		System.out.println("Entity : " +entity);
		
		requestPut = this.restTemplate.exchange(putURI, HttpMethod.PUT, entity, String.class);
		System.out.println("Received PUT Response : "+requestPut);
			
		//get body response		
		responseBody = requestPut.getBody().toString();
		System.out.println("Response Body: "+responseBody);
		
		//get detailed field from body response
		String name = ExtractResponse.getDetailPutResponse(responseBody, "name");
		System.out.println("PUT Response : " +name);
		
		String job = ExtractResponse.getDetailPutResponse(responseBody, "job");
		System.out.println("Job : " +job);

		String updatedAt = ExtractResponse.getDetailPutResponse(responseBody, "updatedAt");
		System.out.println("Updated at : " +updatedAt);
		
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
