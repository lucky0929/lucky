package org.dateplanner.service;

import java.util.HashMap;
import java.util.List;

import org.dateplanner.dao.BoardDAO;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	private Post post;
	
	public List<Post> selectBoard(){
		return boardDAO.selectBoard();
	}
	
	public void insertBoard(Post post) {
		boardDAO.insertBoard(post);
	}
	
}
