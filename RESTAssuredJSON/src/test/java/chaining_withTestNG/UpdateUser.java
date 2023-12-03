package chaining_withTestNG;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	void test_updateUser(ITestContext context) {
		System.out.println("=====================I am in Update User ========================");

		Faker faker = new Faker();
		JSONObject data = new JSONObject();

		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");

		String bearerToken = "df6de22ec215bd18440407b0999e54a9c2441a89938870c34bd49f489942c32b";

		//int id = (Integer) context.getAttribute("user_id"); //This should come from create user  //Only available on Test level in testNG.xml
		
		int id = (Integer) context.getSuite().getAttribute("user_id");//Available on Suite level in testNG.xml
		
		given()
			.header("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
		
		

	}

}
