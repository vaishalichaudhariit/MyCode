package com.qa.rest.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


// JSONObject, HashMap, File and create feeding data in body


public class Post_Delete_PutExample {
	
	public void postMethod(){
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "Selenium");
		json.put("author", "LearnSelenium");
		
		request.body(json.toJSONString());
		
		Response response =request.post("http://localhost:3000/posts");
		int code = response.getStatusCode();
		Assert.assertEquals(code, "200");
		
	}
	public void deleteMethod(){
		RequestSpecification request = RestAssured.given();
		Response response =request.delete("http://localhost:3000/posts/21");
		int code = response.getStatusCode();
		Assert.assertEquals(code, "200");
		
	}
	public void putMethod(){
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "Selenium");
		json.put("author", "Vaishali");
		
		request.body(json.toJSONString());
		
		Response response =request.put("http://localhost:3000/posts");
		int code = response.getStatusCode();
		System.out.println("Response Code:" + code);
		Assert.assertEquals(code, "201");
		
	}

}
