package com.pinDrop.apiTest.apiTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ResponseCache;
import java.net.URL;

public class RestAPIUtil {

	/**
	 * Returns JSON response as a String from API call to the given uri
	 * 
	 * @param uri
	 * @return
	 */
	public static String apiMethod_GET(String uri) {
		String output = "";
		try {

			URL url = new URL(uri);
			System.out.println("API URL : " + url);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");

			int Responsecode = conn.getResponseCode();

			String ResponseCode = String.valueOf(Responsecode);
			String ResponseMessage = conn.getResponseMessage();
			String LoginContentType = conn.getContentType();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String out;

			while ((out = br.readLine()) != null) {
				output = output + out;
			}
		}

		catch (MalformedURLException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}

	/**
	 * Returns Http Response Code for given uri
	 * 
	 * @param uri
	 * @return
	 */
	public static int getApiResponseCode(String uri) {
		int responseCode = 0;
		try {

			URL url = new URL(uri);
			System.out.println("API URL : " + url);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");

			responseCode = conn.getResponseCode();

		}

		catch (MalformedURLException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return responseCode;
	}

}
