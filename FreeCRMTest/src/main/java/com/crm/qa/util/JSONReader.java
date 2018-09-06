package com.crm.qa.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JSONReader {

	/**
	 * JSON_attributes => like Column in Excel, total column hence total
	 * attributes need to provide this is using json simple jar file
	 */

	public static Object[][] getJSONdata(String JSON_path, String JSON_data,
			int JSON_attributes) throws FileNotFoundException, IOException,
			ParseException {
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(JSON_path));
		JSONObject jo = (JSONObject) obj;
		JSONArray js = (JSONArray) jo.get(JSON_data);

		Object[][] arr = new String[js.size()][JSON_attributes];
		for (int i = 0; i < js.size(); i++) {
			JSONObject obj1 = (JSONObject) js.get(i);
			arr[i][0] = String.valueOf(obj1.get("title"));
			arr[i][1] = String.valueOf(obj1.get("firstName"));
			arr[i][2] = String.valueOf(obj1.get("lastName"));
			arr[i][3] = String.valueOf(obj1.get("company"));
		}
		return arr;
	}

	public static Object[][] getdata(String JSON_path, String typeData,
			int totalDataRow, int totalColumnEntry) throws JsonIOException,
			JsonSyntaxException, FileNotFoundException {
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObj = jsonParser.parse(new FileReader(JSON_path)).getAsJsonObject();
		JsonArray array = (JsonArray) jsonObj.get(typeData);
		Object[][] matrix = new Object[totalDataRow][totalColumnEntry];
		int i = 0;
		int j = 0;
		for (JsonElement jsonElement : array) {
			for (Map.Entry<String, JsonElement> entry : jsonElement
					.getAsJsonObject().entrySet()) {
				matrix[i][j] = entry.getValue().toString().replace("\"", "");
				j++;
			}
			i++;
			j = 0;
		}
		return matrix;
	}



	/*public static Object[][] searchJsonElemnet(JsonArray jsonArray,
			int totalDataRow, int totalColumnEntry) throws NullPointerException {

		Object[][] matrix = new Object[totalDataRow][totalColumnEntry];
		int i = 0;
		int j = 0;
		for (JsonElement jsonElement : jsonArray) {
			for (Map.Entry<String, JsonElement> entry : jsonElement
					.getAsJsonObject().entrySet()) {
				matrix[i][j] = entry.getValue().toString().replace("\"", "");
				j++;
			}
			i++;
			j = 0;
		}
		return matrix;
	}
*/

}
