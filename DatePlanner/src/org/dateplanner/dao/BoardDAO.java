package org.dateplanner.dao;

import java.util.List;

import org.dateplanner.vo.Post;

public interface BoardDAO {

	public List<Post> selectBoard();
	public void insertBoard(Post post);
}
