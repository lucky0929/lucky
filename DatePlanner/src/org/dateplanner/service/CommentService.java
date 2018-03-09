package org.dateplanner.service;

import java.util.HashMap;
import java.util.List;

import org.dateplanner.dao.CommentDAO;
import org.dateplanner.vo.Comment;
import org.dateplanner.vo.CommentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	public void insert(Comment comment) { commentDAO.insert(comment); }
	public void update(String content, String no) { commentDAO.update(content, no); }
	public List<CommentResult> select(int boardNo) { System.out.println("해쉬맵 커맨드 VO 생성 완료");return commentDAO.select(boardNo); }
	public void delete(int no) { commentDAO.delete(no); }

	public Comment HashMapToCommentVO(HashMap<String, String> commentMap) {
		System.out.println("헤쉬맵커맨드 VO 생성 중");
		 return new Comment(
				Integer.valueOf((String)commentMap.get("boardNo")),
				Integer.valueOf((String)commentMap.get("userNo")),
				commentMap.get("content"),
				Integer.valueOf((String)commentMap.get("seq")),
				/*Integer.valueOf("parentNo")*/ 1
				 );
	} //HashMapToCommentVO();
} //CommentService

