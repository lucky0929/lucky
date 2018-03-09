package org.dateplanner.service;

import java.util.List;

import org.dateplanner.dao.BoardDAO;
import org.dateplanner.vo.Page;
import org.dateplanner.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public boolean write(Post post) { return boardDAO.insertPost(post); }
	public Post selectOne(int no) { return boardDAO.selectByNo(no); }
	
	public List<Post> selectByRegionWithPage(int regionNo, Page page) {
		
		return boardDAO.selectByRegionWithPage(regionNo, page.initTotal(boardDAO.selectTotalByRegion(regionNo)));
		
	} //selectByRegionWithPage();
	
} //class BoardService;
