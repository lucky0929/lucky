package org.dateplanner.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dateplanner.vo.Comment;
import org.dateplanner.vo.Page;

public interface CommentsDAO {
	public boolean insertComment(Comment comment);
	public boolean insertReply(Comment reply);
	public List<Comment> selectByBoardNo(@Param(value = "boardNo")int no, @Param(value = "page") Page page);
	public  int	selectCount(int boardNo);
	public void update(Comment comment);
	public void delete(Comment comment);
} //interface CommentsDAO;
