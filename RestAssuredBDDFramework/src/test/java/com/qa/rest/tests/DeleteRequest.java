package com.qa.rest.tests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import org.testng.annotations.Test;

import com.qa.rest.reports.BaseClass;
import com.qa.rest.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class DeleteRequest extends BaseClass{

	
	@Test
	public static void putRequest()
	{
		
		String url="https://reqres.in/api/users/2";
		RestAssured.baseURI=url;
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +url);
		
		ValidatableResponse response = RestAssured.given().when().
				header("Content-Type", "application/json").delete().then();
		
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " +response.extract().asString());
		response.statusCode(204);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
		//response.contentType(ContentType.JSON);
		
		//Implement verification logic as per previous example
	}
}