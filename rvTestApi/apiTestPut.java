package rvTestApi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;





import org.apache.http.client.ClientProtocolException;
import org.json.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;

import java.lang.reflect.Type;





import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.*;
import org.apache.http.impl.client.*;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.annotation.*;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.net.CookieHandler;
//import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.commons.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;


public class apiTestPut {

	@Test(description="HTTP PUT operation API Test")
	public  void appTest() throws InterruptedException,
	ClientProtocolException, IOException, JSONException{
		 //Using HttpClient Testing RestApI
		
		String expectedMimeType="application/json";
		
		
		String restUrl = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000/posts";
        System.out.println("Hello from Put API test ");

        //Put Method verification
        
        // Verify content Put data should get updated
         
         Book b=new Book();
         b.setuserId("142");
         b.setTitle("PostApiIntvProjectUpdated");
         b.setBody("Intv Post API home projectUpdated");
         b.setId("105");
         
         HttpPut request = new HttpPut(restUrl);
        // request.getEntity().getContent().read();
        
         Gson gson=new Gson();
         String postjson=gson.toJson(b);
         StringEntity entity = new StringEntity(postjson);
         entity.setContentType("application/json;charset=UTF-8");
         entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
         request.setEntity(entity);
         HttpResponse response = null;
         
         HttpClient httpclient = HttpClientBuilder.create().build();
         try {
               	 response = httpclient.execute(request);
               	 System.out.println(response);
               	 
       
        	 } catch (SocketException se) {
               	 throw se;
        	 }
 
         int poststatus=response.getStatusLine().getStatusCode();
         int notFound=404;
         System.out.println("PUT Response code is: "+poststatus);
         Assert.assertEquals(poststatus, HttpStatus.SC_CREATED, "PUT operation didn't update data");
         //Assert.assertEquals(poststatus, notFound, "PUT operation failed due to 404 Not found, API does not support this operation");
    	}

	//TO-DO
	// Test to verify information got updated :get the JSON response and compare above id record to see if data is updated correctly
	
		
		
}
