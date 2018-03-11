package com.pinDrop.apiTest.apiTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import com.jayway.jsonpath.Predicate.PredicateContext;
import com.thoughtworks.qdox.model.expression.Equals;

public class Util {

	/**
	 * Returns Json data for given Json path as a list of string from given Json response
	 * @param jsonPath
	 * @param jsonresponse
	 * @return
	 */
	public static List<String> getJSONData(String jsonPath, String jsonResponse) {
		List<String> values = new ArrayList<String>();
		try {
			values = JsonPath.read(jsonResponse, jsonPath);
		} catch (InvalidPathException e) {
			return null;
		}
		return values;
	}

	/**
	 * Wrapper method to calculate expected result for TestGetListByAreaCode using given area code
	 * @param areacode
	 * @return
	 */
	public static List<String> WrapperTestGetListByAreaCode(String areacode) {
		List<String> expectedResult = null;
		try {
			String data = new String(Files
					.readAllBytes(Paths.get("../apiTest/src/test/java/com/pinDrop/apiTest/apiTest/TestData.json")));
			expectedResult = JsonPath.parse(data).read("$..[?(@.area_code ==" + areacode + ")].phone_number");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expectedResult;
	}

	/**
	 * Helper method to verify List of phone numbers against given area code
	 * @param response
	 * @param areacode
	 * @return
	 */
	public static boolean VerifyAllPhoneWithAreaCode(List<String> response, String areacode) {
		boolean result = false;
		Iterator<String> itr = response.iterator();
		while (itr.hasNext()) {
			String phone_numer = itr.next();
			String phone_numer1 = phone_numer.replaceAll("[^0-9]", "");
			result = phone_numer1.substring(0, 3).equals(areacode);
		}
		return result;
	}

	/**
	 * wrapper method to calculate expected result for TestGetAllResults
	 * @return
	 */
	public static List<String> WrapperTestGetAllResults() {
		List<String> expectedResult = null;
		try {
			String data = new String(Files
					.readAllBytes(Paths.get("../apiTest/src/test/java/com/pinDrop/apiTest/apiTest/TestData.json")));
			expectedResult = JsonPath.parse(data).read("$.*");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expectedResult;
	}
}
