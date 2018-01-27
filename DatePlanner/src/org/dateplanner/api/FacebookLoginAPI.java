package org.dateplanner.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.dateplanner.login.Login;
import org.dateplanner.vo.User;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class FacebookLoginAPI implements Login {
	
	public void facebook(String code) throws Exception{
		String access_token = "EAAc4NdS6is8BADkJ9FZCz9cTW71id2DYZBScIiD3w9oAIHwgQTZB6i5p6jwPqvD2QhIIqZAFYGq9OtNhqVPy7R3MTbGiwN1HHQ2kc0ZBH79BqiJ2qMDM03TB0KMWnStOdWpzxLQFJyLpmParXOdezZBRUV3PJY7g6DMQMtFOfz4gZDZD";
		access_token = URLEncoder.encode(access_token,"UTF-8");
		String user_id = "575166562829068";
		//토큰가져오기
		URL url = new URL("https://graph.facebook.com/v2.11/oauth/access_token?client_id=2032128690391759&redirect_uri=http://localhost/NaverBookSearchAPI/facebook.do&client_secret=74be2c0fbdd71bddd240b3597ffaedea&code="+code);
		//
		URL url2 = new URL("https://graph.facebook.com/debug_token?input_token="+access_token+"&access_token="+access_token);
		//토큰으로 정보가져오기
		URL url3 = new URL("https://graph.facebook.com/v2.11/me?fields=id,name,picture,gender,age_range&access_token=EAAc4NdS6is8BADkJ9FZCz9cTW71id2DYZBScIiD3w9oAIHwgQTZB6i5p6jwPqvD2QhIIqZAFYGq9OtNhqVPy7R3MTbGiwN1HHQ2kc0ZBH79BqiJ2qMDM03TB0KMWnStOdWpzxLQFJyLpmParXOdezZBRUV3PJY7g6DMQMtFOfz4gZDZD");
		
		HttpURLConnection urlConn = (HttpURLConnection)url.openConnection(); urlConn.disconnect();
		HttpURLConnection urlConn2 = (HttpURLConnection)url2.openConnection(); urlConn2.disconnect();
		HttpURLConnection urlConn3 = (HttpURLConnection)url3.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn3.getInputStream(),"UTF-8"));
		JSONObject items = (JSONObject) JSONValue.parseWithException(br);
		System.out.println(items);
		
	} //login();
	
} //class FacebookLoginAPI;
