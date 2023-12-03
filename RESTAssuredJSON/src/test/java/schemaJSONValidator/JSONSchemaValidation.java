package schemaJSONValidator;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
/* 
 *   Response validations -- data
 *   Schema validation - type od data
 *   Json Response(.json)--->Json schema (.json)
 *   https://jsonformatter.org/json-to-jsonschema
 *   https://jsonformatter.org/
 */
public class JSONSchemaValidation {

	@Test
	void jsonschemavalidation() 
	{
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschemafile.json"));
				
	}
}
