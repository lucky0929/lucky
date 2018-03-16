package org.dateplanner.controller;

import org.dateplanner.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping(path = { "post", "package" })
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping("commentInsert")
	public String commentInsert(int boardNo, String content) {
		
		return "";
	}
	
	@RequestMapping("commentDelete")
	public String commentDelete(int boardNo, String content) {
		
		return "";
	}
	
	@RequestMapping("commentUpdate")
	public String commentUpdate(int boardNo, String content) {
		
		return "";
	}
	
	@RequestMapping("reCommentInsert")
	public String reCommentInsert(int boardNo, String content) {
		
		return "";
	}
	
} //class CommentController;
