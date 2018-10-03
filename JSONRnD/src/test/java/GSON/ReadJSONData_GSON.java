package GSON;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class ReadJSONData_GSON {
	
	@SuppressWarnings("unchecked")
	public static Map <String,Object>read() throws JsonIOException, IOException{
		Gson gson = new Gson(); 
		NewRequisition obj = new NewRequisition();
		//String json = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
		// 1. Java object to JSON, and save into a file
		gson.toJson(obj, new FileWriter("D:\\MyCode\\JSONRnD\\src\\test\\java\\GSON\\NewRequisition.json"));
		
		// 2. Java object to JSON, and assign to a String
		String jsonInString = gson.toJson(obj);
		System.out.println("jsonInString" + jsonInString);
		Map<String,Object> map = new HashMap<String,Object>();
		map = (Map<String,Object>) gson.fromJson(jsonInString, map.getClass());
		return map;
	}
	
	public static void main(String[] args) throws JsonIOException, IOException{
		Map <String,Object> map1 = read();
		System.out.println(map1);
	}
	
}
