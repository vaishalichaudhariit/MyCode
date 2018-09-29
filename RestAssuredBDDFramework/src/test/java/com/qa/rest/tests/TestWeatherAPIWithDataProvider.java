package com.qa.rest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.File;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.rest.reports.BaseClass;
import com.qa.rest.reports.ExtentTestManager;
import com.qa.rest.util.ExcelRederPOI;
import com.relevantcodes.extentreports.LogStatus;

public class TestWeatherAPIWithDataProvider extends BaseClass{

	String currentDir = System.getProperty("user.dir")+File.separator+"src\\main\\java\\com\\qa\\rest\\testdata\\TestData.xlsx";
	
	@DataProvider(name = "PositiveTestScenarios")
	public Object[][] fetchPositiveTestData() throws Exception
	{
		ExcelRederPOI excel = new ExcelRederPOI();
		return excel.readFilenSheet(currentDir, "PositiveTestCaseData");
	}
	
	@SuppressWarnings("rawtypes")
	@Test(priority = -1, dataProvider = "PositiveTestScenarios")
	public void verifyWeatherInforWithPositiveData(Map mObj){
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";
		
		String cityName = mObj.get("City Name")+","+mObj.get("Country Code");
		ValidatableResponse response = RestAssured.given().param("q",cityName)
				.param("appid", mObj.get("App ID")).when()
				.get().then();
		
		Reporter.log("Test Case Name is: "+mObj.get("Test Case Name"), true);
		Reporter.log("Response is: "+response.extract().asString(), true);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Case Name is: "+mObj.get("Test Case Name"));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: "+response.extract().asString());
		
		String stsCode = (String)mObj.get("Status Code");
		int statusCode = Integer.parseInt(stsCode);
		response.statusCode(statusCode);
		
		Reporter.log("Verified the Status code sucessfully", true);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verified the Status code sucessfully");
		response.contentType(ContentType.JSON);
		
		response.body("sys.country", Matchers.notNullValue());
		response.body("sys.country", Matchers.equalToIgnoringCase((String)mObj.get("Country Code")));
		Reporter.log("Country code is verified successfully", true);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Country code is verified successfully");
		
		response.body("name", Matchers.notNullValue());
		response.body("name", Matchers.equalToIgnoringCase((String)mObj.get("City Name")));
		Reporter.log("City name is verified successfully", true);
		ExtentTestManager.getTest().log(LogStatus.INFO, "City name is verified successfully");
		
	}
	
	@DataProvider(name = "NegativeTestScenarios")
	public Object[][] fetchNegativeTestData() throws Exception
	{
		ExcelRederPOI excel = new ExcelRederPOI();
		return excel.readFilenSheet(currentDir, "NegativeTestCaseData");
	}
	
	@SuppressWarnings("rawtypes")
	@Test(dataProvider = "NegativeTestScenarios")
	public void verifyWeatherInforWithNegativeData(Map mObj){

		String cityName = mObj.get("City Name")+","+mObj.get("Country Code");
		
		ValidatableResponse response = RestAssured.given().param("q",cityName)
				.param("appid", mObj.get("App ID")).when()
				.get().then();
		
		Reporter.log("Test Case Name is: "+mObj.get("Test Case Name"), true);
		Reporter.log("Response is: "+response.extract().asString(), true);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Case Name is: "+mObj.get("Test Case Name"));
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: "+response.extract().asString());
		
		String stsCode = (String)mObj.get("Status Code");
		int statusCode = Integer.parseInt(stsCode);
		response.statusCode(statusCode);
		
		Reporter.log("Verified the Status code sucessfully", true);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verified the Status code sucessfully");
		
		response.body("message", Matchers.notNullValue());
		response.body("message", Matchers.containsString((String)mObj.get("Error Message")));
		Reporter.log("Verified the error message successfully", true);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verified the error message sucessfully");

		
	}
	
	
}
