package com.testng.api.sample;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetResponse {
	
	static String extractResponse(String json, String fieldResponse) {
		JSONParser parser = new JSONParser();
		JSONObject jsonResponseObject = new JSONObject();
		Object obj = new Object();
			try {
				obj = parser.parse(json);
			} catch(org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		jsonResponseObject = (JSONObject) obj;
		
		String responseBG = jsonResponseObject.toString();
		
		String code = jsonResponseObject.get("code").toString();

		String custRefNo = jsonResponseObject.get("custRefNo").toString();
		
		String message = jsonResponseObject.get("message").toString();
		
		switch(fieldResponse) {
			case "code": 
				return code;
			case "custRefNo": 
				return custRefNo;
			case "message": 
				return message;
		}
		return responseBG;	
	}
	
}