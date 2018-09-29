package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	
	CloseableHttpClient httpClient = HttpClients.createDefault(); // createDefault() method - Create one default client connection
	// 1. GET Method without Headers:
	public CloseableHttpResponse get(String url)throws ClientProtocolException, IOException {

		
		HttpGet httpGet = new HttpGet(url); // create get request - HttpGet class
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);// hit the GET URL

		return closeableHttpResponse;
	}

	// 2. GET Method with Headers:
	public CloseableHttpResponse get(String url,HashMap<String, String> headerMap) throws ClientProtocolException,IOException {

		//CloseableHttpClient httpClient = HttpClients.createDefault(); // createDefault() method - Create one default client connection
		HttpGet httpGet = new HttpGet(url); // create get request - HttpGet  class

		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpGet.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);// hit the GET URL
	
		return closeableHttpResponse;
	}
	
	//3. POST method:
	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
		//CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url); //http post request
		httpPost.setEntity(new StringEntity(entityString)); //for payload (entityString)
		
		//for headers:
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
		return closeableHttpResponse;
	}
	
	//4. DELETE method:
	public CloseableHttpResponse delete(String url)throws ClientProtocolException, IOException {
		
		HttpDelete httpDelete = new HttpDelete(url);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpDelete);
		return closeableHttpResponse;
				
	}
	
}
