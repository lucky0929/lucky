package org.dateplanner.service;

import java.util.List;

import org.dateplanner.dao.CommentDAO;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	public Post selectOne(int no) { return boardDAO.selectOne(no); }
	public List<Post> selectAll() { return boardDAO.selectAll(); }
	public List<Post> selectMyPage(int no){ return boardDAO.selectMyPage(no); }
	

}
