package JACKSON_FASTERXML;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadSingleRecord {

	public static void main(String[] args) {
		//**************************************************************
		 ObjectMapper mapper = new ObjectMapper();
	        /**
	         * Read JSON from a file into a Map
	         */
	        try {
	            Map<String, Object> reqMap = mapper.readValue(new File(
	                    "D:\\SeleniumWorkspace\\POMAutoFramework\\src\\main\\java\\com\\pom\\qa\\testdata\\NewReq.json"), new TypeReference<Map<String, Object>>() {
	            });
	 
	            System.out.println("InternalJobTitle : " + reqMap.get("InternalJobTitle"));
	            System.out.println("PostedJobTitle : " + reqMap.get("PostedJobTitle"));
	            System.out.println("Department : " + reqMap.get("Department"));
	            System.out.println("JobCode : " + reqMap.get("JobCode"));
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
