package complexJSON;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAPIUsingPojo {

	public static void main(String[] args) {


		EmployeePojo ep = new EmployeePojo("Vaishali", "Manager", 
				new String[] {"Java", "Selenium"}, "LTI", "vc@gmail.com");
		
		Response postResponse = given()
				.auth().none()
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.when()
				.body(ep).log().all()
				.post("https://reqres.in/api/users");
		
		
				//System.out.println(postResponse);

	}

}
