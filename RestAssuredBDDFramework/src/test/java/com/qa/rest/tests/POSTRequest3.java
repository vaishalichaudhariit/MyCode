package com.qa.rest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.rest.pojoClasses.JsonBodyForPostRequest;
import com.qa.rest.reports.BaseClass;
import com.qa.rest.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;



public class POSTRequest3 extends BaseClass{
	
	@Test
	public static void postRequestType3() throws IOException {			
	
	String url="https://reqres.in/api/users";
	RestAssured.baseURI=url;
	
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmmss");
	Date date = new Date();
	String currentDate = formatter.format(date);
		
	JsonBodyForPostRequest jsonBodyObj=new JsonBodyForPostRequest(13,"Vaishali", 
			"Pathak", "vc.png", currentDate);
			
	ObjectMapper mapper=new ObjectMapper();
	String jsonBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonBodyObj);
	
	ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +url);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " +jsonBody);	
	ValidatableResponse response = RestAssured.given().when().
			header("Content-Type", "application/json").body(jsonBody).post().then();

	ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " +response.extract().asString());
	response.statusCode(201);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
	response.contentType(ContentType.JSON);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the ContentType Successfully !!");
	
	/*response.body("SuccessCode", Matchers.containsString("OPERATION_SUCCESS"));
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the SuccessCode message Successfully!!");
	
	response.body("Message", Matchers.containsString("Operation completed successfully"));
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the success request message Successfully!!");*/
	}
}
