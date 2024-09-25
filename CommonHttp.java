package com.example.webServices;

import java.io.IOException;
import java.net.CookieStore;

import org.apache.catalina.connector.ClientAbortException;
import org.springframework.http.HttpEntity;

public class CommonHttp {
   static DefaultHttpClient Client =null;
	
	
	static public HttpReturnData getAPI(String url)throws ClientprotocolException, IOException{
		
		String responseString ="TEST";
		if(Client==null) {
			Client = new DefaultHttpClient();
			CookieStore cookieStore = new BasicCookieStore();
			Client.setCookieStore(cookieStore);
		}
		HttpGet get = new HttpGet(url);
		get.setHeader("Content-Type","application/json");
		HttpResponse response = Client .execute(get);
		HttpEntity entity = response.getEntity();
		responseString = EntityUtils.toSting(entity, "UTF-8");
		
		HttpReturnData resData = new HttpREturnData();
		resData.setReturnContent(responseString);
		StatusLine statusLine = response.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		resData.setStatusCode(statusCode);
		
		return resData;
		
	}
}
