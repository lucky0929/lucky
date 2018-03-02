package org.dateplanner.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.dateplanner.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MainController {
	
	@RequestMapping(path = { "/", "main", "index" })
	public ModelAndView main(HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("main");
		
		model.addObject("postList", boardService.selectRegdateDesc(0));
		
		return model;
		
	} //main();
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(path = "test", params = "no")
	public ResponseEntity<String> test(int no) throws IOException {
		
		Object obj;
		
		obj = boardService.selectRegdateDesc(no);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		return new ResponseEntity<String>(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj), headers, HttpStatus.OK);
		
	} //test();
	
} //class MainController;
