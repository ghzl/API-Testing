package com.testng.api.sample;

import java.io.IOException;
import java.text.ParseException;

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


public class PostMethod {
	private String responseBody;
	public String responseBodyPost;
	final static Logger logger = Logger.getLogger(PostMethod.class);
	
	//resttemplate object
	private RestTemplate restTemplate;

	//create response entity, stores http response code, response body, etc
	private ResponseEntity<String> request;
	
	@BeforeTest
	public void beforeTest() throws IOException, ParseException {
		logger.info("Setting up prerequisite for test execution");
		logger.info("Creating resttemplate object before tests");
		this.restTemplate = new RestTemplate();	
	}

	/**
     * Test Method to send request using HTTP POST method
     * 
     * Verifies POST action Status Code 
     *  
     * @throws IOException
     * @throws ParseException
     */
	@Test
	public void postMethod() throws IOException, ParseException{
		String addURI = "https://reqres.in/api/users";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		logger.info("Add URL: "+addURI);
		String sendName = "Ghozali";
		String sendJob = "QA";

		String jsonBody = "{\"name\" : \"" +sendName+ "\",\"job\":\"" +sendJob+ "\"}";

		System.out.println("Request --> " + jsonBody);
		
		//POST Method to send user registration
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		request = this.restTemplate.postForEntity(addURI, entity, String.class);
		
		//get response body
		responseBody = request.getBody().toString();
		System.out.println("Response Body ---> " +responseBody);

		String name = ExtractResponse.getExtractResponse(responseBody, "name");
		
		System.out.println("Name = "+name);
		
		String job = ExtractResponse.getExtractResponse(responseBody, "job");
		System.out.println("Job = "+job);
		
		String id = ExtractResponse.getExtractResponse(responseBody, "id");
		System.out.println("ID = "+id);
		
		String createdAt = ExtractResponse.getExtractResponse(responseBody, "createdAt");
		System.out.println("Created At = "+createdAt);
		
		//check the response body
		Assert.assertEquals(request.getStatusCode(), HttpStatus.CREATED); //expected to 201 - created
		//Assert.assertEquals(GetResponse.extractResponse(responseBody, "message"), "Success"); //expected to Sukses
		logger.info("POST succeded with id : " +id);
	}
	

	@AfterTest
	public void afterTest() {
		logger.info("clean up after test execution");
		logger.info("creating RestTemplate object as null");
		this.restTemplate = new RestTemplate();
	}	
	
}
