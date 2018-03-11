package com.pinDrop.apiTest.apiTest;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPath;

public class TestHelper {

	/**
	 * Returns list of phone numbers with given area code by calling API
	 * @param areacode
	 * @return
	 */
	public static List<String> getListByAreaCode(String areacode) {
		List<String> result = null;
		try {
			result = Util.getJSONData("$..[?(@.area_code =='" + areacode + "')].phone_number",
					RestAPIUtil.apiMethod_GET("http://localhost:5000/interview/api/v1.0/resultsForArea/" + areacode));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Returns list of phone numbers up to given limit with given area code by calling API
	 * @param areacode
	 * @param limit
	 * @return
	 */
	public static List<String> getListByAreaCodeWithLimit(String areacode, String limit) {
		List<String> result = null;
		try {
			result = Util.getJSONData("$..[?(@.area_code =='" + areacode + "')].phone_number", RestAPIUtil.apiMethod_GET(
					"http://localhost:5000/interview/api/v1.0/resultsForArea/" + areacode + "/" + limit));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Returns list of Json objects up to given limit by calling API
	 * @param limit
	 * @return
	 */
	public static List<String> getAllReultsWithLimit(String limit) {
		List<String> results = null;
		try {
			results = Util.getJSONData("$.*",
					RestAPIUtil.apiMethod_GET("http://localhost:5000/interview/api/v1.0/results/" + limit));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * Returns all the Json objects by calling the API
	 * @return
	 */
	public static List<String> getAllReults() {
		List<String> results = null;
		try {
			results = Util.getJSONData("$.*",
					RestAPIUtil.apiMethod_GET("http://localhost:5000/interview/api/v1.0/results"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * returns Http Response Code as int returned by given uri call
	 * @param Uri
	 * @return
	 */
	public static int getHttpResponseCode(String Uri) {
		int responseCode = 0;
		try {
			responseCode = RestAPIUtil.getApiResponseCode(Uri);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseCode;
	}

	/**
	 * Validates Json format for the response recieved from API call to given uri
	 * @param uri
	 * @return
	 */
	public static boolean validateJsonResponse(String uri) {
		String response = null;
		try {
			response = RestAPIUtil.apiMethod_GET(uri);
			new JSONObject(response);
		} catch (JSONException ex) {
			try {
				new JSONArray(response);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns list of given Json path for all the Json data results
	 * @param jsonPath
	 * @return
	 */
	public static List<String> getJsonData(String jsonPath)
	{
		List<String> result = null;
		try {
			result = Util.getJSONData("$.." + jsonPath,
					RestAPIUtil.apiMethod_GET("http://localhost:5000/interview/api/v1.0/results"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Returns list of given Json path up to given limit for all the Json data results
	 * @param jsonPath
	 * @param limit
	 * @return
	 */
	public static List<String> getJsonDataWithLimit(String jsonPath, String limit)
	{
		List<String> result = null;
		try {
			result = Util.getJSONData("$.." + jsonPath,
					RestAPIUtil.apiMethod_GET("http://localhost:5000/interview/api/v1.0/results/" + limit));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Returns list of given Json path for all the Json data results with given area code
	 * @param jsonPath
	 * @param areacode
	 * @return
	 */
	public static List<String> getJsonDataWithAreaCode(String jsonPath, String areacode)
	{
		List<String> result = null;
		try {
			result = Util.getJSONData("$..[?(@.area_code =='" + areacode + "')]." + jsonPath,
					RestAPIUtil.apiMethod_GET("http://localhost:5000/interview/api/v1.0/resultsForArea/" + areacode));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Returns list of given Json path up to given limit for all the Json data results with given area code
	 * @param jsonPath
	 * @param areacode
	 * @param limit
	 * @return
	 */
	public static List<String> getJsonDataWithAreaCodeAndLimit( String jsonPath, String areacode, String limit)
	{
		List<String> result = null;
		try {
			result = Util.getJSONData("$..[?(@.area_code =='" + areacode + "')]." + jsonPath,
					RestAPIUtil.apiMethod_GET("http://localhost:5000/interview/api/v1.0/resultsForArea/" + areacode +"/"+limit));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
