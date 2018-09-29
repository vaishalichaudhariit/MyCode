package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class DELETEAPITest extends TestBase {
	
	TestBase testBase;
	RestClient restClient;
	String endPointurl;
	String resourcedUrl;
	String url;
	CloseableHttpResponse closeableHttpResponse;

	@BeforeMethod
	public void setUp() {
		testBase = new TestBase(); // to call TestBase constructor to use
								  // Properties
		endPointurl = prop.getProperty("endPointURL");
		resourcedUrl = prop.getProperty("resourcedURL");
		url = endPointurl + resourcedUrl;
		System.out.println(url);
	}

	@Test
	public void DeleteAPITest() throws ClientProtocolException,
			IOException {
		restClient = new RestClient();
		closeableHttpResponse = restClient.delete(url);

		// 1.Status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->" + statusCode);

		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200,
				"Status code is not 200");

		String responseString = EntityUtils.toString(
				closeableHttpResponse.getEntity(), "UTF-8");// Default Character
															// set
		System.out.println("responseString--->" + responseString);
		// 2. JSON String - Create and get in JSON format
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("response JSON from API--->" + responseJson);

		// single value assertion:
		// per_page:
		String perPageValue = TestUtil.getValueByJPath(responseJson,
				"/per_page");
		int perPageExValue = 3;
		System.out.println("value of per page is--->" + perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), perPageExValue);

		// total:
		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println("value of total is--->" + totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		// get the value from JSON ARRAY:
		String firstName = TestUtil.getValueByJPath(responseJson,
				"/data[0]/first_name");
		String lastName = TestUtil.getValueByJPath(responseJson,
				"/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = TestUtil.getValueByJPath(responseJson,
				"/data[0]/avatar");
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(id);
		System.out.println(avatar);

		// 3. All headers
		// Get the No. of Headers in header array- server name, date etc.
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers Arrays--->" + allHeaders);
	}

}
