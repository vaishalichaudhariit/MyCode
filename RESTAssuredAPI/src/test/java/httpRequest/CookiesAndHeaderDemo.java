package httpRequest;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesAndHeaderDemo {

	//@Test(priority=1)
	void testCookies() {
		// TODO Auto-generated method stub
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","AUEFqZe4Eez4077ax_3R8rhtsmX4inJjIfT1kD4ONK9QjNAQ57TOQLX0lA")
		.statusCode(200)
		.log().all();
	}

	//@Test(priority=2)
	void getCookiesInfo() {

		Response res = given()
				.when()
				.get("https://www.google.com/");

		//get single cookies info
		String cookies_value = res.getCookie("AEC");

		System.out.println(cookies_value);
	}

	//@Test(priority=3)
	void getAllCookiesInfo() {

		Response res = given()
				.when()
				.get("https://www.google.com/");

		//get single cookies info
		Map<String, String> cookies = res.getCookies();

		System.out.println(cookies.keySet());

		for (String c:cookies.keySet()) {
			String cookies_value =res.getCookie(c);
			System.out.println(c + "             " + cookies_value);
		}

	}

	//@Test(priority=4)
	void testHeader() {
		// TODO Auto-generated method stub
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("content-type", "text/html; charset=ISO-8859-1")
		.and()
		.header("content-encoding","gzip")
		.header("server", "gws")
		.statusCode(200)
		.log().all();
	}

	@Test(priority=5)
	void getHeaders() {

		Response res = given()
				.when()
				.get("https://www.google.com/");

		//get Single header
		System.out.println(res.getHeader("server"));

		//get all headers info

		Headers myheaders = res.getHeaders();

		for (Header hd : myheaders)
		{
			System.out.println(hd.getName() + "  " + hd.getValue());
		}
	}
	//@Test(priority=6)
	void testLogCookiesHeaders() {
	
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.log().body()
		.log().cookies()
		.log().headers()
		.statusCode(200);
		//.log().all();
	}
	
}
