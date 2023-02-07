package com.testng.api.sample;

public class RandomString {
	
	static String getBankRefNo(int n) {
	String alphaNumericString = "ABCDEFGH" + "0123456" + "abcdefgh";
	int i;
	StringBuilder sb = new StringBuilder();
	for (i=0; i<=n; i++) {
		int index = (int) (alphaNumericString.length() * Math.random());
		sb.append(alphaNumericString.charAt(index));
	}
	return sb.toString();
	}

}
