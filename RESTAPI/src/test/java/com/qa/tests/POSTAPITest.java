package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class POSTAPITest extends TestBase{
	
	TestBase testBase;
	RestClient restClient;
	String apiurl;
	String serviceUrl;
	String url;
	CloseableHttpResponse closeableHttpResponse;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase(); // to call TestBase constructor to use
								  // Properties
		apiurl = prop.getProperty("apiURL");
		serviceUrl = prop.getProperty("serviceURL");
		url = apiurl + serviceUrl;
		System.out.println(url);
	}
	
	@Test
	public void postAPITest() throws JsonGenerationException, JsonMappingException, IOException{
		
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");

		//jackson API: Marshaling
		ObjectMapper mapper = new ObjectMapper();
		Users users =  new Users("morpheus","leader"); //expected user object
		
		//object to json file conversion:
		mapper.writeValue(new File("D:/SeleniumWorkspace/RESTAPI/src/main/java/com/qa/data/users.json"), users);
		
		//object to json in String:
		String usersJsonString = mapper.writeValueAsString(users);
		System.out.println(usersJsonString);
		
		closeableHttpResponse = restClient.post(url, usersJsonString, headerMap);
		
		//1.status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_201);
		
		//2. JsonString:
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString); // convert into json string
		System.out.println("The repsonse from API is:" + responseJson);
		
		//json to java object (unmarshaling)
		Users userResObj = mapper.readValue(responseString, Users.class);//actual users object
		System.out.println(userResObj);
		
		Assert.assertTrue(users.getName().equals(userResObj.getName()));
		Assert.assertTrue(users.getJob().equals(userResObj.getJob()));
		
		System.out.println(userResObj.getId());
		System.out.println(userResObj.getCreatedAt());
	}

}
