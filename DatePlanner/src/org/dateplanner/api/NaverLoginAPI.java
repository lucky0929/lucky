package org.dateplanner.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.dateplanner.login.Login;
import org.dateplanner.vo.ApiLoginInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NaverLoginAPI implements Login {
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getToken(String code) {
		
		Map<String, String> result = null;
		try {
			HttpURLConnection conn = (HttpURLConnection)new URL(
					"https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=tOzxSVFgBuq1ArjsmwsD&client_secret=PJRT5Ku1Yp&code=" + code).openConnection();
			result = new ObjectMapper().readValue(conn.getInputStream(), Map.class);
			conn.disconnect();
		}catch (IOException e) { e.printStackTrace(); }
		return result;

	} //getToken();
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getProfile(String token) {
		
		Map<String, String> result = null;
		try {
			HttpURLConnection conn = (HttpURLConnection)new URL("https://openapi.naver.com/v1/nid/me").openConnection();
			conn.setRequestProperty("Authorization", "Bearer " + token);
			Map<String, Object> response;
			if((response = new ObjectMapper().readValue(conn.getInputStream(), Map.class)).get("message").equals("success"))
				result = (Map<String, String>)response.get("response");
			conn.disconnect();
		}
		catch (IOException e) { e.printStackTrace(); }
		return result;
	} //getProfile();
	
	@Override
	public ApiLoginInfo login(String code) {
		
		// private String name, nickname;
		// private Integer regionNo;
		// private String profile;
		// private Character sex;
		// private String introduction;
		
		Map<String, String> token = getToken(code);
		if (token.get("error") != null) return null;
		Map<String, String> profile = getProfile(token.get("access_token"));
		
		try { System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(profile)); }
		catch (JsonProcessingException e) { e.printStackTrace(); }
		
		ApiLoginInfo result = new ApiLoginInfo();
		
		result.setPlatform('N');
		result.setKey(profile.get("enc_id"));
		result.setName(profile.get("name"));
		result.setNickname(profile.get("nickname"));
		result.setProfile(profile.get("profile_image"));
		result.setSex(profile.get("gender").charAt(0));
		
		System.out.println(result);
		
		return result;
		
	} // login();
} // class NaverLoginAPI;
