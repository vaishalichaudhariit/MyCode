package httpRequest;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponseData {

	@Test(priority = 1)
	void testJsoResponse() {
		/*
		 * //Approach 1 - Validation in then part with json path
		 * 
		 * given() .contentType("ContentType.JSON") .when()
		 * .get("https://reqres.in/api/users?page=2") .then() .statusCode(200)
		 * .header("Content-Type","application/json; charset=utf-8")
		 * .body("data[5].last_name", equalTo("Howell"));
		 * 
		 * //Approach 2 - testNG Assert
		 * 
		 * Response res = given() .contentType("ContentType.JSON") .when()
		 * .get("https://reqres.in/api/users?page=2");
		 * 
		 * Assert.assertEquals(res.getStatusCode(), 200);
		 * Assert.assertEquals(res.header("Content-Type")
		 * ,"application/json; charset=utf-8");
		 * 
		 * String firstName = res.jsonPath().get("data[5].first_name").toString();
		 * Assert.assertEquals(firstName, "Rachel");
		 */

		// Approach 3 - JSONObject
		Response res = given().contentType("ContentType.JSON").when().get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		boolean status =  false;
		JSONObject jo = new JSONObject(res.asString());
		System.out.println(jo.getJSONArray("data").length());
		for (int i=0;i<jo.getJSONArray("data").length(); i++) {
			String dataArray = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			if(dataArray.equals("michael.lawson@reqres.in")) {
				status = true;
				break;
			}
		}

		Assert.assertEquals(status, true);

		for (int i=0;i<jo.getJSONArray("data").length(); i++) {
			String dataFirstName = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(dataFirstName);

		}

	}

}
