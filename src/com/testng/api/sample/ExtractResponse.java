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
	
	static String getDetailPutResponse(String json, String putResponseField) {
		JSONParser parser2 = new JSONParser();
		JSONObject putResponseObject = new JSONObject();
		Object obj2 = new Object();
			try{
				obj2 = parser2.parse(json);
			}catch(org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
			
		putResponseObject = (JSONObject) obj2;
		String putResponse = putResponseObject.toString();
		
		String name = putResponseObject.get("name").toString();
				
		String job = putResponseObject.get("job").toString();
		
		String updatedAt = putResponseObject.get("updatedAt").toString();
		
		switch(putResponseField) {
		case "name":
			return name;
		case "job":
			return job;
		case "updatedAt":
			return updatedAt;
		}
		return putResponse;
	}
	
	static String getDetailPatchResonse(String json, String patchResponseField) {
		JSONParser parser3 = new JSONParser();
		JSONObject patchResponseObject = new JSONObject();
		Object obj3 = new Object();
			try {
				obj3 = parser3.parse(json);
			}catch(org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		patchResponseObject = (JSONObject) obj3;
		String patchResponse = patchResponseObject.toString();
		
		String patchName = patchResponseObject.get("name").toString();
		
		String patchJob = patchResponseObject.get("job").toString();
		
		String patchUpdatedAt = patchResponseObject.get("updatedAt").toString();
		
		switch(patchResponseField) {
		case "name":
			return patchName;
		case "job":
			return patchJob;
		case "updatedAt":
			return patchUpdatedAt;
		}
		return patchResponse;
	}
}