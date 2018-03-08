package org.dateplanner.service;

import java.util.HashMap;
import java.util.List;

import org.dateplanner.dao.CommentDAO;
import org.dateplanner.vo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	public void insert(Comment comment) { commentDAO.insert(comment); }
	public void update(String content, String no) { commentDAO.update(content, no); }
	public List<Comment> select(int boardNo) { return commentDAO.select(boardNo); }
	public void delete(int no) { commentDAO.delete(no); }

	public Comment HashMapToCommentVO(HashMap<String, String> commentMap) {
		 return new Comment(
				Integer.valueOf((String)commentMap.get("boardNo")),
				Integer.valueOf((String)commentMap.get("userNo")),
				commentMap.get("content"),
				Integer.valueOf((String)commentMap.get("seq")),
				/*Integer.valueOf("parentNo")*/ 1
				 );
	} //HashMapToCommentVO();
} //CommentService

