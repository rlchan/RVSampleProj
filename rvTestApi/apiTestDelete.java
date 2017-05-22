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

import org.apache.commons.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

import org.apache.http.annotation.NotThreadSafe;


@NotThreadSafe
class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "DELETE";
 
    public String getMethod() {
        return METHOD_NAME;
    }
 
    public HttpDeleteWithBody(final String uri) {
        super();
        setURI(URI.create(uri));
    }
 
    public HttpDeleteWithBody(final URI uri) {
        super();
        setURI(uri);
    }
 
    public HttpDeleteWithBody() {
        super();
    }
}
 


public class apiTestDelete {

	@Test(description="Delete HTTP operation API Test")
	public  void appTest() throws InterruptedException,
	ClientProtocolException, IOException, JSONException{
		 //Using HttpClient Testing RestApI
		
		String expectedMimeType="application/json";
		
		
		String restUrl = "http://ec2-54-174-213-136.compute-1.amazonaws.com:3000/posts";
        System.out.println("Hello from Delete API test ");

        //Put Method verification
        
        // Verify content data should get deleted for given Id
         
         Book b=new Book();
         b.setuserId("142");
         b.setTitle("PostApiIntvProject2");
         b.setBody("Intv Post API home project2");
         b.setId("105");
         
         HttpDeleteWithBody request = new HttpDeleteWithBody(restUrl);
        // request.getEntity().getContent().read();
        
         Gson gson=new Gson();
         String postjson=gson.toJson(b);
         StringEntity entity = new StringEntity(postjson);
         entity.setContentType("application/json;charset=UTF-8");
         entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
         
         
         request.setEntity(entity);
         

         try {
        	 
             	//CloseableHttpClient httpclient = HttpClients.createDefault();
              	//CloseableHttpResponse response = httpclient.execute(request);
   
         
        	 	 HttpClient httpclient = HttpClientBuilder.create().build();
       
               	 HttpResponse  response = httpclient.execute(request);
               	 System.out.println(response);
                 int poststatus=response.getStatusLine().getStatusCode();
                 System.out.println("Delete Response code is: "+poststatus);
                 Assert.assertEquals(poststatus, HttpStatus.SC_CREATED, "Delete Operation did't completed");
       
        	 } catch (SocketException se) {
               	 throw se;
        	 }


    	}

    //TO-DO
	// Get the deleted request Id record, it should give not found 204 code no content. 

		
		
}
