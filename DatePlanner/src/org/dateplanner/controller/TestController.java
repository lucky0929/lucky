package org.dateplanner.controller;

import org.dateplanner.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller1 {

	@Autowired private  service service;

	@RequestMapping("test.do")
	public ModelAndView dummy() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", service.getData());
		mav.setViewName("test");
		return mav;
	}
	
}
