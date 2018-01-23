package org.dateplanner.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller @RequestMapping("login")
public class LoginController {
	
	@RequestMapping("naver.do")
	public String naver(HttpSession session) {
		
		String state = new BigInteger(130, new SecureRandom()).toString(32);
		
		session.setAttribute("stateToken", state);
		
		return "redirect:https://nid.naver.com/oauth2.0/authorize"
				+ "?client_id=OUmw0mnFGgvCrsoqa1xf"
				+ "&state=" + state
				+ "&redirect_uri=http%3A%2F%2Flocalhost%2Flogin%2Fnaver%2Fcallback.do"
				+ "&response_type=code";
		
	} //naver();
	
	@RequestMapping(path = "naver/callback.do", params = { "code", "state" }) @SuppressWarnings("unchecked")
	public String naverCallback(HttpSession session, String code, String state) {
		
		Object stateToken = session.getAttribute("stateToken");
		session.removeAttribute("stateToken");
		if(!state.equals(stateToken))
			return null; //위조방지 상태토큰이 다름
						 //값의 위조 가능성이 있음
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			
			Map<String, Object> token = mapper.readValue(
					new URL("https://nid.naver.com/oauth2.0/token"
							+ "?client_id=OUmw0mnFGgvCrsoqa1xf" + "&client_secret=I0mptNTjps"
							+ "&grant_type=authorization_code" + "&state=" + stateToken
							+ "&code=" + code), Map.class);
			
			if(token.get("error") != null)
				return null;
			
			HttpURLConnection conn = (HttpURLConnection)new URL("https://openapi.naver.com/v1/nid/me").openConnection();
			conn.setRequestProperty("Authorization", "Bearer " + token.get("access_token"));
			
			Map<String, Object> userInfo = mapper.readValue(conn.getInputStream(), Map.class);
			
			conn.disconnect();
			
			System.out.println(userInfo);
			
		}catch (IOException e) { e.printStackTrace(); }
		
		return null;
		
	} //naverCallback();
	
} //class LoginController;
