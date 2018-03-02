package org.dateplanner.dao;

import java.util.List;

import org.dateplanner.vo.Post;

public interface BoardDAO {
	
	public void insert(Post post);
	public List<Post> selectRegdateDesc(int regionNo);
	public List<Post> selectRegdateAsc(int regionNo);
	public List<Post> searchWithTitle(String title);
	public Post viewOneBoard(int no);
	public int boardCount(int regionNo);
	
	public void delete(int no);
	public void update(Post post);
	
} //interface BoardDAO;
