package org.dateplanner.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.UsersService;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequestMapping("user")
public class UserController {
	
	@Autowired
	private UsersService userService;
	
	@RequestMapping("insertForm")
	public String insertForm() { return "insertForm"; }
	
	@RequestMapping("join")
	public String doJoin(@RequestParam HashMap<String, String> intro, Model model, HttpSession session) {
		model.addAttribute("test", intro);
		Users user = new Users();
		

//		if(userService.join(info)) session.setAttribute("message", "성공?");
		if(userService.join(info)) 
			model.addAttribute("message", "<script>alert(\"성공?\");<script>");
		return "redirect:test";
	} //join();
	
} //class LoginController;