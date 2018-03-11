package com.pinDrop.apiTest.apiTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jayway.jsonpath.JsonPath;
import com.pinDrop.apiTest.apiTest.TestHelper;

import junit.framework.Assert;
import junit.textui.TestRunner;

public class AppTest extends TestRunner {

	@Test
	public void TestGetListByAreaCode242() {
		assertEquals("Area Code is 242", Util.WrapperTestGetListByAreaCode("242"), TestHelper.getListByAreaCode("242"));
	}

	@Test
	public void TestGetListByAreaCode2() {
		assertEquals("Area Code is 2", 0, TestHelper.getListByAreaCode("2").size());
	}

	@Test
	public void TestGetListByAreaCode24() {
		assertEquals("Area Code is 24", 0, TestHelper.getListByAreaCode("24").size());
	}

	@Test
	public void TestGetListByAreaCodeBracket42() {
		assertEquals("Area Cojde is (42", 0, TestHelper.getListByAreaCode("(42").size());
	}

	@Test
	public void TestGetListByAreaCode426() {
		assertEquals("Area Code is 426", true, TestHelper.getListByAreaCode("426").size() > 0);
	}

	@Test
	public void TestGetListByAreaCode4624() {
		assertEquals("Area Code is 4624", true, TestHelper.getListByAreaCode("4264").size() == 0);
	}

	@Test
	public void TestGetListByAreaCode844hiphen85() {
		assertEquals("Area Code is 844-85", true, TestHelper.getListByAreaCode("844-85").size() == 0);
	}

	@Test
	public void TestGetListByAreaCode242WithLimit2() {
		assertEquals("Area Code is 242, Limit is 2", Util.WrapperTestGetListByAreaCode("242"),
				TestHelper.getListByAreaCode("242"));
		assertEquals("Area Code is 242, Limit is 2", true,
				TestHelper.getListByAreaCodeWithLimit("242", "2").size() <= 2);
		assertEquals("Area Code is 242, Limit is 2", true,
				Util.VerifyAllPhoneWithAreaCode(TestHelper.getListByAreaCodeWithLimit("242", "2"), "242"));
	}

	@Test
	public void TestGetListByAreaCode325WithLimit10() {
		assertEquals("Area Code is 325, Limit is 10", Util.WrapperTestGetListByAreaCode("325"),
				TestHelper.getListByAreaCode("325"));
		assertEquals("Area Code is 325, Limit is 10", true,
				TestHelper.getListByAreaCodeWithLimit("325", "10").size() <= 10);
		assertEquals("Area Code is 325, Limit is 10", true,
				Util.VerifyAllPhoneWithAreaCode(TestHelper.getListByAreaCodeWithLimit("325", "10"), "325"));
	}

	@Test
	public void TestGetListByAreaCode325WithLimit5() {
		assertEquals("Area Code is 325, Limit is 5", Util.WrapperTestGetListByAreaCode("325"),
				TestHelper.getListByAreaCode("325"));
		assertEquals("Area Code is 325, Limit is 5", true,
				TestHelper.getListByAreaCodeWithLimit("325", "5").size() <= 5);
		assertEquals("Area Code is 325, Limit is 5", true,
				Util.VerifyAllPhoneWithAreaCode(TestHelper.getListByAreaCodeWithLimit("325", "5"), "325"));
	}

	@Test
	public void TestGetListByAreaCode325WithLimit0() {
		assertEquals("Area Code is 325, Limit is 0", Util.WrapperTestGetListByAreaCode("325"),
				TestHelper.getListByAreaCode("325"));
		assertEquals("Area Code is 325, Limit is 0", true,
				TestHelper.getListByAreaCodeWithLimit("325", "0").size() == 0);
		assertEquals("Area Code is 325, Limit is 0", true,
				Util.VerifyAllPhoneWithAreaCode(TestHelper.getListByAreaCodeWithLimit("325", "0"), "325"));
	}

	@Test
	public void TestGetListByAreaCode84WithLimit7() {		
		assertEquals("Area Code is 84, Limit is 7", true, TestHelper.getListByAreaCodeWithLimit("84", "7").size() == 0);
}

	@Test
	public void TestGetListByAreaCode844WithLimit9999999999999999999999999() {
		assertEquals("Area Code is 844, Limit is 9999999999999999999999999", Util.WrapperTestGetListByAreaCode("844"),
				TestHelper.getListByAreaCode("844"));
		assertEquals("Area Code is 844, Limit is 9999999999999999999999999", true,
				TestHelper.getListByAreaCodeWithLimit("844", "9999999999999999999999999").size() <= Integer.MAX_VALUE);
		assertEquals("Area Code is 844, Limit is 9999999999999999999999999", true,
				Util.VerifyAllPhoneWithAreaCode(TestHelper.getListByAreaCodeWithLimit("844", "9999999999999999999999999"), "844"));
	}
	
	@Test
	public void TestGetAllReultsWithLimit2() {
		assertEquals(true, TestHelper.getAllReultsWithLimit("2").size() == 2);
	}

	@Test
	public void TestGetAllReultsWithLimit5() {
		assertEquals(true, TestHelper.getAllReultsWithLimit("5").size() == 5);
	}

	@Test
	public void TestGetAllReultsWithLimit10() {
		assertEquals(true, TestHelper.getAllReultsWithLimit("10").size() == 10);
	}

	@Test
	public void TestGetAllReultsWithLimit50() {
		assertEquals(true, TestHelper.getAllReultsWithLimit("50").size() <= 50);
	}

	@Test
	public void TestGetAllReultsWithLimit0() {
		assertEquals(true, TestHelper.getAllReultsWithLimit("0").size() == 0);
	}

	@Test
	public void TestGetAllReultsWithLimit999999999999999999() {
		assertEquals(true, TestHelper.getAllReultsWithLimit("999999999999999999").size() <= Integer.MAX_VALUE);
	}

	@Test
	public void TestGetAllReultsWithLimit9999999999999999999() {
		assertEquals(true, (TestHelper
				.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/9999999999999999999") == 200));
	}

	@Test
	public void TestGetAllReultsWithLimita() {
		assertEquals("", true,
				(TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/a") >= 400
						&& TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/a") < 500));
	}

	@Test
	public void TestGetAllReultsWithLimitMinus1() {
		assertEquals("", true,
				(TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/-1") >= 400
						&& TestHelper
								.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/-1") < 500));
	}

	@Test
	public void TestGetAllReultsWithLimit$() {
		assertEquals("", true,
				(TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/$") >= 400
						&& TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/$") < 500));
	}

	@Test
	public void TestGetAllReults() {
		assertEquals("Get All results", Util.WrapperTestGetAllResults(), TestHelper.getAllReults());
	}

	@Test
	public void TestGetHttpResponseCode200_1() {
		assertEquals("Get Http Response code - 200", 200,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results"));
	}

	@Test
	public void TestGetHttpResponseCode200_2() {
		assertEquals("Get Http Response code - 200", 200,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/4"));
	}

	@Test
	public void TestGetHttpResponseCode200_3() {
		assertEquals("Get Http Response code - 200", 200,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/resultsForArea/242"));
	}

	@Test
	public void TestGetHttpResponseCode200_4() {
		assertEquals("Get Http Response code - 200", 200,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/resultsForArea/242/2"));
	}
	
	@Test
	public void TestGetHttpResponseCode200_5() {
		assertEquals("Get Http Response code - 200", 200,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/resultsForArea/aaa/6"));
	}
	
	@Test
	public void TestGetHttpResponseCode200_6() {
		assertEquals("Get Http Response code - 200", 200,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/resultsForArea/*"));
	}

	@Test
	public void TestGetHttpResponseCode4XX() {
		assertEquals("Get Http Response code - 4XX", true,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0") >= 400);
	}

	@Test
	public void TestGetHttpResponseCode5XX() {
		assertEquals("Get Http Response code - 5XX", 500,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/9999999999999999999"));
	}

	@Test
	public void TestGetHttpResponseCode404_1() {
		assertEquals("Get Http Response code - 404", 404,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v2.0/results"));
	}

	@Test
	public void TestGetHttpResponseCode404_2() {
		assertEquals("Get Http Response code - 404", 404,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/results/"));
	}

	@Test
	public void TestGetHttpResponseCode404_3() {
		assertEquals("Get Http Response code - 404", 404,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/resultsForArea/844/q"));
	}

	@Test
	public void TestGetHttpResponseCode404_4() {
		assertEquals("Get Http Response code - 404", 404,
				TestHelper.getHttpResponseCode("http://localhost:5000/interview/api/v1.0/resultsForArea/*/*"));
	}
	
	@Test
	public void TestValidateJsonResponse1() {
		assertEquals("Validate JSON Response for all Results", true,
				TestHelper.validateJsonResponse("http://localhost:5000/interview/api/v1.0/results"));
	}

	@Test
	public void TestValidateJsonResponse2() {

		assertEquals("Validate JSON Response for all Results", true,
				TestHelper.validateJsonResponse("http://localhost:5000/interview/api/v1.0/results/4"));
	}

	@Test
	public void TestValidateJsonResponse3() {
		assertEquals("Validate JSON Response for all Results", true,
				TestHelper.validateJsonResponse("http://localhost:5000/interview/api/v1.0/resultsForArea/242"));
	}

	@Test
	public void TestValidateJsonResponse4() {
		assertEquals("Validate JSON Response for all Results", true,
				TestHelper.validateJsonResponse("http://localhost:5000/interview/api/v1.0/resultsForArea/961/2"));
	}


	@Test
	public void TestValidateJsonData1() {
		assertEquals("Area Code", true, TestHelper.getJsonData("area_code").size() > 0);
	}
	@Test
	public void TestValidateJsonData2() {
		assertEquals("Phone Number", true, TestHelper.getJsonData("phone_number").size() > 0);
	}
	@Test
	public void TestValidateJsonData3() {
		assertEquals("Report Count", true, TestHelper.getJsonData("report_count").size() > 0);
	}
	@Test
	public void TestValidateJsonData4() {
		assertEquals("Comment", true, TestHelper.getJsonData("comment").size() > 0);
	}
	@Test
	public void TestValidateJsonData5() {
		assertEquals("Comment", true, TestHelper.getJsonData("comment1").size() == 0);
	}
	@Test
	public void TestValidateJsonData6() {
		assertEquals("Area Code", true, TestHelper.getJsonDataWithLimit("area_code", "2").size() > 0);
	}
	@Test
	public void TestValidateJsonData7() {
		assertEquals("Phone Number", true, TestHelper.getJsonDataWithLimit("phone_number", "2").size() > 0);
	}
	@Test
	public void TestValidateJsonData8() {
		assertEquals("Report Count", true, TestHelper.getJsonDataWithLimit("report_count", "2").size() > 0);
	}
	@Test
	public void TestValidateJsonData9() {
		assertEquals("Comment", true, TestHelper.getJsonDataWithLimit("comment", "2").size() > 0);
	}
	@Test
	public void TestValidateJsonData10() {
		assertEquals("Report Count", true, TestHelper.getJsonDataWithLimit("report_count", "0").size() == 0);
	}
	@Test
	public void TestValidateJsonData11() {
		assertEquals("Comment", true, TestHelper.getJsonDataWithLimit("comment1", "2").size() == 0);
	}
	@Test
	public void TestValidateJsonData12() {
		assertEquals("Area Code", true, TestHelper.getJsonDataWithAreaCode("area_code", "242").size() > 0);
	}
	@Test
	public void TestValidateJsonData13() {
		assertEquals("Phone Number", true, TestHelper.getJsonDataWithAreaCode("phone_number", "961").size() > 0);
	}
	@Test
	public void TestValidateJsonData14() {
		assertEquals("Report Count", true, TestHelper.getJsonDataWithAreaCode("report_count", "770").size() > 0);
	}
	@Test
	public void TestValidateJsonData15() {
		assertEquals("Comment", true, TestHelper.getJsonDataWithAreaCode("comment", "719").size() > 0);
	}
	@Test
	public void TestValidateJsonData16() {
		assertEquals("Comment", true, TestHelper.getJsonDataWithAreaCode("comment1", "719").size() == 0);
	}
	@Test
	public void TestValidateJsonData17() {
		assertEquals("Area Code", true, TestHelper.getJsonDataWithAreaCodeAndLimit("area_code", "510", "1").size() > 0);
	}
	@Test
	public void TestValidateJsonData18() {
		assertEquals("Phone Number", true,
				TestHelper.getJsonDataWithAreaCodeAndLimit("phone_number", "844", "2").size() > 0);
	}
	@Test
	public void TestValidateJsonData19() {
		assertEquals("Report Count", true,
				TestHelper.getJsonDataWithAreaCodeAndLimit("report_count", "602", "3").size() > 0);
	}
	@Test
	public void TestValidateJsonData20() {
		assertEquals("Comment", true, TestHelper.getJsonDataWithAreaCodeAndLimit("comment", "325", "4").size() > 0);
	}
	@Test
	public void TestValidateJsonData21() {
		assertEquals("Report Count", true,
				TestHelper.getJsonDataWithAreaCodeAndLimit("report_count", "602", "0").size() == 0);
	}
	@Test
	public void TestValidateJsonData22() {
		assertEquals("Comment", true, TestHelper.getJsonDataWithAreaCodeAndLimit("comment1", "325", "4").size() == 0);
	}

}
