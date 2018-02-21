package org.dateplanner.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(path= { "/", "main", "index" })
	public String main(HttpServletRequest request) { return "main"; }
	
} //class MainController;
