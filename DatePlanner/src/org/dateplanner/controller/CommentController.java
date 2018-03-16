package org.dateplanner.controller;

import org.dateplanner.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping(path = { "post", "package" })
public class CommentController {

	@Autowired
	CommentService commentService;
	
	
	
} //class CommentController;
