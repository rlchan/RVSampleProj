package rvTestApi;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;

import org.apache.http.client.methods.*;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.util.EntityUtils;


import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.*;

public class apiTestDriver {

	@Test(description="HTTP GET API Opeation Test")
	public  void appGetTest() throws InterruptedException,
	ClientProtocolException, IOException, JSONException{
		 //Using HttpClient Testing RestApI
		
		//below code can be changed for negative testing
		int StatusOk=200;
		String expectedMimeType="application/json";
		
		
		String restUrl = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000/posts";
        System.out.println("Hello from Test Interview Api");

        //Get Method verification
        
        //First Test: Verify Status Code
         testStatusCode(restUrl);
        
        //Step 2: Verify Content Type
         testContentType(restUrl, expectedMimeType);
        
    			 
        //Step 3: Verify content (number of objects return, right format)
         testContent(restUrl);    
          
         System.out.println("All get API tests are completed");
  
    	}

    
	public static HttpResponse getUrlResponse(String restUrl) throws IOException
	{
		HttpUriRequest request = new HttpGet(restUrl);
		HttpResponse hResponse=null;
		try {
			hResponse = HttpClientBuilder.create().build().execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hResponse;
	}
	
	public void testContent(String restUrl) throws IOException, JsonSyntaxException {
		
		HttpResponse resp=getUrlResponse(restUrl);
		
		   Book b= new Book();
		   
		long len=resp.getEntity().getContentLength(); 
		
		 System.out.println("Verifying if data is returned from the GET operation"+ len);
		 //Assert.assertTrue(len>0, "Content is returned and is not null");
        
		String jsonData=EntityUtils.toString(resp.getEntity()); 
		
		//System.out.println(jsonData);
		//variable to hold number of expected Json objects from Api posts
		int exepectedJsonResObjs=105;
		
		 Gson gson=new Gson();
		Book[] bookResults=gson.fromJson(jsonData,Book[].class);
		 int bsize=bookResults.length;
		 System.out.println("Number of records returns are: "+bsize);
		 Assert.assertEquals(bsize, exepectedJsonResObjs, "Number of objects returned from API doesn't match with Exepected Obj counts");
		 
	}

		public static void testContentType(String restUrl, String execptecdMimytype ) throws IOException {
    		
			HttpResponse resp=getUrlResponse(restUrl);
			
			String responseContentType=resp.getEntity().getContentType().getValue();
    		
    		
    		System.out.println("Response Content type is': "+responseContentType);
    		String[] retVal= responseContentType.split(";");
    		String actualVal=retVal[0];
    		System.out.println("Return Content Mime Type first part from Url is :"+actualVal);
    		Assert.assertEquals(actualVal, execptecdMimytype, "Content Type Test Failed");
	 
	}

		public static void testStatusCode(String restUrl) throws IOException {
			
			HttpResponse resp=getUrlResponse(restUrl);
			
			/*URL obj = new URL(restUrl);
    		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    		con.setRequestMethod("GET");
    		con.addRequestProperty("Authorization", "Basic key"); 
    		int responseCode = con.getResponseCode();
    		*/
    		
			int responseCode = resp.getStatusLine().getStatusCode() ;
    		
			 
    		System.out.println("\nSending 'GET' request to URL : " + restUrl);
    		System.out.println("Response Code : " + responseCode);
    		
			Assert.assertEquals(responseCode,HttpStatus.SC_OK, "Response Code test Failed");
			//System.out.println("Response Code test passed");
	}

		
		
		
}
