package programs;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import io.restassured.response.Response;




public class StaticImportClass {

	public static void main(String[] args) {

		Response getResponse = given()
		.param("page", "2")
		.auth().none()
		.when().get("https://reqres.in/api/users");
		/*.then()
		.statusCode(200).body("page", equalTo(2));*/
		
		System.out.println("Get Response - >" + getResponse);
		System.out.println("Get ContentType - >" + getResponse.getContentType());
		System.out.println("Get Cookies - >" + getResponse.getCookies());
		System.out.println("Get Headers - >" + getResponse.getHeaders());
		System.out.println("Get Bodies - >" + getResponse.getBody());
		System.out.println("===================================");
		System.out.println("Get Time - >" + getResponse.getTime());
		System.out.println("Get Time in ms - >" + getResponse.getTimeIn(TimeUnit.MILLISECONDS));
		System.out.println("Time - >" + getResponse.time());
		System.out.println("Time in ms - >" + getResponse.timeIn(TimeUnit.MILLISECONDS));
	}

}
