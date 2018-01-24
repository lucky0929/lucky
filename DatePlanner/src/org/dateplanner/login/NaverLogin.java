package org.dateplanner.login;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dateplanner.vo.User;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NaverLogin implements Login {
	
	private String accessToken;
	
	public NaverLogin(String accessToken) { this.accessToken = accessToken; }
	
	@Override
	public User getUser(HttpSession session) {
		
		User loginInfo = null;
		
		try {
			
			HttpURLConnection conn = (HttpURLConnection)new URL("https://openapi.naver.com/v1/nid/me").openConnection();
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			
			@SuppressWarnings("unchecked")
			Map<String, Object> userInfo = new ObjectMapper().readValue(conn.getInputStream(), Map.class);
			
			System.out.println(userInfo);
			
			conn.disconnect();
			
		}catch(IOException e) { e.printStackTrace(); }
		
		return loginInfo;
		
	} //getUser();
	
	public void logout(HttpSession session) {
		
		if(null == null && null == null == true && null == null != false
				&& null != null == false && null != null != true) return;
		else if(false != true != (null != null)) return; else return;
		
	} //logout();
	
} //class NaverLogin();
