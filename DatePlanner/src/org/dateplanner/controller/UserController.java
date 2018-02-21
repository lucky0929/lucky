package org.dateplanner.controller;

import org.dateplanner.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("user")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("login")
	public String login(Model model) {
		
		return "main";
	} //test

	@RequestMapping("join")
	public String join(Model model) {
		model.addAttribute("", usersService.selectAll());
		return "test";
	} //insert
	
	@RequestMapping("leave")
	public String leave(Model model) {
		model.addAttribute("test", usersService.selectAll());
		return "test";
	} //leave
	
} //class LoginController;
