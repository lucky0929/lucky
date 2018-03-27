package org.dateplanner.service;

import java.util.List;

import org.dateplanner.dao.CommentsDAO;
import org.dateplanner.vo.Comment;
import org.dateplanner.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	CommentsDAO commentDAO;
	
	public void insertComment(Comment comment){ commentDAO.insertComment(comment); }
	public void insertReply(Comment reply){ commentDAO.insertReply(reply); }
	public List<Comment> selectByBoardNo(int no, Page page){ return commentDAO.selectByBoardNo(no, page.initTotal(commentDAO.selectCount(no))); }
	public void updateCommtent(Comment comment){ commentDAO.update(comment); }
	public void deleteComment(Comment comment) {
		if(comment.getNo()==0) 
			 { commentDAO.commentDelete(comment); } 
		else { commentDAO.reCommentDelete(comment);}
		 
	}
	
} //class CommentService;