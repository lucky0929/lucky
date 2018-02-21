package org.dateplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("login/kakao")
public class KakaoLoginController {
	
	@RequestMapping("")
	public String redirectURL() {
		
		//TODO State Token
		//session.setAttribute("stateToken", "temp");
		
		return "redirect:";
		
	} //redirectURL();
	
	@RequestMapping("callback")
	public String callback() {
		
		
		
		return "redirect:..?";
		
	} //callback();
	
} //class KakaoLoginController;
