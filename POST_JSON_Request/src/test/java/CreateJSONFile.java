import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CreateJSONFile {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("name", "Vaishali");
		obj.put("location", "USA");
		
		JSONArray list = new JSONArray();
		list.add("Java");
		list.add("TestNG");
		list.add("Oracle");
		
		obj.put("courses", list);
		
		try
		{
			FileWriter file = new FileWriter("myJSON.json");
			file.write(obj.toString());
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(obj);

	}

}
