package httpRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathQueryParameters {

		//https://reqres.in/api/users?page=2
		
		@Test
	void testQueryAndPathParameters() {
		// TODO Auto-generated method stub
		given()
		.pathParam("myPath", "users") //path parameters mention with get in {}
		.queryParam("page", 2)  //query parameters
		.queryParam("id", 5)   //query parameters
	.when()
		.get("//https://reqres.in/api/{myPath}")
	.then()
    	.statusCode(200)
		.log().all();
	}

}