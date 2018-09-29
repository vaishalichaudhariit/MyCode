package com.qa.rest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.rest.pojoClasses.Example;
import com.qa.rest.pojoClasses.UserDetail;
import com.qa.rest.pojoClasses.UserID;
import com.qa.rest.reports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class PUTRequest1 {

	@Test
	public static void putRequest() throws JsonProcessingException {

		String url = "http://Url for the Put Request";
		RestAssured.baseURI = url;

		UserDetail userDetail = new UserDetail("SachinG", "SGupta", "Bangalore");
		ArrayList list = new ArrayList();
		list.add(userDetail);
		UserID userID = new UserID("sachinbilsi2221@gmail.com");
		Example example = new Example("User Details updating", userID, list);

		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(example);
		System.out.println("Put Request Json Body :" + jsonBody);

		ValidatableResponse response = RestAssured.given().when()
				.header("Content-Type", "application/json").body(jsonBody)
				.put().then();

		ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " + url);

		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Response is: " + response.extract().asString());
		response.statusCode(201);
		ExtentTestManager.getTest().log(LogStatus.INFO,
				"Have verified the Status Code Successfully !!");
		response.contentType(ContentType.JSON);

		// Implement verification logic as per previous example
	}
}