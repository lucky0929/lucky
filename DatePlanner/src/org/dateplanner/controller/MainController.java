package org.dateplanner.controller;

import org.dateplanner.service.BoardService;
import org.dateplanner.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping(path= { "/", "main", "index" })
	public String main() {
		
		
		
		
		return "main";
		
	} //main();
	
} //class MainController;
