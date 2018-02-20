package org.dateplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(path= { "/", "main", "index" })
	public String main() { return "main"; }
	
} //class MainController;
