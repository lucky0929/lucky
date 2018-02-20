package org.dateplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("place")
public class PlaceController {
	
	@RequestMapping(path="doWrite", params= {"title", "img"})
	public String doWrite(String title, String img) {
		
		
		
		return null;
		
	} //doWrite();
	
} //class PlaceController;
