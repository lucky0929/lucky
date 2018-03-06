package org.dateplanner.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.UsersService;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller @RequestMapping("user")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("join")
	public void join() {}
	
	@RequestMapping("join/upload")
	public ResponseEntity<String> writeUpload(MultipartHttpServletRequest request) throws IOException {
		
		MultipartFile file = request.getFile("file");
		String originalFileName = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileName.substring(originalFileName.lastIndexOf('.'));
		
		file.transferTo(new File(request.getServletContext().getRealPath("/user/img/") + fileName));
		
		System.out.println("[DEBUG] Upload Location: " + request.getServletContext().getRealPath("/user/img/"));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(Collections.singletonMap("fileName", fileName)), headers, HttpStatus.OK);
		
	} //writeUpload();
	
	@RequestMapping(path = "doJoin", params = { "id", "password", "name", "nickname", "regionNo", "profile", "introduction" })
	public String doJoin(@ModelAttribute User user, String password) {
		user.setKey(password);
		
		if(usersService.idExist(user.getId()) || !usersService.join(user))
			return "redirect:join";
		
		return "redirect:../";
		
	} //doJoin();
	
	@RequestMapping("login")
	public void login() {};
	
	@RequestMapping(path = "doLogin", params = { "id", "password" })
	public String doLogin(HttpSession session, String id, String password) {
		User loginInfo = usersService.login(id, password);
		if(loginInfo != null)
			session.setAttribute("loginInfo", loginInfo);
		
		return "redirect:../";
		
	} //doLogin();
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginInfo");
		
		return "redirect:../";
		
	} //logout();
	
	
} //class LoginController;
