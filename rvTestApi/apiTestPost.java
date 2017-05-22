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


public class apiTestPost {

	@Test(description="HTTP Post API operation Test")
	public  void appTest() throws InterruptedException,
	ClientProtocolException, IOException, JSONException{
		 //Using HttpClient Testing RestApI
		
		//below code can be changed for negative testing
		int StatusOk=200;
		String expectedMimeType="application/json";
		
		
		String restUrl = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000/posts";
        System.out.println("Hello from Post API test ");

        //Post Method verification
                        
        //Step 3: Verify content post data should get added and new Id should be received
         
         Book b=new Book();
         b.setuserId("143");
         b.setTitle("PostApiIntvProject3");
         b.setBody("Intv Post API home project23");
         HttpPost request = new HttpPost(restUrl);
         
         Gson gson=new Gson();
         String postjson=gson.toJson(b);
         StringEntity entity = new StringEntity(postjson);
         entity.setContentType("application/json;charset=UTF-8");
         entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
         request.setEntity(entity);
         HttpResponse response = null;
         HttpClient httpclient = HttpClientBuilder.create().build();
         response = httpclient.execute(request);
         System.out.println(response);
         int poststatus=response.getStatusLine().getStatusCode();
         System.out.println("Post Response code is: "+poststatus);
         Assert.assertEquals(poststatus, HttpStatus.SC_CREATED, "Post Status code not valid");
     	 
  
    	}

 //To-DO's   
	//Get the record which was posted either through GET request or from Database to compare the data posted correctly
	//Duplicate values can be sent and result can be verified
	//Empty object can be posted and result can be verified
	//Send incorrect json and verify the response from the server- this can be done by altering the bean object and creating diff definition
	
}
