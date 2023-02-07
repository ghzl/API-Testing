package com.testng.api.sample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExtractResponse {
	
	static String getExtractResponse(String json, String fieldResponse) {
		JSONParser parser = new JSONParser();
		JSONObject jsonResponseObject = new JSONObject();
		Object obj = new Object();
			try {
				obj = parser.parse(json);
			} catch(org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		jsonResponseObject = (JSONObject) obj;
		
		String responseAPI = jsonResponseObject.toString();
		
		String name = jsonResponseObject.get("name").toString();

		String job = jsonResponseObject.get("job").toString();
		
		String id = jsonResponseObject.get("id").toString();
		
		String createdAt = jsonResponseObject.get("createdAt").toString();		
		
		
		switch(fieldResponse) {
			case "name": 
				return name;
			case "job": 
				return job;
			case "id": 
				return id;
			case "createdAt":
				return createdAt;
		}
		return responseAPI;	
	}
	
}