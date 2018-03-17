package org.dateplanner.service;

import java.util.List;

import org.dateplanner.dao.CommentsDAO;
import org.dateplanner.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	CommentsDAO commentDAO;
	
	public void insertComment(Comment comment){ commentDAO.insertComment(comment); }
	public void insertReply(Comment reply){ commentDAO.insertComment(reply); }
	public List<Comment> selectByBoardNo(int boardNo){ return commentDAO.selectByBoardNo(boardNo);}
	public void updateCommtent(Comment comment) {commentDAO.updateCommtent(comment);}   // boardNo, content
	public void  updateReComment(Comment comment){commentDAO.updateReComment(comment);}   // boardNo, content // boardNo, orderNo, content
	public void  deleteComment(Comment comment){commentDAO.deleteComment(comment);}   // boardNo, content // boardNo, orderNo
	
	
} //class CommentService;
