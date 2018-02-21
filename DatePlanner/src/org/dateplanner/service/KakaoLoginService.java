package org.dateplanner.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

import org.dateplanner.vo.ApiToken;
import org.dateplanner.vo.User;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KakaoLoginService {
	
	public ApiToken getUserToken(String apiCode) {
		
		ApiToken result = null;
		
		try {
			
			JsonNode token = new ObjectMapper().readTree(new URL("https://kauth.kakao.com/oauth/token"
					+ "?grant_type=" + "authorization_code"
					+ "&client_id=" + "62b0ece7e740a62645b08a9daa0da6f8"
					+ "&code=" + apiCode
					+ "&redirect_uri=" + URLEncoder.encode("http://localhost/user/kakao/callback", "UTF-8")));
			
			result = new ApiToken();
			result.setAccessToken(token.get("access_token").asText());
			result.setRefreshToken(token.get("refresh_token").asText());
			
		}catch (IOException e) { e.printStackTrace(); }
		
		return result;
		
	} //getUserToken();
	
	public User getUserInfo(ApiToken token) throws IOException {
		
		User result = new User();
		
		URL url = new URL("https://kapi.kakao.com/v1/user/me");
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("Authorization", "Bearer " + token.getAccessToken());
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		JsonNode userInfo = new ObjectMapper().readTree(conn.getInputStream());
		
		System.out.println(userInfo);
		
		return result;
	}
	
} //class KakaoLoginService;
