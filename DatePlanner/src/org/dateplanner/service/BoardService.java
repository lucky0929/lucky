package org.dateplanner.service;

import java.util.List;

import org.dateplanner.dao.BoardDAO;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public boolean write(Post post) { return boardDAO.insert(post); }
	public Post selectOne(int no) { return boardDAO.selectOne(no); }
	public List<Post> selectAll() { return boardDAO.selectAll(); }
	
} //class BoardService;