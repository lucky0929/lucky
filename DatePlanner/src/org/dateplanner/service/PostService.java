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
	
	public boolean delete(int boardNo) { return boardDAO.delete(boardNo); }
	public boolean update(Post post) { return boardDAO.update(post); }
	public boolean write(Post post) { return boardDAO.insertPost(post); }
	public Post selectOne(int no) { return boardDAO.selectByNo(no); }
	public List<Post> selectByTitleAndRegionWithPage(String title, Page page) {
		int total;
		if((total=boardDAO.selectTotalByTitle(title)) == 0){ return null;}
		else {
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("page", );
//			map.put("title", );
			return boardDAO.selectByTitleAndRegionWithPage(page.initTotal(total), title); 
		} //if~else
	}

	public List<Post> selectByRegionWithPage(int regionNo, Page page) {
		
		return boardDAO.selectByRegionWithPage(regionNo, page.initTotal(boardDAO.selectTotalByRegion(regionNo)));
		
	} //selectByRegionWithPage();
	
} //class BoardService;
