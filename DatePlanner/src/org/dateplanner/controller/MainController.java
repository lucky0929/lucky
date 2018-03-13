package org.dateplanner.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dateplanner.commons.Region;
import org.dateplanner.service.PostService;
import org.dateplanner.util.JsonUtil;
import org.dateplanner.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(path = { "/", "main", "index" })
	public ModelAndView main(HttpServletRequest request, HttpSession session, Integer r, @RequestParam(defaultValue = "1") int p) {
		
		ModelAndView model = new ModelAndView("main");

		if(r != null && 0 <= r && r < Region.LIST.size())
			session.setAttribute("regionNo", r);
		
		int regionNo = Region.getRegionNo(session);
		Page page = new Page(2, 5, p);
		
		model.addObject("postList", postService.selectByRegionWithPage(regionNo, page));
		model.addObject("regionNo", regionNo);
		model.addObject("page", page);
		
		return model;
		
	} //main();
	
	@RequestMapping("test")
	public ResponseEntity<String> test(HttpSession session, @RequestParam(defaultValue = "3") int no) throws IOException {
		
		Object obj = null;
		
		obj = no;
		
		return JsonUtil.convertToResponseEntity(obj);
		
	} //test();
	
} //class MainController;
