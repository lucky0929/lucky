package org.dateplanner.service;

import java.util.List;

import org.dateplanner.dao.CommentDAO;
import org.dateplanner.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	public void insert(Comment comment) { commentDAO.insert(comment); }
	public void update(Comment comment) { commentDAO.update(comment); }
	public List<Comment> select(int boardNo) { return commentDAO.select(boardNo); }
	public void delete(int no) { commentDAO.delete(no); }

}
