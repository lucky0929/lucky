package org.dateplanner.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.KakaoLoginService;
import org.dateplanner.vo.ApiToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("user/kakao")
public class KakaoLoginController {
	
	@Autowired
	private KakaoLoginService kakaoLoginService;
	
	@RequestMapping("login")
	public String redirectURL(HttpSession session) throws IOException {
		
		String stateToken = new BigInteger(130, new SecureRandom()).toString(32);
		
		session.setAttribute("stateToken", stateToken);
		
		return "redirect:https://kauth.kakao.com/oauth/authorize"
				+ "?client_id=62b0ece7e740a62645b08a9daa0da6f8"
				+ "&response_type=code"
				+ "&redirect_uri=http%3A%2F%2Flocalhost%2Fuser%2Fkakao%2Fcallback\r\n"
				+ "&state=" + stateToken;
		
	} //redirectURL();

	@RequestMapping("callback")
	public String callback(HttpSession session, String code) throws Exception {
		
		session.setAttribute("apiCode", code);
		String apiCode = code;
		
		
		if(!"temp".equals(session.getAttribute("stateToken")))
			return "redirect:http://localhost/kakaoTest.jsp";
		
		ApiToken apiToken = kakaoLoginService.getUserToken(apiCode);
		session.setAttribute("apiToken", apiToken);
		kakaoLoginService.getUserInfo(apiToken);
		
		return "redirect:http://localhost";
		
	} //callback();

} //class KakaoLoginController;
