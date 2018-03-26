package org.dateplanner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dateplanner.service.CommentService;
import org.dateplanner.vo.Comment;
import org.dateplanner.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping(path = { "post", "package" })
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping("commentInsert")
	public String commentInsert(int boardNo, String content, HttpSession session, HttpServletRequest req) {
		User user = (User)session.getAttribute("loginInfo");
		commentService.insertComment(new Comment(boardNo, user.getNo(),content));
		return "redirect:view/"+boardNo;
	}
	
	@RequestMapping("reCommentInsert")
	public String reCommentInsert(@ModelAttribute Comment comment, HttpServletRequest req, HttpSession session) {
		User user = (User)session.getAttribute("loginInfo");
		comment.setUser(user);
		commentService.insertReply(comment);
		return "redirect:view/"+comment.getBoardNo();
	}
	
	@RequestMapping(value="commentDelete")
	public String commentDelete(int boardNo, int no, Integer orderNo, HttpServletRequest req) {
		commentService.deleteComment(new Comment(no, orderNo));
		return "redirect:view/"+boardNo;
	}
	
	@RequestMapping("commentUpdate")
	public String commentUpdate(int boardNo, int orderNo, int no,String content, HttpServletRequest req) {	
		commentService.updateCommtent(new Comment(no, orderNo, content));
		return "redirect:view/"+boardNo;
	}
	
} //class CommentController;
	