package com.qa.rest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.qa.rest.reports.BaseClass;
import com.qa.rest.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class POSTRequest2 extends BaseClass{
	
	@Test
	public static void postRequestType2() throws IOException {
			
	
	String url="https://reqres.in/api/users";
	RestAssured.baseURI=url;
	
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmmss");
	Date date = new Date();
	String currentDate = formatter.format(date);
		
	String jsonbody="{\"id\":\"12\",\"first_name\":\"Vaishu\",\"last_name\":\"P\","
			+ "\"avatar\":\"sachinGupta"+currentDate+"\","
			+ "\"createdAt\":\""+currentDate+"\"}";
	
	ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +url);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " +jsonbody);	
	
	ValidatableResponse response = RestAssured.given().when().
			header("Content-Type", "application/json").body(jsonbody).post().then();

	ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " +response.extract().asString());
	response.statusCode(201);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
	response.contentType(ContentType.JSON);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the ContentType Successfully !!");
/*	response.body("SuccessCode", Matchers.containsString("OPERATION_SUCCESS"));
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the SuccessCode message !!");
	
	response.body("Message", Matchers.containsString("Operation completed successfully"));
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the request success message !!");*/
	}
}
