package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * Authentication - Valid or not
 * 
 * Basic
 * Digest
 * Preemtive
 * Bearer token
 * OAuth 1.0, 2.0
 * API Key 
 * 
 * Authorization - access
 * 
 * 
 * 
 * 
 * 
 * Request header and Response header
 */
public class AuthenticationDemo {


	@Test(priority = 1)
	void testBasicAuthentication() {

		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}

	@Test(priority = 2)
	void testDigestAuthentication() {

		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}

	@Test(priority = 3)
	void testreemptiveAuthentication() {

		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}

	@Test(priority = 4)
	void testBearerTokenAuthentication() {

		String bearerToken = "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";
		given()
		.headers("Authorization", "Bearer" + bearerToken)
		.when()
		.get("https://api.github.com/users/repos")
		.then()
		.statusCode(200)
		.log().all();
	}

	@Test(priority = 5)
	void testOauth1Authentication() {

		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
		.when()
		.get("url")
		.then()
		.statusCode(200)
		.log().all();

	}

	@Test(priority = 6)
	void testOauth2Authentication() {

		given()
		.auth().oauth2("accessToken")
		.when()
		.get("url")
		.then()
		.statusCode(200)
		.log().all();

	}

	@Test(priority = 7)
	void testAPIKeyAuthentication() {
		//Method #1
		given()
		.queryParam("appid", "APIKey")
		.when()
		.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Pune&cnt=7&units=metric")
		.then()
		.statusCode(200)
		.log().all();

		//Method #2
		given()
		.queryParam("appid", "APIKey")
		.pathParam("myPath", "data/2.5/forecast/daily")
		.queryParam("q", "Pune")
		.queryParam("units", "metric")
		.queryParam("cnt", "7")
		.when()
		.get("https://api.openweathermap.org/{myPath}")
		.then()
		.statusCode(200)
		.log().all();

	}

}
