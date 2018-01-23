package org.dateplanner.controller;

import org.dateplanner.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("test.do")
	public ModelAndView dummy() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", testService.getData());
		mav.setViewName("test");
		
		return mav;
		
	} //dummy();
	
} //class TestController;
