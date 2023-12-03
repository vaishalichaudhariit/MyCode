package schemaXMLValidation;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.matcher.RestAssuredMatchers;

/*
 *  XML Response (.xml) ----> xml schema(.xsd)
 *  https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/
 * http://restapi.adequateshop.com/api/Traveler 
 * https://www.freeformatter.com/xsd-generator.html#before-output  
 */

public class XMLValidation {
	@Test
	void schemaXMLValidation() 
	{
		given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=6")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlschema.xsd"));
				
	}
}
