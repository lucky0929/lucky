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
	public void insertReply(Comment reply){ commentDAO.insertComment(reply); }
	public List<Comment> selectByBoardNo(int no, Page page){ return commentDAO.selectByBoardNo(no, page.initTotal(commentDAO.selectCount(no))); }
	public void updateCommtent(Comment comment){ commentDAO.updateCommtent(comment); }
	public void  deleteComment(Comment comment){ commentDAO.deleteComment(comment); }
	
} //class CommentService;