package chaining_withTestNG;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test
	void test_DeleteUser(ITestContext context) {
		System.out.println("=====================I am in Delete User ========================");

		//int id = (Integer) context.getAttribute("user_id"); //This should come from create user  //Only available on Test level in testNG.xml
		
		int id = (Integer) context.getSuite().getAttribute("user_id");//Available on Suite level in testNG.xml
		
			String bearerToken = "df6de22ec215bd18440407b0999e54a9c2441a89938870c34bd49f489942c32b";

			given()
				.header("Authorization","Bearer "+bearerToken)
				.pathParam("id", id)
			.when()
				.delete("https://gorest.co.in/public/v2/users/{id}")
			.then()
				.statusCode(204)
				.log().all();

		
	}

}
