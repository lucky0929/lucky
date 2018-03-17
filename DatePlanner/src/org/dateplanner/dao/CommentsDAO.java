package org.dateplanner.dao;

import java.util.List;

import org.dateplanner.vo.Comment;

public interface CommentsDAO {

	public boolean insertComment(Comment comment);
	public boolean insertReply(Comment reply);
	public List<Comment> selectByBoardNo(int boardNo);
	public void updateCommtent(Comment comment);   // boardNo, content
	public void  updateReComment(Comment comment); // boardNo, orderNo, content
	public void  deleteComment(Comment comment); // boardNo, orderNo
	
} //interface CommentsDAO;
