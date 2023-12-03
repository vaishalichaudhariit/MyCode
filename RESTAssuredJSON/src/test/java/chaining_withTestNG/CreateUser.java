package chaining_withTestNG;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test
	void test_createUser(ITestContext context) {
		System.out.println("=====================I am in Create User ========================");
		
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "df6de22ec215bd18440407b0999e54a9c2441a89938870c34bd49f489942c32b";
		
		int id   = given()
				.header("Authorization","Bearer "+bearerToken)
				.contentType("application/json")
				.body(data.toString())
				.when()
				.post("https://gorest.co.in/public/v2/users")
				.jsonPath().getInt("id");
			
		System.out.println("Generated id is: " +id);
		
		//context.setAttribute("user_id", id); //Only available on Test level in testNG.xml
		context.getSuite().setAttribute("user_id", id); //Available on Suite level in testNG.xml
		
		
	}

}
