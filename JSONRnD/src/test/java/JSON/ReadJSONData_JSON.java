package JSON;

import java.io.StringReader;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ReadJSONData_JSON {
	
	public static void main(String[] args) {
    	 String responseString = TestUtil.getJSONinString();
		 JsonReader reader = Json.createReader(new StringReader(responseString));
	     JsonObject jsonObject = reader.readObject();
		// System.out.println(jsonObject.getString("InternalJobTitle"));
		 Map<String, Object> reMap = JSONUtil.jsonToMap(jsonObject);
		 System.out.println(reMap.containsKey("InternalJobTitle"));
		
		
	

	}

}
