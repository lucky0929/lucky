package org.dateplanner.controller;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.UsersService;
import org.dateplanner.util.FileUploadUtil;
import org.dateplanner.util.JsonUtil;
import org.dateplanner.util.RedirectWithAlert;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("user")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("join")
	public void join() {}
	
	@RequestMapping("join/upload")
	public ResponseEntity<String> writeUpload(MultipartHttpServletRequest request)
			throws IOException { return JsonUtil.getResponseEntity(Collections.singletonMap("result", FileUploadUtil.getFile(request, "/user/img")));}
	
	@RequestMapping(path = "doJoin", params = { "id", "password", "name", "nickname", "regionNo", "profile", "introduction" })
	public ModelAndView doJoin(@ModelAttribute User user, String password) {
		user.setKey(password);
		
		RedirectWithAlert redirect = new RedirectWithAlert("회원가입");
		
		boolean idExist;
		if((idExist = usersService.idExist(user.getId())) || !usersService.join(user))
			return redirect.setMessage(idExist ? "이미 존재하는 아이디 입니다" : "회원가입에 실패했습니다").setRedirect("join");
		
		return redirect.setMessage("회원가입에 성공했습니다").setRedirect("../");
		
	} //doJoin();
	
	@RequestMapping("login")
	public void login() {};
	
	@RequestMapping(path = "doLogin", params = { "id", "password" })
	public ModelAndView doLogin(HttpSession session, String id, String password) {
		User loginInfo = usersService.login(id, password);
		if(loginInfo == null)
			return new RedirectWithAlert("로그인", "아이디 혹은 비밀번호가 틀립니다", "login");
		
		session.setAttribute("loginInfo", loginInfo);
		
		return new ModelAndView("redirect:../");
		
	} //doLogin();
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		
		session.removeAttribute("loginInfo");
		
		return new RedirectWithAlert("로그아웃", "로그아웃 되었습니다", "../");
		
	} //logout();
	
} //class LoginController;
