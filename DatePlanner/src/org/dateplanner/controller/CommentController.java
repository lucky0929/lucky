package org.dateplanner.controller;

import javax.servlet.http.HttpSession;

import org.dateplanner.service.CommentService;
import org.dateplanner.vo.Comment;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping(path = { "post", "package" })
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping("commentInsert")
	public String commentInsert(int boardNo, String content, HttpSession session) {
		User user = (User)session.getAttribute("loginInfo");
		commentService.insertComment(new Comment(boardNo, user.getNo(),content));
		return "redirect:";
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
