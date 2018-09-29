package com.qa.rest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.rest.reports.BaseClass;
import com.qa.rest.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class POSTRequest1 extends BaseClass{
	
	static String currentDir = System.getProperty("user.dir")+File.separator+"src\\main\\java\\com\\qa\\rest\\testdata\\users.txt";
	
	@Test
	public static void postRequestType1() throws IOException {
	String line;
	BufferedReader reader = new BufferedReader(new FileReader(currentDir));
	String json = "";
	try{
		StringBuilder sb =  new StringBuilder();
		line = reader.readLine();
		while(line != null)
		{
			sb.append(line);
			sb.append("\n");
			line = reader.readLine();
		}
		json = sb.toString();
	}finally{
		reader.close();
	}
	String url = "https://reqres.in/api/users";
	RestAssured.baseURI = url;
	
	ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +url);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Payload is: " +json);
	
	ValidatableResponse response = RestAssured.given().when().
			header("Content-Type", "application/json").
			body(json).post().then();

	ExtentTestManager.getTest().log(LogStatus.INFO, "Response is: " +response.extract().asString());
	response.statusCode(201);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the Status Code Successfully !!");
	response.contentType(ContentType.JSON);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the ContentType Successfully !!");
	//response.body("FaultId", Matchers.containsString("User already exists"));
	//ExtentTestManager.getTest().log(LogStatus.INFO, "Have verified the already exist user message");
	}
}
