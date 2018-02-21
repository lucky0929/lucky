package org.dateplanner.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

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

		//TODO State Token
		session.setAttribute("stateToken", "temp");

		return "redirect:https://kauth.kakao.com/oauth/authorize"
				+ "?client_id=62b0ece7e740a62645b08a9daa0da6f8"
				+ "&redirect_uri=" + URLEncoder.encode("http://localhost/user/kakao/callback", "UTF-8")
				+ "&response_type=code"
				+ "&state=temp";

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
