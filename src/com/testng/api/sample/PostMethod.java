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
		String name = "00000024";
		String job = "6017";

		
		String jsonBody = "{\"name\" : \"" +name+ "\", "\"job\" : \"" +job+  "\"}";
		
		System.out.println("Request --> " + jsonBody);
		
		//POST Method to purchase mobile prepaid product
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
		request = this.restTemplate.postForEntity(addURI, entity, String.class);
		
		//get response body
		responseBody = request.getBody().toString();
		System.out.println("Response Body ---> " +responseBody);

		String code = GetResponse.extractResponse(responseBody, "code");
		System.out.println("Code = "+code);
		
		String custRefNo = GetResponse.extractResponse(responseBody, "custRefNo");
		System.out.println("CustRefNo = "+custRefNo);
		
		String message = GetResponse.extractResponse(responseBody, "message");
		System.out.println("Message = "+message);
		
		//check the response body
		Assert.assertEquals(request.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(GetResponse.extractResponse(responseBody, "message"), "Success"); //expected to Sukses
		logger.info("Mobile Prepaid Purchase succeded with custRefNo : " +custRefNo);	
	}
	

	@AfterTest
	public void afterTest() {
		logger.info("clean up after test execution");
		logger.info("creating RestTemplate object as null");
		this.restTemplate = new RestTemplate();
	}	
	
}
