package org.dateplanner.dao;

import java.util.List;

import org.dateplanner.vo.Post;

public interface BoardDAO {
	
	public boolean insert(Post post);
	public Post selectOne(int no);
	public List<Post> selectAll();
	public List<Post> selectMyPage(int no);
} //interface BoardDAO;
