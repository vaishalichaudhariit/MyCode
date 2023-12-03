package com.cgg.qa.util;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {

	public static void main(String[] args) throws Exception {
	    final int jsonLength = 500_000;
	    
	    String JSON_path = "C:\\Users\\Dell\\Desktop\\GeoStore\\GeoStore.json";
	    JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(JSON_path));
		JSONObject json = (JSONObject) obj;
		
	    long start = System.currentTimeMillis();
	    List<Object> list = parseJson(json);
	    long end = System.currentTimeMillis();
	    System.out.format("List - Run in %d ms for %d items and output %d lines%n", end-start, jsonLength, list.size());

	    start = System.currentTimeMillis();
	    Set<Object> set = parseJsonSet(json);
	    end = System.currentTimeMillis();
	    System.out.format("Set - Run in %d ms for %d items and output %d lines%n", end-start, jsonLength, set.size());
	}

	public static List<Object> parseJson(JSONObject json) {
	    String col = "columnC";

	    JSONArray array = json.getJSONArray("order");

	    List<Object> list = new ArrayList<>();
	    for (int i = 0; i < array.length(); i++) {
	        JSONObject obj = array.getJSONObject(i);
	        JSONObject att = obj.getJSONObject("Attributes");
	        if (att.has(col)) { // getting col from params in the servlet
	            JSONObject column = att.getJSONObject(col);
	            Object colval = column.get("content");

	            if (!(list.contains(colval))) {
	                //System.out.println(colval);
	                list.add(colval);
	            }
	        }
	    }

	    return list;
	}

	public static Set<Object> parseJsonSet(JSONObject json) {
	    String col = "columnC";

	    JSONArray array = json.getJSONArray("order");

	    Set<Object> set = new HashSet<>();
	    for (int i = 0; i < array.length(); i++) {
	        JSONObject obj = array.getJSONObject(i);
	        JSONObject att = obj.getJSONObject("Attributes");
	        if (att.has(col)) { // getting col from params in the servlet
	            JSONObject column = att.getJSONObject(col);
	            Object colval = column.get("content");

	            if (set.add(colval)) {
	                //System.out.println(colval);
	            }
	        }
	    }

	    return set;
	}
}
