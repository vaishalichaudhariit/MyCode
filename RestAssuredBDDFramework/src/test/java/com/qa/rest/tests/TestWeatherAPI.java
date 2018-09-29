package com.qa.rest.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import org.hamcrest.Matchers;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestWeatherAPI {

	@Test(priority = -1)
	public void getWeatherInfoofLondonWithValidData() {
		//https://openweathermap.org/current
		RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/weather";

		// using String response

		String response = RestAssured.given().param("q", "London,uk")
				.param("appid", "e8e3ff8652bcaf4f0638fad2d663d8a4").when()
				.get().then().extract().asString();
		System.out.println("Response is : " + response);

		Reporter.log("Response is: " + response, true);

		JsonPath path = new JsonPath(response);
		Object country = path.get("sys.country");
		System.out.println("Country Name: " + country);

		// using ValidatableResponse
		ValidatableResponse res = RestAssured.given().param("q", "London,uk")
				.param("appid", "e8e3ff8652bcaf4f0638fad2d663d8a4").when()
				.get().then();

		res.statusCode(200);
		Reporter.log("Verified the Status Code successfully: " + response, true);
		res.contentType(ContentType.JSON);
		Object countryName = res.extract().response().path("sys.country");
		System.out.println("Country Name is " + countryName);

		// assert using hamcrest API
		res.body("sys.country", Matchers.notNullValue());
		res.body("sys.country", Matchers.equalToIgnoringCase("GB"));
		Reporter.log("Country code has verified successfully", true);

		res.body("name", Matchers.notNullValue());
		res.body("name", Matchers.equalToIgnoringCase("London"));
		Reporter.log("City name has verified successfully", true);

	}

	@Test
	public void getWeatherInfoofCityWithInValidData() {

		// using ValidatableResponse
		ValidatableResponse res = RestAssured.given().param("q", "London,uk")
				.param("appid", "e8e3ff8652bcaf4f0638fad2d663d8a4A").when()
				.get().then();
		Reporter.log("Response is: " + res.extract(), true);
		res.statusCode(401);
		res.body("message", Matchers.notNullValue());
		res.body("message", Matchers.containsString("Invalid API key"));
		Reporter.log("Verified the error message successfully", true);
	}
	
	@Test
	public void getWeatherInfoofTokenWithInValidData() {

		// using ValidatableResponse
		ValidatableResponse res = RestAssured.given().param("q", "LondonA,uk")
				.param("appid", "e8e3ff8652bcaf4f0638fad2d663d8a4").when()
				.get().then();
		Reporter.log("Response is: " + res.extract(), true);
		res.statusCode(404);
		res.body("message", Matchers.notNullValue());
		res.body("message", Matchers.containsString("city not found"));
		Reporter.log("Verified the error message successfully", true);
	}
	
	@Test
	public void getWeatherInfoofDelhiWithValidData() {
		
		//Authorization - Basic Auth
		//RestAssured.given().auth().preemptive().basic("userName", "password").param("grant_type", "password");
		
		//Headers:
		Header first = new Header("Authorization","access Token key");
		Header second = new Header("X-Remote-User","userName");
		Header third = new Header("Content-Type","application/json");
		Headers headers = new Headers(first,second,third);
		
		RestAssured.given().headers(headers);
		
		// using ValidatableResponse
		ValidatableResponse res = RestAssured.given().param("q", "Delhi,IN")
				.param("appid", "e8e3ff8652bcaf4f0638fad2d663d8a4").when()
				.get().then();
		Reporter.log("Response is:"+res.extract().asString(), true);

		res.statusCode(200);
		Reporter.log("Verified the Status code successfully", true);
		
		res.contentType(ContentType.JSON);
			// assert using hamcrest API
		res.body("sys.country", Matchers.notNullValue());
		res.body("sys.country", Matchers.equalToIgnoringCase("IN"));
		Reporter.log("Country code has verified successfully", true);

		res.body("name", Matchers.notNullValue());
		res.body("name", Matchers.equalToIgnoringCase("Delhi"));
		Reporter.log("City name has verified successfully", true);

	}

}
