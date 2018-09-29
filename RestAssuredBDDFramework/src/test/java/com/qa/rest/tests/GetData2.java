package com.qa.rest.tests;

//Import all the method of RestAssured statically on class level
import static io.restassured.RestAssured.*;


import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData2 {
	@Test
	public void testResponsecode() {
		
		int code = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getStatusCode();
		System.out.println("Status code is " + code);
		Assert.assertEquals(code, 200);
	}
	
	
	@Test
	public void testBody() {
		
		String body = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
		System.out.println("Body is " + body);
		long time = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getTime();
		System.out.println("Response time is " + time);
	}
}
