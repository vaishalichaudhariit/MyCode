package httpRequest;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class DifferentWaysToCreatePostRequestBody {


//1) Post request body using HashMap
//2) Post request body creation using Org.JSON
//3) Post request body creation using POJO class
//4) Post request using external json file data
	
	
//1) Post request body using HashMap
	@Test(priority=1)
	public void testPostusingHashMap()
	{
		HashMap hm = new HashMap();
		hm.put("name", "Vaishali");
		hm.put("location","Pune");
		hm.put("phone","9087654321");
		
		String courseArr[] = {"C","C++"};
		hm.put("courses", courseArr);
		
		
		given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Vaishali"))
		.body("location",equalTo("Pune"))
		.body("phone",equalTo("9087654321"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	
	@Test(priority=2)
	public void testDelete()
	{
		given()
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(200)
		.log().all();
	}
	
//2) Post request body creation using Org.JSON
	
	@Test(priority=3)
	public void testPostusingJSONLibrary()
	{
		
		JSONObject js = new JSONObject();
		js.put("name", "Nilesh");
		js.put("location","Pune");
		js.put("phone","9087874321");
		String courseArr[] = {"C","C++"};
		js.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(js.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Nilesh"))
		.body("location",equalTo("Pune"))
		.body("phone",equalTo("9087874321"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	
	@Test(priority=4)
	public void testDelete1()
	{
		given()
		.when()
		.delete("http://localhost:3000/students/5")
		.then()
		.statusCode(200)
		.log().all();
	}

//3) Post request body creation using POJO class
	@Test(priority=5)
	public void testPostusingPOJO()
	{
		
		Pojo_PostRequest pojo = new Pojo_PostRequest();
		pojo.setName("Nilesh");
		pojo.setLocation("Pune");
		pojo.setPhone("9087874321");
		String courseArr[] = {"C","C++"};
		pojo.setCourses(courseArr);
		
		given()
		.contentType("application/json")
		.body(pojo)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("Nilesh"))
		.body("location",equalTo("Pune"))
		.body("phone",equalTo("9087874321"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	@Test(priority=6)
	public void testDelete2()
	{
		given()
		.when()
		.delete("http://localhost:3000/students/6")
		.then()
		.statusCode(200)
		.log().all();
	}
	
//4) Post request using external json file data
		
	@Test(priority=7)
		public void testPostusingExternalJsonFile() throws FileNotFoundException
		{
			
			File f = new File(".\\body.json");
			//Read the data from File - FileReader
			FileReader fr = new FileReader(f);
			
			//Json Tokener
			JSONTokener jt = new JSONTokener(fr);
			
			//Json Object
			JSONObject data = new JSONObject(jt);
			
			given()
			.contentType("application/json")
			.body(data.toString())
			.when()
			.post("http://localhost:3000/students")
			.then()
			.statusCode(201)
			.body("name", equalTo("Nilesh"))
			.body("location",equalTo("Pune"))
			.body("phone",equalTo("9087874321"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		}
}
