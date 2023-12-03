package serialisationDeserialisation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Serialization - Object(Pojo) to JSON
 * Deserialization - JSON to Object(Pojo)
 * 
 * With Jackson API
 * 
 * Different way to create Post request body
 * 1. Pojo
 * 2. HashMap
 * 3. JSON
 * 4. GSON
 */

public class SerialisationDeserialisation {
	
	//Pojo ----> JSON - Serialization
	
	@Test(priority=1)
	public void convertPojoToJSON() throws JsonProcessingException
	{
		
		Pojo_PostRequest pojo = new Pojo_PostRequest();
		
		pojo.setName("Nilesh");
		pojo.setLocation("Pune");
		pojo.setPhone("9087874321");
		String courseArr[] = {"C","C++"};
		pojo.setCourses(courseArr);
		
		//convert java object ---> json object (serialization)
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println(jsonData);
	}
	
	// JSON----> Pojo - DeSerialization
	
		@Test(priority=2)
		public void convertJSONToPojo() throws JsonProcessingException
		{
			
			String jsonData = "{\r\n" + 
					"  \"name\" : \"Nilesh\",\r\n" + 
					"  \"location\" : \"Pune\",\r\n" + 
					"  \"phone\" : \"9087874321\",\r\n" + 
					"  \"courses\" : [ \"C\", \"C++\" ]\r\n" + 
					"}";


		//convert json data----> Pojo object
		ObjectMapper objMapper = new ObjectMapper();
		
		Pojo_PostRequest pojoStudent = objMapper.readValue(jsonData, Pojo_PostRequest.class);
		
		System.out.println(pojoStudent.getName() + "   " + pojoStudent.getLocation() + " " + pojoStudent.getPhone() + " " + pojoStudent.getCourses()[0] + " " + pojoStudent.getCourses()[1]);
		
		
		
		}	
}
