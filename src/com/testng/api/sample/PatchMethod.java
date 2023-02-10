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

public class PatchMethod {
	
	private RestTemplate restTemplate;
	
	private String responseBody;
	
	private ResponseEntity<String> requestPatch;
	
	final static Logger logger = Logger.getLogger(PatchMethod.class);
	
	
	@BeforeTest	
	public void beforeTest() throws IOException, ParseException {
		
		this.restTemplate = new RestTemplate();
		
	}
	
	@Test
	public void hitPatchMethod () throws IOException, ParseException {
		
		//set PATCH method URI
		String patchURI = "https://reqres.in/api/users/2";
		logger.info("PATCH Method URI : "+patchURI);
		System.out.println("PATCH Method URI : "+patchURI);
		
		//add http header
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");
		
		//build json body
		String patchName = "Ghozali";
		String patchJob = "Owner";
		String jsonBody = "{\"name\": \""+patchName+"\",\"job\":\""+patchJob+"\"}";
		System.out.println("JSON Body sent : " +jsonBody);
		
		//sent PATCH request
		HttpEntity<String> entity = new HttpEntity<String>(jsonBody,headers);
		System.out.println("Send Patch Request"+entity);
		
		requestPatch = this.restTemplate.exchange(patchURI, HttpMethod.PATCH, entity, String.class);
		
		//get PATCH response
		responseBody = requestPatch.getBody().toString();
		System.out.println("Patch Response Received : "+responseBody);
		
		//get Detailed PATCH response
		String patchResponseName = ExtractResponse.getDetailPatchResonse(responseBody, "name");
		System.out.println("Name : "+patchResponseName);
		
		String patchResponseJob = ExtractResponse.getDetailPatchResonse(responseBody, "job");
		System.out.println("Job : "+patchResponseJob);
		
		String patchResponseUpdatedAt = ExtractResponse.getDetailPatchResonse(responseBody, "updatedAt");
		System.out.println("Updated At : "+patchResponseUpdatedAt);	
		
		Assert.assertEquals(requestPatch.getStatusCodeValue(),HttpStatus.OK);
		
	}
	
	@AfterTest
	public void afterTest() {
		logger.info("Clean up after execution");
		logger.info("creating rest template object as null");
		this.restTemplate = new RestTemplate();
	}

}
