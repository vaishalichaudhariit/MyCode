package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;

public class GETAPITesting {

	private static final Object RESPONSE_STATUS_CODE_200 = 200;

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "https://reqres.in/api/users";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		System.out.println(httpResponse.getStatusLine().getStatusCode());
		
		// 1.Status Code
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				System.out.println("Status Code--->" + statusCode);

				Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200,
						"Status code is not 200");
	  //2. First Header
				System.out.println(httpResponse.getLastHeader("Content-Type"));
	}

	
}
