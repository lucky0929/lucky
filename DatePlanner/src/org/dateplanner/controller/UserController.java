package org.dateplanner.controller;

import org.dateplanner.service.BoardService;
import org.dateplanner.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	private UsersService user;
	
	@RequestMapping
	public String test(Model model) {
		model.addAttribute("test", user.selectAll());
		return "test";
	} //test

} //UserController
