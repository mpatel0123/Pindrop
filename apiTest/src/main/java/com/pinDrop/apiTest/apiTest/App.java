package com.pinDrop.apiTest.apiTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App

{
	
	static RestAPIUtil api = new RestAPIUtil();

	public static void main(String[] args) {

		
		String str = api.apiMethod_GET("http://localhost:5000/interview/api/v1.0/results");
		
		System.out.println(str);
		try {
			//List<String> values = JSON_Response.getListOfFieldDataInJSON("", str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
